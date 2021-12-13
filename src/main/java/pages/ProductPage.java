package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public String getProductName() {
        return getTextByXpath(wait, "//h1[@class='display-4']");
    }
    public void clickPlusQuantity() {
        clickButtonByXpath(wait, "//i[contains(@class,'ail ai-plus')]");
    }
    public void clickMinusQuantity() {
        clickButtonByXpath(wait, "//i[contains(@class,'ail ai-minus')]");
    }
    public void clickAddToBag() {
        clickButtonByXpath(wait, "//span[contains(text(),'Add to Bag')]");
    }
    public ShoppingBagPage clickViewBag() throws InterruptedException { // Popup after clicking Shopping bag
        clickButtonByXpath(wait, "//span[contains(text(),'View Bag')]");
        Thread.sleep(2000);
        return new ShoppingBagPage(driver, wait);
    }
}
