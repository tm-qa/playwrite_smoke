//package base;
//
//import com.microsoft.playwright.*;
//
//public class TestBase {
//        public static Playwright playwright;
//        public static Browser browser;
//        public static BrowserContext context;
//        public static Page page;
//
//        public void initialization() {
//            playwright = Playwright.create();
//            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            context = browser.newContext();
//            page = context.newPage();
//            page.navigate("https://app.mintpro.in/signup");
//        }
//    }
//
//

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
     //   String appUrl = prop.getProperty("url");
     //   LogUtils.info("App URL: " + appUrl);

        // Create Playwright instance
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false); // default for local

        // If running on Linux/Jenkins, switch to headless mode
        String osName = System.getProperty("os.name").toLowerCase();
        LogUtils.info("OS Name: " + osName);
        if (osName.contains("linux")) {
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

        // Create context & page
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1200, 800)); // window size
        page = context.newPage();

        // Navigate to app
        page.navigate("https://app.mintpro.in/signup");

      //  LogUtils.info("Navigation completed to " + appUrl);
    }

//    public static void tearDown() {
//        if (page != null) page.close();
//        if (context != null) context.close();
//        if (browser != null) browser.close();
//        if (playwright != null) playwright.close();
//    }
}
