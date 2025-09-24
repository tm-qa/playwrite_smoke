package Pages;

import base.TestBase;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import utils.LogUtils;
import utils.TestUtil;

public class life_page extends TestBase {

    public life_page(Page page) {
        this.page = page;
    }

    String SmokeChewTobacco = "//label[@id='Radio-false']";
    String Next = "//span[normalize-space()='Next']";
    String LeadName = "//input[@name='customerName']";
    String Pincode = "//input[@placeholder='Pincode']";
    String SelectOccupation = "//span[text()='Select Occupation']";
    String Selfemployed = "//li[text()='Salaried']";
    String SelectEducationalQualification = "//span[text()='Select Educational Qualification']";
    String Graduateandabove = "//li[text()='Graduate and above']";
    String coveramt = "//div[@name=\"coverAmount\"]";
    String coveramtselect = "//li[@value=\"15000000\"]";
    String dateselect_5Aug = "//div[@aria-label=\"Choose Wednesday, August 5th, 1992\"]";
    String termLifeButton = "//p[text()='Term Insurance']";
    String GenderButton = "//label[@id='Radio-M']";
    String calender = "//input[@placeholder=\"Enter Date\"]";
    String yearselect = "//option[@value=\"2000\"]//parent::select";
    String monthselect = "//option[@value=\"2\"]//parent::select";
    String bajajplan = "//button[@id=\"listItem-P31-viewDetails\"]";
    String BuyNow = "//button[@id='details-page-buy-now-btn']";
    String closePopup = "//*[@data-icon=\"close\"]";
    String lastname = "//input[@id='insuredMemberLName']";
    String email = "//input[@id='insuredMemberEmail']";
    String mobile = "//input[@id='insuredMemberMobile']";
    String Adress1 = "//input[@id=\"insuredMemberRegisteredAddress1\"]";
    String Adress2 = "//input[@id=\"insuredMemberRegisteredAddress2\"]";
    String insuredMemberQualification = "//input[@id=\"insuredMemberQualification\"]";
    String insuredMemberOccupation = "//input[@id=\"insuredMemberOccupation\"]";
    String pan = "//input[@id=\"insuredMemberPanNumber\"]";
    String checkmark = "(//input[@enterfn=\"userApprovalDisclaimerEnterFn\"]//..//..)[1]";
    String Paypremium = "//span[text()='Pay Premium']";
    String submitandproceed = "//button[@id=\"continue-button-active\"]";


    public void datepicker(String year, String Month, String Date) throws InterruptedException {
        TestUtil.click(calender, "caleder select");
        Locator yearSelect = page.locator(yearselect);
        yearSelect.selectOption(new SelectOption().setLabel(year));
        Thread.sleep(500);
        Locator monthSelect = page.locator(monthselect);
        monthSelect.selectOption(new SelectOption().setLabel(Month));
        Thread.sleep(500);
        TestUtil.click(Date, "5 aug date select");
    }

    public void LifeRedirection() throws Exception {
        TestUtil.click(termLifeButton, "Term LifeButton");
        TestUtil.click(GenderButton, "Selected gender");
        datepicker("1992", "Aug", dateselect_5Aug);
        TestUtil.click(SmokeChewTobacco, "Smoke Chew Tobacco");
        TestUtil.sendKeys(Pincode, "400001", "Pincode Entered");
        Thread.sleep(500);
        TestUtil.click(Next, "Next clicked");
        TestUtil.click(SelectOccupation, "SelectOccupation");
        TestUtil.click(Selfemployed, "Salaried");
        TestUtil.click(SelectEducationalQualification, "SelectEducationalQualification");
        TestUtil.click(Graduateandabove, "Graduateandabove");
        TestUtil.click(coveramt, "coveramt clicked");
        TestUtil.click(coveramtselect, "1.5 cr coveramt clicked");
        TestUtil.click(Next, "Next clicked");
        TestUtil.sendKeys(LeadName, "Life Test", "Lead Name entered");
        TestUtil.click(Next, "Next clicked");
    }
    public void LifeCheckoutPage() throws Exception {
        TestUtil.click(bajajplan,"Bajaj plan select");
        LogUtils.info("Waiting to click BuyNow..");
        Thread.sleep(500);
        TestUtil.click(closePopup,"Close Popup");
        TestUtil.click(BuyNow,"Buy Now");
        TestUtil.sendKeys(lastname,"test","last name entered");
        TestUtil.sendKeys(mobile,"6888812345","mobile entered");
        TestUtil.sendKeys(email,"test@test.com","email entered");
        TestUtil.click(insuredMemberQualification,"");
        Thread.sleep(500);
        TestUtil.sendKeys(insuredMemberQualification,"Enter","");
        TestUtil.click(insuredMemberOccupation,"");
        Thread.sleep(500);
        TestUtil.sendKeys(insuredMemberOccupation, "Enter","");
        TestUtil.sendKeys(pan,"ABCDE1234A","ABCDE1234A pan entered");
        Thread.sleep(500);
        TestUtil.sendKeys(Adress1,"flat no Address 1 i select","Adress 1 entered");
        TestUtil.sendKeys(Adress2,"Address 2 is select","Adress 2 entered");
        TestUtil.click(checkmark,"checkmark  Checked");
        Thread.sleep(500);
        TestUtil.click(submitandproceed,"Submit Button Clicked");
        TestUtil.click(Paypremium,"pay premium clicked");
    }

}
