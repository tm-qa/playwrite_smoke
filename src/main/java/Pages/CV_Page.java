package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.LogUtils;
import utils.TestUtil;

public class CV_Page extends TestBase {

    public CV_Page(Page page) {
        this.page = page;
    }

    String cartext = "//input[@type='text']";
    String quote = "//div[@class='getQuote']//button";
    String calender = "//input[@placeholder='dd/mm/yyyy']";
    String date = "//div[text()='1']";
    String gotit = "//span[text()='Got It!']";
    String Public = "//*[text()='Public']";
    String next = "//span[text()='Next']//parent::button";
    String Tp = "//span[text()='Comprehensive']";
    String Comprehensive = "//span[text()='Comprehensive']";
    String ExpDatePicker = "//input[@placeholder='dd/mm/yyyy']";
    String DateSelect1 = "//div[@class='react-datepicker__day react-datepicker__day--030 react-datepicker__day--keyboard-selected react-datepicker__day--today']";
    String PrevtypeTp = "//span[text()='Comprehensive']";
    String ReliancePreferred = "//div[text()='Reliance']";
    String No = "//span[text()='Made any claims in previous year?']//..//..//..//span[text()='No']";
    String No2 = "//span[text()='Previous Policy From Turtlemint ?']//..//..//..//span[text()='No']";
    String select20 = "//div[text()='20%']";
    String model = "//input[@type='search']";
    String s2021 = "//div[@title='2018']";
    String bajaj = "//div[text()='Bajaj Allianz']";
    String Diesel = "//*[text()='Diesel']";
    String Var = "//span[text()='Type name and select']//..//input";
    String SelectionType = "//span[text()='Eg. Truck']//..//input";
    String no = "//span[text()='No']";
    String no1 = "(//span[text()='No'])[2]";
    String leadname = "//*[@placeholder='Reference Name']";
    String autos = "//span[text()='Goods Carrying Vehicles']";
    String GotItBtn = "//div[text()='Got It!']";
    String SelectCVPlan = "//a[@data-auto='NINA-web']";
    String SelectCVPlanRel = "//img[@src='https://assets.insurancehub.turtlefin.io/providers/GENERAL/RELI/RELI.png']//parent::div//following-sibling::div//button";
    String icic = "//img[@src='https://assets.insurancehub.turtlefin.io/providers/GENERAL/ICICILOMBARD/ICICILOMBARD.png']//parent::div//following-sibling::div//button";
    String Digit = "//a[@data-auto='DIGIT-web']";
    String ProceedtoBuy = "//span[text()='Confirm']";
    String title = "(//*[@class='btn btn-default form-control ui-select-toggle'])[1]";
    String mr = "//*[text()='Mr']";
    String fn = "id=firstName";
    String ln = "id=lastName";
    String email = "id=email";
    String mbl = "id=mobile";
    String address = "//input[@id='registeredAddressLine1']";
    String Adressline2 = "@name='registeredAddressLine2'";
    String continu = "//*[text()='Continue']";
    String pin = "//div[@id='registeredPincode-uiSelect']";
    String Pincode = "//div[@id='registeredPincode-uiSelect']/input";
    String SelectPincode = "//span[text()='400065']";
    String variente = "//div[@placeholder='Variant']";
    String varientinputl = "//div[@placeholder='Variant']//..//input";
    String clickele = "//div[@id='registeredCity-uiSelect']";
    String previousPolicyNumber = "//input[@name='previousPolicyNumber']";
    String stateentered = "//div[@placeholder='Enter State']//parent::div//input";
    String maharastra = ""; // Empty - no locator provided
    String SelectNomineeRelation = "//span[text()='Mother']";
    String Nominee = "//div[@id='nomineeRel-uiSelect']";
    String NomineeName = "//input[@name='nomineeName']";
    String NomineeDOB = "//input[@name='nomineeDOB-datepicker']";
    String DateSelected = "//a[normalize-space()='12']";
    String State = "//div[@id='registeredCity-uiSelect']/input";
    String SelectState = "//span[text()='MUMBAI']";
    String nomineename = "@name='nomineeName'";
    String datebtn = "@name='nomineeDOB-datepicker'";
    String dobpicker = "id=dob-datepicker";
    String Dateofbirth = "//*[@class='ui-datepicker-calendar']//tbody//td//a[text()='1']";
    String relbtn = "(//*[text()='NA ']//parent::span)[1]";
    String son = "//*[text()='Son']";
    String yes = "//*[text()='Yes']";
    String DOBB = "//*[@placeholder='dd/mm/yyyy']";
    String checkbox = "//label[@for='calendarCheckbox']";
    String prevPolicyNumber = "//input[@id='previousPolicyNumber']";
    String selectInsurer = "//span[text()='Select  Insurer']";
    String prevbajajAllianz = "//span[text()='Bajaj Allianz']";
    String onlineclick = "//span[text()='Online']";
    String enginno = "id=engineNum";
    String chassisno = "@name='chassisNum'";
    String exp = "//*[text()='Policy expired more than 90 days ago']";
    String varient = "//*[text()='DZIRE DZIRE ZXI , Seating: 5, CC : 1197']";
    String varbtn = "(//*[text()='Variant'])[2]";
    String male = "//input[@id='gender-M']//parent::label";
    String online = "//*[text()='Online']";
    String makepayment = "//*[text()='Make Payment']";




