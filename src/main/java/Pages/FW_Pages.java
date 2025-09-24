package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.TestUtil;
import utils.LogUtils;

public class FW_Pages extends TestBase {

    public FW_Pages(Page page) {
        this.page = page;
    }

    String WithoutRegNumberLink = "//div[text()='Quote without vehicle number']";
    String ProceedwithoutRegistration = "//p[text()=' I do not have a registration number ']";
    String Search = "//input[@type='search']";
    String RegistrationDate = "//input[@name='regDate-datepicker']";
    String CheckBox = "//*[text()=\"I don't have registration date, it's a new vehicle\"]";
    String NextButton = "id=container-next-btn";
    String SelectRegLocation = "//span[text()='MH-01-Tardeo']";
    String Carlbl = "//p[text()='Your Car detail']";
    String CarModel = "//input[@type='search']";
    String SelectModel = "//span[text()='Ford Figo']";
    String SelectTWModel = "//span[text()='Ford Figo']";
    String RegYear = "//span[text()='2024']";
    String FuelType = "//span[text()='Diesel']";
    String Tw_FuelType = "//span[text()='Petrol']";
    String ClickVariant = "id=variant-uiSelect";
    String SelectVariant = "(//div[@ng-if=\"$select.open\"])[1]";
    String SelectTWVariant = "//span[text()='Duratorq LXI (1399 CC)']";
    String name = "//input[@id='customerName']";
    String reli = "//a[@data-auto=\"RELI-web\"]";


    public void CreateQuoteWithoutRegNumber() throws InterruptedException {
        TestUtil.click(WithoutRegNumberLink, "Without RegNumber Link");
        TestUtil.sendKeys(Search, "MH01", "No RegistrationDate");
        Thread.sleep(500);
        TestUtil.click(SelectRegLocation, "MH01 Selected");
        Thread.sleep(2000);
        page.locator(CheckBox).hover();
        Thread.sleep(500);
        TestUtil.click(CheckBox, "");
        TestUtil.click(NextButton, "Next Button");
    }

    public void SaveCarDetails(String CarName) throws InterruptedException {
        LogUtils.info("Car Details Entering Started");
        TestUtil.sendKeys(CarModel, CarName, CarName + " CarName entered");
        Thread.sleep(500);
        TestUtil.click(SelectModel, page.locator(SelectModel).innerText().trim() + " entered");
        Thread.sleep(500);
        TestUtil.click(RegYear, page.locator(RegYear).innerText().trim() + " entered");
        Thread.sleep(500);
        TestUtil.click(FuelType, page.locator(FuelType).innerText().trim() + " entered");
        Thread.sleep(500);
        TestUtil.click(ClickVariant, "ClickVariant");
        LogUtils.info("Car variant Selection is in process");
        Thread.sleep(500);
        TestUtil.click(SelectVariant,  " selected");
        Thread.sleep(500);
        TestUtil.click(NextButton, "Next Button");
        LogUtils.info("Clicked Next Button and Proceeded to Lead Name Page");

    }

}