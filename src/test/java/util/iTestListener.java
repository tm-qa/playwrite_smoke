package util;

import base.TestBase;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LogUtils;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class iTestListener extends TestBase implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("************  The name of the testcase Passed is :"+result.getName()+"  *************");
        // attachScreenshotSafe("PASS: " + result.getName(), TestBase.page);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("************  The name of the testcase failed is :"+result.getName()+"  *************");
        //  attachScreenshotSafe("FAIL: " + result.getName(), TestBase.page);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("************  The name of the testcase Skipped is :"+result.getName()+"  *************");
        //  attachScreenshotSafe("SKIP: " + result.getName(), TestBase.page);
    }

    private void attachScreenshotSafe(String name, Page page) {
        try {
            Allure.step("Attaching screenshot: " + name, () -> {
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
                Allure.addAttachment(name + " " + getTimeStamp(),
                        new ByteArrayInputStream(screenshot));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
