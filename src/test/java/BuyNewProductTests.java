import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginRegisterPage;

public class BuyNewProductTests extends BaseTests {

    LoginRegisterPage loginRegisterPage;
    HomePage homePage;
    @Test(priority = 1, description = "Log in to MAKE OVER")
    public void testSuccessfulLoginNonXL() throws InterruptedException {
        loginRegisterPage = homePage.clickProfileButton();

    }

}
