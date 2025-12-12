package base;

import com.microsoft.playwright.*;
import utils.LogUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
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
//        String appUrl = prop.getProperty("url");
//        LogUtils.info("App URL: " + appUrl);

        // Create Playwright instance
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false); // always non-headless

        // On Linux/Jenkins: need Xvfb to run headed
        String osName = System.getProperty("os.name").toLowerCase();
        LogUtils.info("OS Name: " + osName);
        if (osName.contains("linux")) {
            LogUtils.info("Running on Linux — make sure Xvfb is installed for non-headless mode");
            options.setArgs(java.util.Arrays.asList(
                    "--disable-gpu",
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--window-size=1200,800"
            ));
        }

        // Launch browser
        browser = playwright.chromium().launch(options);

        // Create context & page
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1200, 800));

        page = context.newPage();

        // Navigate to application
        page.navigate("https://app.turtlemintpro.com");
    }


}
