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

    public void ValidateLogin(String username, String otp) {
        TestUtil.sendKeys(MobileNumber,username,"Mobile Number Entered");
        TestUtil.click(GetOTP,"Continue pressed");
        TestUtil.sendKeys(OTPField,otp,"OTP Entered");
        TestUtil.click(VerifyOTPBtn,"Login Successful");
    }
    public void sell()  {
        TestUtil.click(sell,"Sell button");
    }


}

