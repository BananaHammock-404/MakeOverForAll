package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickShoppingBagButton() {
        clickButtonByXpath(wait, "//div[@class='nav-link hover-underline']//i[@class='mo-icon icon-bag']");
    }
    public ShoppingBagPage clickViewBag() { // Popup after clicking Shopping bag
        clickButtonByLinkText(wait, "View Bag");
        return new ShoppingBagPage(driver, wait);
    }
    public LoginRegisterPage clickProfileButton() {
        clickButtonByXpath(wait, "//i[@class='mo-icon icon-profile']");
        return new LoginRegisterPage(driver, wait);
    }
    public WishlistPage clickWishlistButton() {
        clickButtonByXpath(wait, "//div[@class='nav-link hover-underline']//i[@class='mo-icon icon-bag']");
        return new WishlistPage(driver, wait);
    }
    public void clickNewProduct() {
        clickButtonByLinkText(wait, "New");
    }

}
