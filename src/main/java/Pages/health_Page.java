package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.LogUtils;
import utils.TestUtil;

import java.io.IOException;
import java.nio.file.Paths;

public class health_Page extends TestBase {

    public health_Page(Page page) {
        this.page = page;
    }

    String healthInsurance = "//div[text()='Health Insurance']";
    String SelectGender = "//span[text()='Male']";
    String SelectInsuredPerson = "//span[text()='Self']";
    String NextBtn = "//span[text()='Next']//parent::button";
    String Pincode = "//input[@inputmode=\"numeric\"]";
    String date = "//input[@placeholder=\"dd/mm/yyyy\"]";
    String Name = "//input[@placeholder=\"Name\"]";
    String icicselect = "//h5[text()=\"Health AdvantEdge\"]//..//..//..//button";
    String buy = "//span[text()='Buy Now']";
    String MobileNo = "//input[@placeholder=\"Enter mobile number\"]";
    String Mailid = "//input[@placeholder=\"Enter Email Id\"]";
    String ConBtn = "//button[@id=\"continue-button-active\"]";
    String HeightInFeet = "//input[@id=\"insuredMembers.0.height_feet\"]";
    String HeightInInch = "//input[@id='insuredMembers.0.height_inches']";
    String Weight = "//input[@id=\"insuredMembers.0.weight\"]";
    String SelPayOpt = "//span[text()='Online']";
    String occupationdropdown = "//input[@id=\"insuredMembers.0.occupation\"]";
    String NivaAddrLine1 = "//input[@id=\"addrLine1\"]";
    String NivaAddrLine2 = "//input[@id=\"addrLine2\"]";
    String copylink = "//article[text()='Copy Link']//parent::div";
    String copyURLLink = "//article[text()=\"Copy Link\"]";
    String checkmark = "//input[@class=\"ant-checkbox-input\"]";
    String Approve = "//span[text()=\"Approve\"]/parent::button";
    String otp = "//input[@placeholder=\"1234\"]";
    String verifyotp = "//span[text()=\"Verify\"]/parent::button";
    String closecrossbutton = "//button[@aria-label=\"Close\"and @class=\"ant-modal-close\"]";
    String nomineeisMy = "//input[@id=\"proposer.nomineeRelation\"]";
    String nomineenamedetail = "//input[@id=\"proposer.nomineeName\"]";
    String dobdetails = "//input[@id=\"proposer.nomineeDob\"]";
    String pan = "//input[@id=\"proposer.panNo\"]";
    String ContinueBt2 = "//h4[text()='Upload Document']//following ::span[text()='Continue'][1]";
    String radioBT2 = "//h4[text()='Upload Document']";
    String confirmBt = "//button[@type='button']";
    String SubmittedBT = "//span[text()='Submit']";
    String Buywithimmediat = "//span[contains(text(),'Buy with immediate')]";




    public void HealthProfile() throws InterruptedException {
        TestUtil.click(healthInsurance, "health Insurance Selected");
        TestUtil.click(SelectGender, "Gender Selected");
        TestUtil.click(SelectInsuredPerson, "Insured Person Selected");
        TestUtil.click(NextBtn, "Next Button Clicked...");
        Thread.sleep(500);
        TestUtil.click(date, "Date ");
        Thread.sleep(500);
        TestUtil.sendKeys(date, "10/10/1994", "10/10/1994 date");
        Thread.sleep(500);
        TestUtil.sendKeys(date, "Enter", "Date entered");
        Thread.sleep(500);
        TestUtil.click(NextBtn, "Next Date Button Clicked...");
        Thread.sleep(500);
        TestUtil.click(NextBtn, "Diseases Screen Passed");
        TestUtil.sendKeys(Pincode, "400001", "Pincode Entered");
        TestUtil.click(NextBtn, "");// Pin code screen
        TestUtil.sendKeys(Name, "health Test",  " Name Passed on the Lead Name Page");
        TestUtil.click(NextBtn, "");//name screen
        TestUtil.click(Buywithimmediat, "Buy with immediate issuance (18% GST)");//name screen

    }

    public void selectPlan() throws InterruptedException, IOException {
        TestUtil.click(icicselect, "ICICI plan Selected");
        TestUtil.click(buy, "Click Buy Now");
    }

