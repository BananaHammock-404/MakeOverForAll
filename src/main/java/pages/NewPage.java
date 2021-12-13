package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static utility.Controller.clickButtonByXpath;

public class NewPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private Select getDropdownElement() {
        return new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))); // Find dropdown element
    }
    public void selectFromDropdown(String pickFromDropdown) {
        getDropdownElement().selectByVisibleText(pickFromDropdown); // Selecting from the dropdown
    }
    public List<String> getSelected() {
        List<WebElement> selectedElements = getDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
        // Getting all the Dropdown Element without looping
    }

    public void clickSortDropdown() throws InterruptedException {
        clickButtonByXpath(wait, "/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(2000);
    }

    public ProductPage clickFirstProduct() throws InterruptedException {
        clickButtonByXpath(wait, "//body/div[@id='__next']/main[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/div[2]/div[1]/div[1]/img[1]");
        Thread.sleep(2000);
        return new ProductPage(driver, wait);
    }

}
