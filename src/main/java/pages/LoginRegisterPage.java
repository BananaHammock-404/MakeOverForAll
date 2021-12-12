package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

import static utility.Controller.clickButtonByXpath;
import static utility.Controller.setTextByXpath;

public class LoginRegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginRegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickGoogleLogin(){
        clickButtonByXpath(wait, "//button[contains(@class,'btn btn-social btn-google btn-block')]");
    }

    /* Google Popup */
    public void clickAnotherAccountButton() {
        clickButtonByXpath(wait, "//div[@class='zWl5kd']");
    }
    public void setGoogleEmailText(String email) {
        setTextByXpath(wait, "//input[@id='identifierId']", email);
    }
    public void clickGoogleNextButton() {
        clickButtonByXpath(wait, "//span[contains(text(),'Next')]");
    }
    public void setGooglePasswordText(String password) {
        setTextByXpath(wait, "//input[@name='password']", password);
    }
    /* Switch between Parent Window & Child Window (Google login) */
    public void googleLogin(String email, String password) throws InterruptedException {
        // Return the parent window name as a String
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        Set<String> s = driver.getWindowHandles(); // s will be the Iterator Variable
        // Now iterate using Iterator
        Iterator I1 = s.iterator();
        // Switching to Azure Popup
        while (I1.hasNext()) {
            var childWindow = (String) I1.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);

                clickAnotherAccountButton();
                setGoogleEmailText(email);
                clickGoogleNextButton();
                setGooglePasswordText(password);
                clickGoogleNextButton();
            }
            //switch to the parent window
            driver.switchTo().window(parentWindow);
        }
    }
}
