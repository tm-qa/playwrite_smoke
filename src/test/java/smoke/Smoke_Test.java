package smoke;

import Pages.*;
import base.TestBase;
import org.testng.annotations.*;
import util.RetryAnalyser;
import util.iTestListener;
import utils.TestUtil;

@Listeners(iTestListener.class)
@Test
public class Smoke_Test extends TestBase {
    private LoginPage loginPage;
    productpage pd;
    life_page life;
    health_Page hl;
    TW_page tw;
    FW_Pages fw;
    CV_Page cv;
    TestUtil tl;
    String cur;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
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
        cur = page.url();
    }

    @BeforeMethod(alwaysRun = true)
    public void loginless() {
        page.navigate(cur);
    }

    @Test(description = "TwoWheeler Flow Test", groups = {"TW", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void TW_Flow() throws InterruptedException {
        pd.selectvertical("tw");
        tw.CreateQuoteWithRegNumber("GJ05PU5256");
        tw.SaveLead("TW test");
        tw.SelectTWPlan();
        tw.CheckoutTW("TW");
    }

    @Test(description = "FourWheeler Flow Test", groups = {"FW", "smoke"}, retryAnalyzer = RetryAnalyser.class)
    public void FW_Flow() throws InterruptedException {
        pd.selectvertical("fw");
        fw.CreateQuoteWithoutRegNumber();
        fw.SaveCarDetails("Ford figo");
        tw.SaveLead("FW test");
        tw.SelectTWPlan();
        tw.CheckoutTW("FW");
    }

    @Test(description = "Commercial Vehicle Flow Test", groups = {"CV", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void CV_Flow() throws InterruptedException {
        pd.selectvertical("cv");
        cv.comprehensive();
        tw.CheckoutTW("CV");
    }

    @Test(priority = 0, description = "Life Insurance Flow Test", groups = {"Life", "smoke"}, retryAnalyzer = RetryAnalyser.class)
    public void life_Flow() throws Exception {
        pd.selectvertical("life");
        life.LifeRedirection();
        life.LifeCheckoutPage();
    }

    @Test(priority = 1, description = "Health Insurance Flow Test", groups = {"Health", "smoke"}, retryAnalyzer = RetryAnalyser.class)
    public void health_Flow() throws Exception {
        pd.selectvertical("health");
        hl.HealthProfile();
        hl.selectPlan();
        hl.healthCheckoutOVD();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        TestUtil.getFullPageScreenShot(page);
        //    tearDown();
    }
}