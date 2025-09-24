package Pages;

import base.TestBase;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Ninja extends TestBase {

    public Ninja(Page page) {
        this.page = page;
    }
    
    String SignInbtn = "//span/a[@id='google-signin-button']";
    String Employe = "//input[@type='email']";
    String Nextbtn1 = "//span[text()='Next']";
    String Password = "//input[@type='password']";
    String Nextbtn2 = "//div[@id='passwordNext']";
    String emailgoogle = "//input[@type='email']";
    String passworgoogle = "//input[@type='password']";

    BrowserContext contextt;
    Page pagee;
    
    public void liginNinja() throws InterruptedException, FindFailed {
//        page.navigate("https://ninja.turtlemintinsurance.com/");
//        Page currentTab = page;
//        Thread.sleep(3000);
//
//        Page googleWindow = context.waitForPage(() -> {
//            page.click(SignInbtn);
//        });
//        googleWindow.bringToFront();
//        googleWindow.waitForTimeout(3000);
//        googleWindow.fill(Employe, "automationtesting@turtlemint.com");
//        googleWindow.click("text=Next");
//        Thread.sleep(3000);
//        googleWindow.fill(Password, "Turtle@2025");
//        googleWindow.click("text=Next");
//        Thread.sleep(5000);
//        page.bringToFront();
//        Thread.sleep(3000);
//        for (Frame frame : page.frames()) {
//            System.out.println("Frame name: " + frame.name() + ", URL: " + frame.url());
//        }

        page.navigate("https://ninja.insurance.jkbank.com/mis/add-sale/MIS_PHQ7R4YLD8J");
        Thread.sleep(60000);

        Screen screen = new Screen();
        Thread.sleep(5000);

        Pattern accountOption = new Pattern("sale.png");

        // Wait for it to appear and click
        screen.wait(accountOption,40);
        screen.click();
        screen.click();
        Thread.sleep(15000);

    }

}