    public void comprehensive() throws InterruptedException {
        TestUtil.click(autos,"TAXI clicked");
        TestUtil.sendKeys(cartext,"MH10CR2557","MH10CR2557 enterd");
        LogUtils.info("Registration Number entered");
        TestUtil.click(quote,"Clicked on Get Quote");
        TestUtil.click(calender,"Calender Clicked");
        Thread.sleep(500);
        TestUtil.sendKeys(calender,"25/09/2018","Calender Clicked");
        Thread.sleep(500);
        TestUtil.sendKeys(calender,"Enter","Calender Clicked");

        TestUtil.click(Public,"Public Vehicle Selected");
        TestUtil.click(next,"Next Button Clicked");
        TestUtil.click(Comprehensive,"Comprehensive");
        TestUtil.click(next,"Next Button Clicked");
        TestUtil.sendKeys(ExpDatePicker,TestUtil.PresentDate(),"Exp Date Calendar Opened");
        Thread.sleep(500);
        TestUtil.sendKeys(ExpDatePicker,"Enter","Enter Clicked");
        Thread.sleep(500);
        TestUtil.click(PrevtypeTp,"Prev type TP Selected");
        Thread.sleep(500);
        TestUtil.click(No,"no");
        Thread.sleep(500);
        TestUtil.click(select20,"select20");
        Thread.sleep(500);
        TestUtil.click(bajaj,"bajaj");
        Thread.sleep(500);
        TestUtil.click(No2,"no");
        TestUtil.click(next,"Next Button Clicked");
        TestUtil.click(ReliancePreferred,"Reliance Preferred Clicked");
        TestUtil.click(next,"Next Button Clicked");
        Thread.sleep(500);
        TestUtil.sendKeys(model,"TATA","Car Model Typed");
        Thread.sleep(500);
        TestUtil.sendKeys(model, "Enter","Car Model Typed");

        TestUtil.click(s2021,"Year Selected");
        TestUtil.click(Diesel,"Diesel selected");

        TestUtil.sendKeys(Var,"Ace mega xl","");
        Thread.sleep(500);
        TestUtil.sendKeys(Var, "Enter","Car Model Typed");
        TestUtil.click(SelectionType,"SelectionType");
        Thread.sleep(500);
        TestUtil.sendKeys(SelectionType,"bul","SelectionType");
        Thread.sleep(500);
        TestUtil.sendKeys(SelectionType,"Enter","SelectionType");
        TestUtil.click(no,"no Selected");
        TestUtil.click(no1,"no Selected");
        TestUtil.click(next,"Clicked Next Button");
        TestUtil.sendKeys(leadname,"Automation Test","Lead Name Entered");
        TestUtil.click(next,"Moving to Results Page...");
        LogUtils.info("Comprehensive Profile Done");
        TestUtil.click(gotit,"Got it button clicked");
        TestUtil.click(SelectCVPlanRel,"");
    }

}