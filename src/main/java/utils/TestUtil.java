package utils;

import base.TestBase;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class TestUtil extends TestBase {

    public static void click(String xpath, String msg) {
        page.locator(xpath).click();
        LogUtils.info(msg);
    }

    public static void sendKeys(String xpath, String value, String msg) {
        page.locator(xpath).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE).setTimeout(15000));


        if (isSpecialKey(value)) {
            page.locator(xpath).press(value);
        } else {
            page.locator(xpath).fill(value);
        }
        LogUtils.info(msg);
    }

    public static void IsDisplayed(String xpath, String locator) {
        page.locator(xpath).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE).setTimeout(15000));

    }

//    private static String getTimeStamp() {
//        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//    }
//    @Attachment(value = "Page Screenshot", type = "image/png")
//    public static void getFullPageScreenShot(Page page) {
//        try {page.waitForTimeout(5000);
//            byte[] screenshot = page.screenshot(
//                    new Page.ScreenshotOptions().setFullPage(true)
//            );
//            Allure.addAttachment("FULL SCREENSHOT " + getTimeStamp(),
//                    new ByteArrayInputStream(screenshot));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    private static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static void getFullPageScreenShot(Page page) {
        try {
            if (page != null) {
                page.waitForTimeout(1000); // ensure page is loaded
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
                Allure.addAttachment("FULL SCREENSHOT " + getTimeStamp(),
                        new ByteArrayInputStream(screenshot));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSpecialKey(String value) {
        return value.equalsIgnoreCase("Enter")
                || value.equalsIgnoreCase("Tab")
                || value.equalsIgnoreCase("ArrowDown")
                || value.equalsIgnoreCase("ArrowUp")
                || value.equalsIgnoreCase("Escape")
                || value.equalsIgnoreCase("Backspace")
                || value.equalsIgnoreCase("Shift")
                || value.equalsIgnoreCase("Control")
                || value.equalsIgnoreCase("Alt");
    }

    public static void jsClick(String xpath,String mess) {
        page.locator(xpath).evaluate("element => element.click()");
        LogUtils.info("Clicked using JS: " + mess);
    }

    public static String PresentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);

    }

    public String firstname;
    public String lastname;
    public String full_name;
    public String RegNo;

    public String NameGenerator() {
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        firstname = firstname.replaceAll("[^a-zA-Z0-9]", " ");
        lastname = faker.name().lastName();
        lastname = lastname.replaceAll("[^a-zA-Z0-9]", " ");
        full_name = firstname + " " + lastname;
        full_name = full_name.replaceAll("[^a-zA-Z0-9]", " ");
        return full_name;
    }

    public void GenerateRegNo() {
        int alpha1 = 'A' + (int) (Math.random() * ('Z' - 'A'));
        int alpha2 = 'A' + (int) (Math.random() * ('Z' - 'A'));
        int digit1 = (int) (Math.random() * 10);
        int digit2 = (int) (Math.random() * 10);
        int digit3 = (int) (Math.random() * 10);
        int digit4 = (int) (Math.random() * 10);
        RegNo = ("MH01" + (char) (alpha1) + ((char) (alpha2)) +
                +digit1 + digit2 + digit3 + digit4);
        System.out.println(RegNo + "IN test UTIL");
    }

}