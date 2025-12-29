package Pages.OneApi_Page;

import base.TestBase;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.LogUtils;
import utils.TestUtil;

import java.io.IOException;
import java.util.ArrayList;

public class oneApi extends TestBase {
    public oneApi(Page page) {
        this.page = page;
    }

    String sell = "//span[text()='Sell']";
    String SellBtn = "(//span[text()='Sell'])[1]";
    String GetStartedButton = "//span[text()='Get Started']";
    String BusinessName = "//input[@name='businessName']";
    String BusinessType = "//span[text()='Business Type *']";
    String BusinessTypeProprietor = "//li[text()='Sole Proprietorship']";
    String LoanAmount = "//input[@name='amount']";
    String BusinessAge = "//span[text()='Business Age *']";
    String BusinessAgeOption = "//li[text()='2 - 4 yrs']";
    String GSTNo = "//label[text()='Do you have GST registration? *']//parent::div//label[@id='Radio-NO']";
    String OwnOfficeNo = "//label[text()='Do you own this office? *']//parent::div//label[@id='Radio-NO']";
    String FirstName = "//input[@name='firstName']";
    String LastName = "//input[@name='lastName']";
    String PAN = "//input[@name='pan']";
    String Gender = "//span[text()='Gender *']";
    String Male = "//li[text()='Male']";
    String Email = "//input[@name='emailId']";
    String Mobile = "//input[@name='mobile']";
    String SubmitButton = "//span[text()='Submit']//parent::button";
    String Address = "//input[@name='address']";
    String Pincode = "//input[@name='pinCode']";
    String Oship = "//label[text()='Resident Ownership *']//parent::div//label[@id='Radio-NO']";
    String DOB = "//input[@placeholder='Date Of Birth (as per PAN card) *']";
    String Thankyoupage = "//span[text()='Thank you for submitting your lead. Our operation team will contact you within 24 hours!']";
    String otp = "//input[@placeholder='12345']";
    String submit2 = "(//span[text()='Submit'])[2]";
    String chkbtn = "(//input[@type='checkbox'])[2]";
    String calender = "//input[@placeholder='Date Of Birth *']";
    String monthselect = "//option[@value='8']//parent::select";
    String yearselect = "//option[@value='1995']//parent::select";
    String Date = "//div[@aria-label='Choose Tuesday, October 10th, 1995']";
    String CreditCard = "(//p[normalize-space()='Credit Cards'])";
    String RSA = "(//p[normalize-space()='Roadside Assistance'])";
    String LAMFcta = "//p[normalize-space()='Loans Against Mutual Funds']";
    String BL = "(//p[normalize-space()='Business Loans'])";
    String Generatelink = "//p[text()='Generate loan application link to share with your clients']//parent::div//button[@type='button']";
    String redirection = "//div[@class='redirectionLink']";
    String Getlone4 = "//h1[text()='Get started now to achieve financial freedom']//parent::div//button";
    String Fullname = "//input[@placeholder=\"Owner's Full Name\"]";
    String fullnnamedetails = "//input[@placeholder='Full Name *']";
    String Emaildetails = "//input[@placeholder='Email *']";
    String Mobiledetsils = "//input[@placeholder='Mobile *']";
    String Pandetsils = "//input[@placeholder='PAN Card *']";
    String SubmitBTA = "//span[text()='Submit']//parent::button";
    String startSellingBtn = "(//span[contains(text(),'Start Selling')])";
    String PAN1 = "//input[@id='input-21']";
    String Mobile1 = "//input[@id='input-17']";
    String Pincode1 = "//input[@id='input-25']";
    String salary = "//input[@id='input-35']";
    String emplymentType = "//input[@id='input-29']";
    String salaried = "//div[text()='Salaried']";
    String confirm = "//input[@id='input-38']";
    String check_eligibility = "//abbr[text()=' Check Eligiblity ']";
    String check_status = "//abbr[text()=' Check Status ']";
    String GetStart = "//span[text()='Get Started']";
    String SubmittedLead = "//span[text()='2 Wheeler Roadside Assistance']//parent::span//parent::div//parent::div//parent::div//button";
    String Checkbox = "//span[@class='MuiIconButton-label']";
    String Mobilenumber = "//input[@placeholder=\"Owner's Mobile No.\"]";
    String Owneremail = "//input[@placeholder=\"Owner's Email\"]";
    String Vehiclenumber = "//input[@placeholder=\"Vehicle Number\"]";
    String Vinnumber = "//input[@placeholder=\"VIN\"]";
    String Vehiclemake = "//input[@placeholder=\"Vehicle Make\"]";
    String SubmitBT = "//span[text()='Submit']";
    String Model = "//input[@placeholder='Model']";
    String city = "//input[@name=\"city\"]";
    String state = "//input[@name=\"state\"]";
    String Paynow = "//span[text()='Pay Now']";
    String Paywith = "//h3[text()='UPI QR']";
    String PersonalLoan = "//p[.='Personal Loans']";
    String HomeLoan = "//p[.='Home Loans']";
    String PersonalLoanPage = "//p[text()='Elevate Your Earnings with']//..//p[text()='Personal Loans']";
    String HomeLoanPage = "//p[text()='Offer Home Loans']";
    String dateselect ="//div[contains(@class,\"004\")]";

