package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.clickButtonByXpath;
import static utility.Controller.getTextByXpath;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickPurchaseSummary() {
        clickButtonByXpath(wait, "//div[contains(@class,'MuiAccordionSummary-content')]");
    }
    public String getFirstPurchaseSummary() {
        return getTextByXpath(wait, "/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]");
    }
    public String getEmailText() {
        return getTextByXpath(wait, "/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/p[1]");
    }
    public void clickPaymentBCA() {
        clickButtonByXpath(wait,"//div[contains(@class,'content')]//div[2]//div[1]//input[1]");
    }
    public void clickPlaceOrder() {
        clickButtonByXpath(wait, "//span[contains(text(),'Place Order')]");
    }




}
