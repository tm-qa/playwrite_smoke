package smoke;

import Pages.*;
import Pages.OneApi_Page.oneApi;
import base.TestBase;
import org.testng.annotations.*;
import util.RetryAnalyser;
import util.iTestListener;
import utils.TestUtil;

import java.io.IOException;
@Listeners(iTestListener.class)
@Test
public class sachet_Smoke extends TestBase {
    private LoginPage loginPage;
    oneApi smoke;
    String cur;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
        initialization();

        loginPage = new LoginPage(page);
        smoke = new oneApi(page);

        loginPage.ValidateLogin("6999912345", "1234");
        loginPage.sell();
        cur = page.url();
    }

    @BeforeMethod(alwaysRun = true)
    public void loginless() {
        page.navigate(cur);
    }


    @Test(description = "BusinessLoan_RedirectingtoBankPage", groups = {"All_Sachet_Smoke", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void BusinessLoan_RedirectingtoBankPage() throws InterruptedException {

        smoke.BusinessLoan();
        smoke.To_verify_redirectingtoBankPage();
    }

    @Test(description = "HomelLoan", groups = {"All_Sachet_Smoke", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void LAMF_VerifySmallCaseRedirection() throws IOException, InterruptedException {

        smoke.SellTab();
        smoke.Genaratelink();
    }

    @Test(description = "HomelLoan", groups = {"All_Sachet_Smoke", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void RSA_Verifypaymentflow() throws InterruptedException {

        smoke.RSAHomePage();
        smoke.To_VerifyRAZPay_TC67();
    }

    @Test(description = "HomelLoan", groups = {"All_Sachet_Smoke", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void PersonalLoan() throws InterruptedException {
        smoke.ValidatePersonalLoan();
    }

    @Test(description = "HomelLoan", groups = {"All_Sachet_Smoke", "smoke"},   retryAnalyzer = RetryAnalyser.class)
    public void HomelLoan() throws InterruptedException {
        smoke.ValidateHomeLoan();

    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        TestUtil.getFullPageScreenShot(page);
        //    tearDown();
    }
}
