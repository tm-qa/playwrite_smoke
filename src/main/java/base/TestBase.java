package base;

import com.microsoft.playwright.*;
import utils.LogUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/qa/turtlemint/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String appUrl = "https://app.turtlemintpro.com";
        LogUtils.info("App URL: " + appUrl);

        // Create Playwright instance
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();

        // Default: non-headless for local
        options.setHeadless(false);

        // Detect Linux/Jenkins environment
        String osName = System.getProperty("os.name").toLowerCase();
        LogUtils.info("OS Name: " + osName);
        if (osName.contains("linux")) {
            LogUtils.info("Running on Linux — switching to headless mode");
            options.setHeadless(true);
            options.setArgs(java.util.Arrays.asList(
                    "--disable-gpu",
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--window-size=1200,800"
            ));
        }

        // Launch browser
        browser = playwright.chromium().launch(options);

        // Create context with viewport size
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1200, 800));

        // Create page
        page = context.newPage();

        // Navigate to app
        page.navigate(appUrl);
        LogUtils.info("Navigation completed to " + appUrl);
    }

}
