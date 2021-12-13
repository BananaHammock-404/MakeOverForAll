package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class HomePage {

    private final WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickXButtonPopup() {
        clickButtonByXpath(wait, "//i[@class='ail ai-times']");
    }
    public void clickXButtonPopupxxx() {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='ail ai-times']")));
        driver.findElement(By.xpath("//i[@class='ail ai-times']")).click();
    }
    public void clickShoppingBagButton() {
        clickButtonByXpath(wait, "//div[@class='nav-link hover-underline']//i[@class='mo-icon icon-bag']");
    }
    public ShoppingBagPage clickViewBag() throws InterruptedException { // Popup after clicking Shopping bag
        clickButtonByLinkText(wait, "View Bag");
        Thread.sleep(2000);
        return new ShoppingBagPage(driver, wait);
    }
    public LoginRegisterPage clickProfileButton() throws InterruptedException {
        clickButtonByXpath(wait, "//i[@class='mo-icon icon-profile']");
        Thread.sleep(2000);
        return new LoginRegisterPage(driver, wait);
    }
    public String getUsernameText() {
        return getTextByXpath(wait, "(//span[contains(text(),'Dummy DumDumb')])[1]");
    }
    public WishlistPage clickWishlistButton() throws InterruptedException {
        clickButtonByXpath(wait, "//div[@class='nav-link hover-underline']//i[@class='mo-icon icon-bag']");
        Thread.sleep(2000);
        return new WishlistPage(driver, wait);
    }
    public NewPage clickNewProduct() throws InterruptedException {
        clickButtonByXpath(wait, "//a[contains(text(),'New')]");
        Thread.sleep(2000);
        return new NewPage(driver,wait);
    }

}