    public void alldetsils_entering() throws IOException, InterruptedException {
        TestUtil.click(Getlone4, "Clikced getlone3CTA..");
        TestUtil.sendKeys(fullnnamedetails, "Automation test", "entering full name..");
        TestUtil.sendKeys(Emaildetails, "Automationtest@gmail.com", "enterting email...");
        TestUtil.sendKeys(Mobiledetsils, "9767884048", "enterting mobile....");
        TestUtil.sendKeys(Pandetsils, "BBEPC4531L", "entering pan ....");
        datepicker("1995", "Oct", Date);
        TestUtil.click(SubmitBTA, "clicked submit Button...");
        TestUtil.getFullPageScreenShot(page);
    }

    public void datepicker(String year, String Month, String Date) throws InterruptedException {
        TestUtil.click(calender, "caleder select");
        TestUtil.click(dateselect," date select");
//        Locator yearSelect = page.locator(yearselect);
//        yearSelect.selectOption(year);
//        Thread.sleep(500);
//        Locator monthSelect = page.locator(monthselect);
//        monthSelect.selectOption(Month);
//        Thread.sleep(500);
//        TestUtil.click(Date, "10 oct date select");
//        Thread.sleep(500);
    }

    public void To_VerifyRAZPay_TC67() throws InterruptedException {
        TestUtil.click(GetStart, "Clicked get start button");
        TestUtil.click(SubmittedLead, "Clikced submitted lead button");
        TestUtil.sendKeys(Fullname, "Automation test", "entering name");
        TestUtil.sendKeys(Mobilenumber, "6999912345", "Entering mobile number");
        TestUtil.sendKeys(Owneremail, "Automationtest@gmail.com", "Entring emil");
        TestUtil.sendKeys(Vehiclenumber, "MH03BF3434", "Entering vecicle numaer");
        TestUtil.sendKeys(Vinnumber, "3434344", "Entering VIN number");
        TestUtil.sendKeys(Vehiclemake, "2020", "entering mode modeal");
        TestUtil.sendKeys(Model, "HONDA", "Entering modeal");
        TestUtil.click(Checkbox, "Clicked checkbox");
        TestUtil.click(SubmitBT, "Clicked submit button");
        Thread.sleep(2000);
        TestUtil.click(Paynow, "Clicked paynow CTA");
        Thread.sleep(2000);
      //  driver.get().switchTo().frame(2);

        Frame frame = page.frames().get(2);

//        String ActualAmountPA =  Paywith.getText();
//        System.out.println(ActualAmountPA);
//        Assert.assertTrue(Paywith.isDisplayed());
        Thread.sleep(500);
        frame.locator(Paywith);
      //  TestUtil.IsDisplayed(Paywith, "payment popup displayed");


    }

    public void Genaratelink() throws InterruptedException {
        Thread.sleep(3000);
        TestUtil.click(Generatelink, "Clicked generate link clicked");
        Thread.sleep(2000);
        String link = page.locator(redirection).textContent();

        Page newPage = page.waitForPopup(() -> {
            page.evaluate("window.open()");
        });

        newPage.bringToFront();
        newPage.navigate(link);
        Thread.sleep(5000);
        newPage.locator(Getlone4).click();
        newPage.locator(fullnnamedetails).fill("Automation test");
        newPage.locator(Emaildetails).fill("Automationtest@gmail.com");
        newPage.locator(Mobiledetsils).fill("9767884048");
        newPage.locator(Pandetsils).fill("BBEPC4531L");


        newPage.locator(calender).click();
        Thread.sleep(2000);
        newPage.locator(dateselect).click();
        newPage.locator(SubmitBTA).click();

    }

