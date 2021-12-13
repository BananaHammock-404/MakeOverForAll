package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Controller;

import static utility.Controller.clickButtonByXpath;

public class ShoppingBagPage {

    WebDriver driver;
    WebDriverWait wait;

    public ShoppingBagPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String getProductInBag() {
        return Controller.getTextByXpath(wait, "/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]");
    }
    public CheckoutPage clickProceedCheckout() throws InterruptedException {
        clickButtonByXpath(wait, "//span[contains(text(),'Proceed to Checkout')]");
        Thread.sleep(2000);
        return new CheckoutPage(driver, wait);
    }

}
