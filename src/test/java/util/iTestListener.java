package util;

import base.TestBase;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.TestUtil;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class iTestListener extends TestBase implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        attachScreenshot(TestBase.page);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        attachScreenshot(TestBase.page);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        attachScreenshot(TestBase.page);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed within Success Percentage: " + result.getName());
        attachScreenshot(TestBase.page);
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static void attachScreenshot(Page page) {
        try {
            page.waitForTimeout(2000); // wait to ensure page is loaded
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            Allure.addAttachment("FULL SCREENSHOT " + getTimeStamp(),
                    new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

}
