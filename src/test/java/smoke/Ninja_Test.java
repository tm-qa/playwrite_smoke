package smoke;

import Pages.*;
import base.TestBase;
import org.sikuli.script.FindFailed;
import org.testng.annotations.*;
import util.iTestListener;


@Listeners(iTestListener.class)
@Test(groups = {"all"}, description = "All Verticals end to end Suite")
public class Ninja_Test extends TestBase {
    private LoginPage loginPage;
    Ninja n;

    @BeforeClass
    public void setUp() {
        initialization();

        loginPage = new LoginPage(page);
        n = new Ninja(page);

//        loginPage.ValidateLogin("6999912345", "1234");
//        loginPage.sell();
    }

    @BeforeMethod
    public void loginless() {
        page.navigate("https://www.justdial.com/");

    }

    @Test
    public void login_Ninja_Flow() throws InterruptedException, FindFailed {
   // n.liginNinja();
        Thread.sleep(600000);
    }

    @AfterMethod
    public void cleanUp() {
        // tearDown();
    }


}