package smoke;

import Pages.*;
import base.TestBase;
import org.testng.annotations.*;
import util.iTestListener;
import utils.TestUtil;


@Listeners(iTestListener.class)
@Test(groups = {"all"}, description = "All Verticals end to end Suite")
public class Smoke_Test extends TestBase {
    private LoginPage loginPage;
    productpage pd;
    life_page life;
    health_Page hl;
    TW_page tw;
    FW_Pages fw;
    CV_Page cv;
    TestUtil tl;

    @BeforeClass
    public void setUp() {
        initialization();

        loginPage = new LoginPage(page);
        pd = new productpage(page);
        life = new life_page(page);
        hl = new health_Page(page);
        tw = new TW_page(page);
        fw = new FW_Pages(page);
        cv = new CV_Page(page);
        tl = new TestUtil();

        loginPage.ValidateLogin("6999912345", "1234");
        loginPage.sell();
    }

    @BeforeMethod
    public void loginless() {
        page.navigate("https://app.turtlemintpro.com/sell");
    }

    @Test
    public void TW_Flow() throws InterruptedException {
        pd.selectvertical("tw");
        tw.CreateQuoteWithRegNumber("GJ05PU5256");
        tw.SaveLead("TW test");
        tw.SelectTWPlan();
        tw.CheckoutTW();
    }

    @Test
    public void FW_Flow() throws InterruptedException {
        pd.selectvertical("fw");
        fw.CreateQuoteWithoutRegNumber();
        fw.SaveCarDetails("Ford figo");
        tw.SaveLead("FW test");
        tw.SelectTWPlan();
        tw.CheckoutTW();
    }

    @Test
    public void CV_Flow() throws InterruptedException {
        pd.selectvertical("cv");
        cv.comprehensive();
        tw.CheckoutTW();
    }

    @Test
    public void life_Flow() throws Exception {
        pd.selectvertical("life");
        life.LifeRedirection();
        life.LifeCheckoutPage();
    }

    @Test
    public void health_Flow() throws Exception {
        pd.selectvertical("health");
        hl.HealthProfile();
        hl.selectPlan();
        hl.healthCheckoutOVD();
    }

    @AfterMethod
    public void cleanUp() {
     //    tearDown();
    }

}