    public void To_verify_redirectingtoBankPage() throws InterruptedException {
        Thread.sleep(2000);
        TestUtil.click(GetStartedButton, "Clicked On Get Started Button");
        TestUtil.sendKeys(BusinessName, "automationtest", "entering name");
        TestUtil.click(BusinessType, "Clicking On Business Type");
        TestUtil.click(BusinessTypeProprietor, "Selecting Business Type");
        TestUtil.sendKeys(LoanAmount, "500000", "Entering Loan Amount");
        TestUtil.click(BusinessAge, "Clicking on Business Age");
        TestUtil.click(BusinessAgeOption, "Selecting Business Age");
        TestUtil.click(GSTNo, "Clicked GST number as a NO");
        TestUtil.click(OwnOfficeNo, "Clicked Own office number as a NO");
        TestUtil.sendKeys(FirstName, "automation", "Entering first name");
        TestUtil.sendKeys(LastName, "automation", "Entering first name");
        TestUtil.sendKeys(PAN, "GUNPK4456G", "Entering pan number");
        TestUtil.click(Gender, "clicked genger");
        TestUtil.click(Male, "Clicked male");
        TestUtil.click(DOB, "");
        SelectDate("1995", "3", "14");
        TestUtil.sendKeys(Email, "Automationtest@gmail.com", "Entering email");
        // TestUtil.sendKeys(Mobile,"9676843556","Entering mobile number");
        TestUtil.sendKeys(Mobile, "6888812345", "Entering mobile number");

        TestUtil.sendKeys(Address, "Pune", "Entering address");
        TestUtil.sendKeys(Pincode, "411001", "Entering pincode");
        TestUtil.sendKeys(city, "pune", "pune ");
        TestUtil.sendKeys(state, "maharastra", "maharastra ");
        TestUtil.click(Oship, "clickced ownership");
        TestUtil.click(SubmitButton, "clicked submit button");
        Thread.sleep(1500);
        TestUtil.click(otp, "click on otp");
        Thread.sleep(1500);
        page.locator(otp).fill("");

        Thread.sleep(1500);
        TestUtil.sendKeys(otp, "1234", "entering otp");
        Thread.sleep(1500);
        page.locator(chkbtn).evaluate("el => el.click()");



        // TestUtil.click(chkbtn1,"click");
        Thread.sleep(2000);
        TestUtil.click(submit2, "click on submit 2");
        // TestUtil.IsDisplayed(invalid_otp_error,"error msg displayed as we enetred 1234 otp for 9676843556 ");

        // commenting this since other than 699 number needed for otp and we cant automate this
//        String CU =  Thankyoupage.getText();
//        System.out.println(CU);
        Thread.sleep(2000);
        //  Assert.assertTrue(Thankyoupage.isDisplayed());
//        Thankyoupage.isDisplayed();
        TestUtil.IsDisplayed(Thankyoupage,"");


    }

    public void SellTab() throws InterruptedException {
        Thread.sleep(15000);
        TestUtil.click(SellBtn, "Clicked on sell button");
        Thread.sleep(500);
        TestUtil.click(LAMFcta, "Clicked on Loan Against Mutual Fund button");
        Thread.sleep(3000);
    }

    public void SelectDate(String year, String month, String date) {
        page.locator("(//div[@class=\"react-datepicker__month-container\"]//select)[2]").selectOption(month);
        page.locator("(//div[@class=\"react-datepicker__month-container\"]//select)[1]").selectOption(year);
        page.locator("//div[text()='" + date + "']").click();
    }

    public void verifyStartSelling() throws InterruptedException {
        TestUtil.click(startSellingBtn, "Start clicked");
        Thread.sleep(3000);

    }

    public void checkEligibility() throws InterruptedException {
        TestUtil.sendKeys(Mobile1, "6999912345", "enetered mobile");
        TestUtil.sendKeys(PAN1, "BKGPC8713D", "enetered pan BKGPC8713D");
        Thread.sleep(2000);
        TestUtil.sendKeys(Pincode1, "400000", "enetered pin");
        TestUtil.click(emplymentType, "clicked emplyment Type ");
        TestUtil.click(salaried, "clicked salaried");
        TestUtil.sendKeys(salary, "40000", "enetered salary");
        page.locator(confirm).evaluate("el => el.click()");

        Thread.sleep(2000);
        TestUtil.click(check_eligibility, "clicked check_eligibility");
        Thread.sleep(2000);
        TestUtil.IsDisplayed(check_status, "check status displayed");
    }

    public void RSAHomePage() throws InterruptedException {
        TestUtil.click(sell, "Sell Clicked");
        Thread.sleep(500);
        TestUtil.click(RSA, " Clicked on RSA");
        Thread.sleep(500);
        LogUtils.info("Verified TC_01 RSA Redirection ");

    }

    public void ValidatePersonalLoan() throws InterruptedException {
        Thread.sleep(5000);
        TestUtil.jsClick(SellBtn, "Sell button click");
        Thread.sleep(500);
        TestUtil.click(PersonalLoan, "Personal Loan selected");
        Thread.sleep(2000);
        TestUtil.IsDisplayed(PersonalLoanPage, "PersonalLoanPage is displayed");
    }

    public void ValidateHomeLoan() throws InterruptedException {
        Thread.sleep(5000);
        TestUtil.jsClick(SellBtn, "Sell button click");
        Thread.sleep(500);
        TestUtil.click(HomeLoan, "HomeLoan  selected");
        TestUtil.IsDisplayed(HomeLoanPage, "HomeLoanPage is displayed");
    }

    public void BusinessLoan() throws InterruptedException {
        Thread.sleep(500);
        TestUtil.jsClick(SellBtn,"Sell button click");
        Thread.sleep(500);
        TestUtil.click(BL, "Business Loan selected");
        Thread.sleep(500);
    }
}
