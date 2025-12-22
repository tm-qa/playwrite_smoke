package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.LogUtils;
import utils.TestUtil;

public class TW_page extends TestBase {

    public TW_page(Page page) {
        this.page = page;
    }

    String regdate = "#registrationDate-datepicker";
    String RegistrationNumberField = "//input[@type='text']";
    String GetQuoteBtn = "//button[@ng-click=\"withVehicleNumber(registrationNumber)\"]";
    String WithoutRegNumberLink = "//div[text()='Quote without vehicle number']";
    String NextButton = "#container-next-btn";
    String crrdate = "//td[contains(@class,\"current-day\")]";
    String reli = "//a[@data-auto=\"RELI-web\"]";
    String GotItBtn = "//div[text()='Got It!']";
    String SelectTWModel = "//span[@class='ng-binding ng-scope'][normalize-space()='Honda Activa']";
    String cofirm = "//button[@data-auto=\"confirm-btn\"]";
    String name = "//input[@id='customerName']";
    String ClickVariant = "//div[@placeholder='Type name or select']//span[@aria-label='Select box activate']";
    String SelectTWVariant = "//span[contains(text(),'5G Deluxe (110 CC)')]";
    String SelectTWVariant2 = "//span[contains(text(),'Disc Brake Alloy Wheel BS VI (125 CC)')]";
    String SelectTWVariant5g110cc = "//span[contains(text(),'5G (110 CC)')]";
    String comp = "//span[text()='Comprehensive']";
    String no = "//span[text()='Made any claims in previous year?']//..//..//..//span[text()='No']";
    String zero = "//span[text()='0%']";
    String PP = "(//input[@ng-show=\"$select.open\"])[2]";
    String date = "//input[@placeholder=\"dd/mm/yyyy\"]";
    String curr = "//td[contains(@class,\"today\")]";
    String ProceedtoBuy = "//button[@data-auto=\"confirm-btn\"] | //span[text()='Confirm']";
    String title = "(//*[@class=\"btn btn-default form-control ui-select-toggle\"])[1]";
    String mr = "(//*[text()=\"Mr\"])[1]";
    String fn = "id=firstName";
    String ln = "id=lastName";
    String email = "id=email";
    String mbl = "id=mobile";
    String address = "//input[@id='registeredAddressLine1']";
    String Adressline2 = "//input[@name='registeredAddressLine2']";
    String continu = "//*[text()=\"Continue\"]";
    String pin = "//div[@id='registeredPincode-uiSelect']";
    String Pincode = "(//div[@id='registeredPincode-uiSelect']/input)[1]";
    String SelectPincode = "//span[text()='400065']";
    String male = "//input[@id=\"gender-M\"]//parent::label";
    String dobpicker = "id=dob-datepicker";
    String SelectNomineeRelation = "//span[text()='Mother']";
    String Nominee = "//div[@id='nomineeRel-uiSelect']";
    String NomineeName = "//input[@name='nomineeName']";
    String NomineeDOB = "//input[@name='nomineeDOB-datepicker']";
    String DateSelected = "//a[normalize-space()='12']";
    String online = "//*[text()=\"Online\"]";
    String makepayment = "//*[text()=\"Make Payment\"]";
    String credidordebitcard = "//*[text()=\"Credit Card/Debit Card\"]";
    String IndividualSelect = "//input[@value='true']";
    String DOBField = "//input[@id='kyc-form_dob']";
    String PanNo = "//input[@id='kyc-form_pan']";
    String ContinueBtn = "(//span[text()='Continue'])[1]";
    String KYCconfirm = "//span[text()='Confirm']";
    String enginno = "//*[@id='engineNum']";
    String chassisno = "//*[@name='chassisNum']";


    public void CreateQuoteWithRegNumber(String num) throws InterruptedException {
        TestUtil.sendKeys(RegistrationNumberField, num, "GJ05PU5256 RegNumber Entered");
        TestUtil.click(GetQuoteBtn, "Get Quote");
        TestUtil.sendKeys(regdate, "27/11/2023", "");
        Thread.sleep(2000);
        TestUtil.sendKeys(regdate, "Enter", "");
        Thread.sleep(2000);
        TestUtil.sendKeys(regdate, "Enter", "");
        Thread.sleep(500);
        TestUtil.click(crrdate, "date select ");
        Thread.sleep(2000);
        TestUtil.click(NextButton, "Next button");
        TestUtil.click(ClickVariant, " ClickVariant Clicked");
        TestUtil.click(SelectTWVariant2, " selected");
        TestUtil.click(NextButton, " NextButton");
        Thread.sleep(500);
        TestUtil.click(comp, " comp select");
        TestUtil.click(NextButton, " NextButton");
        TestUtil.sendKeys(date, TestUtil.PresentDate(), TestUtil.PresentDate() + " date Select");
        TestUtil.click(curr, "");
        Thread.sleep(1500);
        TestUtil.click(comp, " comp select");
        TestUtil.click(no, " no select");
        TestUtil.click(zero, " 0 select");
        TestUtil.sendKeys(PP, "acko", "Acko");
        Thread.sleep(500);
        TestUtil.sendKeys(PP, "Enter", "Reli");
        TestUtil.click(NextButton, " NextButton");

    }

