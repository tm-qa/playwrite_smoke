package Pages;

import base.TestBase;
import com.microsoft.playwright.Page;
import utils.TestUtil;

public class productpage extends TestBase {

    String carInsurance = "//p[text()='Car Insurance']";
    String bikeInsuranc = "//p[text()='Bike Insurance']";
    String commVehicleInsurance = "//p[text()='Comm. Vehicle Insurance']";
    String health = "//p[text()='Health Insurance']";
    String life = "//p[text()='Life Insurance']";

    public productpage(Page page) {
        this.page = page;
    }

    public void selectvertical(String verticle) {
        if (verticle.equals("tw")) {
            TestUtil.click(bikeInsuranc, "TW Clicked");
        } else if (verticle.equals("fw")) {
            TestUtil.click(carInsurance, "FW Clicked");
        } else if (verticle.equals("cv")) {
            TestUtil.click(commVehicleInsurance, "CV Clicked");
        } else if (verticle.equals("health")) {
            TestUtil.click(health, "health Clicked");
        } else if (verticle.equals("life")) {
            TestUtil.click(life, "Life Clicked");
        }
    }
}