    public void share_payment_link() throws InterruptedException {
        Thread.sleep(500);
        TestUtil.click(copylink, "Copy link clicked");
        String copiedText = page.locator(copyURLLink).getAttribute("data-test-value");
        System.out.println("copied link is " + copiedText);
        TestUtil.click(closecrossbutton, "close share window button");
        page.navigate(copiedText);
    }

    public void do_payment(String Approved_OR_reject) throws InterruptedException {
        page.locator(checkmark).hover();
        TestUtil.click(checkmark, "");
        if (Approved_OR_reject == "A") {
            Thread.sleep(1000);
            page.locator(Approve).hover();
            TestUtil.click(Approve, "");
            //  act.moveToElement(Approve).click().build().perform();
            LogUtils.info("Approve clicked");
            Thread.sleep(2000);
            TestUtil.sendKeys(otp, "1234", "OTP entered");
            TestUtil.click(verifyotp, "verify OTP");
            Thread.sleep(8000);

        } else {

        }
    }

    public static void OvdUploadFile(String YourFileLocationFolder) throws InterruptedException {
        Thread.sleep(2000);
        page.locator("//input[@type=\'file\']").setInputFiles(Paths.get(YourFileLocationFolder));
        Thread.sleep(1000);
    }

    public void OVDdetailsdocumentsnivabupa() throws InterruptedException {
        Thread.sleep(500);
        TestUtil.click(radioBT2, "Clicked on radio button");
        Thread.sleep(500);
        TestUtil.click(ContinueBt2, "Clicked on Continue Button");
        Thread.sleep(500);
        //OvdUploadFile("/home/ubuntu/storage/AadharFrontMotor.png");
        OvdUploadFile("/Users/tejasbahadure/Downloads/AadharFrontMotor.png");
        Thread.sleep(2000);
        LogUtils.info("Aadhar fornt page uploaded");
        //  OvdUploadFile("/home/ubuntu/storage/AadharBackMotor.png");
        OvdUploadFile("/Users/tejasbahadure/Downloads/AadharBackside.png");
        LogUtils.info("Aadhar Back page uploaded");
        Thread.sleep(4000);
        TestUtil.click(SubmittedBT, "clicked submitted");
        Thread.sleep(5000);
        TestUtil.click(confirmBt, "Confirm");
    }

    public void healthCheckoutOVD() throws InterruptedException, IOException {
        OVDdetailsdocumentsnivabupa();
        LogUtils.info("KYC Done");
        TestUtil.sendKeys(MobileNo, "6999912345", "Filling Form, Phone Number Entered");
        TestUtil.sendKeys(Mailid, "test@example.com", "Email Entered");
        TestUtil.sendKeys(NivaAddrLine1, "AddrLine1", "Addr1 Entered");
        TestUtil.sendKeys(NivaAddrLine2, "AddrLine1", "Addr2 Entered");
        TestUtil.click(ConBtn, "Email Entered and Continue Button Clicked");
        Thread.sleep(500);
        TestUtil.sendKeys(pan, "abcde1234a", "pan");
        Thread.sleep(500);
        TestUtil.sendKeys(HeightInFeet, "5", "");
        Thread.sleep(500);
       // TestUtil.sendKeys(HeightInInch, "5", "");
       // Thread.sleep(500);
        TestUtil.sendKeys(Weight, "55", "Weight Provided as 55 Kgs");
        Thread.sleep(500);
        TestUtil.sendKeys(occupationdropdown, "comp", "Selected occupation");
        TestUtil.sendKeys(occupationdropdown, "Enter", "");
        TestUtil.sendKeys(nomineeisMy, "br", "relationship entered");
        TestUtil.sendKeys(nomineeisMy, "Enter", "");
        TestUtil.sendKeys(nomineenamedetail, "auto test test", "nomiee name entered");
        TestUtil.click(dobdetails, "Waiting for payment link....");
        Thread.sleep(1000);
        TestUtil.sendKeys(dobdetails, "12/02/2005", "DOB entered");
        Thread.sleep(500);
        TestUtil.sendKeys(dobdetails, "Enter", "");
        LogUtils.info("clicked checkmar...");
        Thread.sleep(2000);
        TestUtil.click(ConBtn, "Waiting for payment link....");
        Thread.sleep(3000);
        TestUtil.click(ConBtn, "Waiting for payment link....");
        Thread.sleep(2000);
        TestUtil.click(SelPayOpt, "Waiting for payment link....");
        Thread.sleep(500);
        TestUtil.click(ConBtn, "Final continue clicked");
        share_payment_link();
        do_payment("A");
    }

}
