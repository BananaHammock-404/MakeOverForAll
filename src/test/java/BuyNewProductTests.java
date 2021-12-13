import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class BuyNewProductTests extends BaseTests {

    LoginRegisterPage loginRegisterPage;
    HomePage homePage;
    NewPage newPage;
    ProductPage productPage;
    ShoppingBagPage shoppingBagPage;
    CheckoutPage checkoutPage;
    String googleEmail = "dummydumdumb420@gmail.com";
    String googlePassword = "Dumb69420";
    String username = "Dummy DumDumb";
    String productName;


    @Test(priority = 1, description = "Log in to MAKE OVER")
    public void successfulLoginNonXL() throws InterruptedException {
        //if (Controller.isElementDisplayed(wait, )
        homePage = new HomePage(driver,wait);
        homePage.clickXButtonPopup();

        loginRegisterPage = new LoginRegisterPage(driver, wait);
        loginRegisterPage = homePage.clickProfileButton();
        loginRegisterPage.clickGoogleLogin();
        //loginRegisterPage.clickAnotherAccountButton();
        loginRegisterPage.googleLogin(googleEmail, googlePassword);
        assertEquals(homePage.getUsernameText(),
                username,
                "Failed to Login");
    }
    @Test(priority = 2, description = "Sort and Pick a Product")
    public void sortPickProduct() throws InterruptedException {
        newPage = new NewPage(driver,wait);
        newPage = homePage.clickNewProduct();

        /* Selecting from Sort Dropdown */
       /* String sortPick = "Top rated";
        newPage.selectFromDropdown(sortPick); // Picking Selection
        var selectedRole = newPage.getSelected(); // Getting Selection
        assertEquals(selectedRole.size(), 1, "incorrect number of selection"); // Make sure only 1 is picked
        assertTrue(selectedRole.contains(sortPick), "Wrong Option Selected"); // Asserting the 1 picked is 1 we Select
        Thread.sleep(1000);*/

        newPage.clickSortDropdown();

        productPage = new ProductPage(driver,wait);
        productPage = newPage.clickFirstProduct();
    }
    @Test(priority = 3, description = "Check and Add Product to Shopping Cart")
    public void addProduct() throws InterruptedException {
        productName = productPage.getProductName();
        productPage.clickPlusQuantity();
        productPage.clickPlusQuantity();
        productPage.clickMinusQuantity();
        productPage.clickAddToBag();

        shoppingBagPage = new ShoppingBagPage(driver,wait);
        shoppingBagPage = productPage.clickViewBag();
    }
    @Test(priority = 4, description = "Check the Shopping bag and Proceed to checkout")
    public void checkoutProduct() throws InterruptedException {
        assertEquals(
                shoppingBagPage.getProductInBag(),
                productName,
                "Different product! - Shopping Bag");

        checkoutPage = new CheckoutPage(driver,wait);
        checkoutPage = shoppingBagPage.clickProceedCheckout();
    }
    @Test(priority = 5, description = "Check the Checkout items and Proceed to Place an Order")
    public void placeOrder() throws InterruptedException {
        checkoutPage.clickPurchaseSummary();
        assertEquals(
                checkoutPage.getFirstPurchaseSummary(),
                productName,
                "Different product! - Checkout");
        assertEquals(
                checkoutPage.getEmailText(),
                googleEmail,
                "Email is Different from Logged user");
        checkoutPage.clickPaymentBCA();
        checkoutPage.clickPlaceOrder();
        Thread.sleep(15000);
    }



}
