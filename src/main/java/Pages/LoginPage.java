package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.TestUtil;

public class LoginPage extends TestBase {


    String MobileNumber = "//input[@name='mobileNumber']";
    String OTPField = "//input[@class='OTPInput']";
    String GetOTP = "//span[text()='GET OTP']";
    String VerifyOTPBtn = "//span[text()='Verify OTP']";
    String sell = "//span[text()='Sell']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void ValidateLogin(String username, String otp) throws InterruptedException {
        TestUtil.sendKeys(MobileNumber,username,"Mobile Number Entered");
        TestUtil.click(GetOTP,"Continue pressed");
        TestUtil.sendKeys(OTPField,otp,"OTP Entered");
        TestUtil.click(VerifyOTPBtn,"Login Successful");
        Thread.sleep(1000);
    }
    public void sell() throws InterruptedException {
        TestUtil.click(sell,"Sell button");
        Thread.sleep(1000);
    }


}

