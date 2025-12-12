package util;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.TestUtil;

import java.io.ByteArrayInputStream;

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
        attachScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        attachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        attachScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed within Success Percentage: " + result.getName());
        attachScreenshot();
    }

    /**
     * Capture full-page screenshot and attach to Allure
     */
    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] attachScreenshot() {
        try {
            if (page != null) {
                // Wait for any page animations or loading
                page.waitForTimeout(2000);

                byte[] screenshot = page.screenshot(
                        new com.microsoft.playwright.Page.ScreenshotOptions().setFullPage(true)
                );

                // Attach to Allure
                Allure.addAttachment("FULL PAGE SCREENSHOT", new ByteArrayInputStream(screenshot));

                return screenshot;
            } else {
                System.out.println("Page is null — cannot capture screenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
