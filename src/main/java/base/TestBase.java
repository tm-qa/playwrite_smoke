package base;

import com.microsoft.playwright.*;

public class TestBase {
        public static Playwright playwright;
        public static Browser browser;
        public static BrowserContext context;
        public static Page page;

        public void initialization() {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
            page.navigate("https://app.mintpro.in/signup");
        }
    }