    public void SaveLead(String LeadName) throws InterruptedException {
        TestUtil.sendKeys(name, LeadName, "Lead Name entered");
        TestUtil.click(NextButton, "Next Button");
    }

    public void SelectTWPlan() {
        try {
            TestUtil.click(GotItBtn, "GotIt Btn");
        } catch (Exception E) {
            System.out.println("GotIt button not displayed");
        }
        TestUtil.click(reli, "Reli plan");
        TestUtil.click(cofirm," Confirm Btn");
    }

    public void KycFormFilling() throws InterruptedException {
        Thread.sleep(7000);
        LogUtils.info("KYC Start");
        TestUtil.click(IndividualSelect, "");
        TestUtil.click(DOBField, "DOB Field Clicked");
        TestUtil.sendKeys(DOBField, "02/05/2000", "DOB Entered");
        TestUtil.sendKeys(PanNo, "BNUPT2084B", "Pan Number Entered");
        TestUtil.click(ContinueBtn, "KYC Form Filled Successfully and Continue Button pressed");
        Thread.sleep(1000);
        LogUtils.info("Waiting for fetch the details");
        TestUtil.click(KYCconfirm, "KYC confirm clicked");
    }

    public void CheckoutTW() throws InterruptedException {
        try {
            TestUtil.click(ProceedtoBuy, "confirm to Buy");
        }
        catch (Exception e){
            System.out.println("confirm to buy not displayed");
        }
        KycFormFilling();
        LogUtils.info("KYC Done");
        TestUtil.click(title, "title Btn");
        Thread.sleep(500);
        TestUtil.click(mr, "mr Btn");
        Thread.sleep(500);
        TestUtil.sendKeys(email, "test@example.com", "Email entered");
        Thread.sleep(500);
        TestUtil.sendKeys(mbl, "6999912345", "Email entered");
        Thread.sleep(500);
        TestUtil.click(pin, "pin Btn");
        Thread.sleep(1000);
        TestUtil.click(pin, "pin Btn");
        Thread.sleep(1000);
        TestUtil.sendKeys(Pincode, "400065", "Pincode entered");
        Thread.sleep(1000);
        TestUtil.click(SelectPincode, "SelectPincode Btn");
        Thread.sleep(1000);
        TestUtil.sendKeys(address, "address1", "Pincode entered");
        TestUtil.sendKeys(Adressline2, "address23", "Pincode entered");
        Thread.sleep(500);
        TestUtil.click(continu, "continue clicked");
        Thread.sleep(2000);
        TestUtil.click(male, "Male clicked");
        TestUtil.sendKeys(dobpicker, "12/02/1994", "Dob select");
        Thread.sleep(2000);

        try {
            TestUtil.sendKeys(NomineeDOB, "Enter", "DOB entered");
            Thread.sleep(1000);
            TestUtil.sendKeys(NomineeDOB, "12/02/1988", "DOB entered");
            //  TestUtil.click(DateSelected, "Date Selected");
            TestUtil.click(Nominee, "Nominee Selected");
            TestUtil.click(SelectNomineeRelation, "Nominee Relation Selected");
            TestUtil.sendKeys(NomineeName, "Test", "Nomine Name Entered");
            Thread.sleep(2000);
        } catch (Exception e) {
            Thread.sleep(2000);
        }
        TestUtil.click(continu, "continue clicked");
        TestUtil.sendKeys(enginno, "230620221135YES", "enginno Entered");
        Thread.sleep(1000);
        TestUtil.sendKeys(chassisno, "230620221135YESOK", "chassisno select");
        Thread.sleep(2000);
        TestUtil.click(continu, " continue clicked 1st");
        Thread.sleep(5000);
        try {
            TestUtil.click(continu, " continue clicked 2nd");
        } catch (Exception e) {
        }
        TestUtil.click(online, "Online clicked");
        Thread.sleep(1000);
        TestUtil.click(makepayment, "make payment clicked");
        Thread.sleep(2000);
    }

}

