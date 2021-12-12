package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.time.LocalDate.now;

public class Controller {



    /* Input Text to a textbox that has a placeholder text where we can recognize is */
    public static void setTextByID(WebDriverWait wait, String placeholderText, String inputText){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(placeholderText))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(placeholderText))).sendKeys(inputText);
    }

    /* Input Text to a textbox that has a placeholder xpath where we can recognize is */
    public static void setTextByXpath(WebDriverWait wait, String xpath, String inputText){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(inputText);
    }


    /* Clicking a button that has a Text on it */
    public static void clickButtonByLinkText(WebDriverWait wait, String buttonText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(buttonText))).click();
    }

    /* Clicking a button that has an xpath on it */
    public static void clickButtonByXpath(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    /* Clicking a button that has an ID on it */
    public static void clickButtonByID(WebDriverWait wait, String id) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    /* Getting a text by Xpath */
    public static String getTextByXpath(WebDriverWait wait, String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
    }

    public static void scrollToElement(WebDriver driver, By element) {
        // identify element
        WebElement m = driver.findElement(element);
        // Javascript executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
    }

    /* Check if a button is displayed, if yes then do something if no then skip.
    it can take abt 1 to 4 seconds so be warned */
    public static boolean isElementDisplayed(WebDriverWait wait, By xpath) {
        try {
            boolean displayed = wait.until(ExpectedConditions.elementToBeClickable(xpath)).isDisplayed();
            System.out.println(displayed);
            return displayed; // Return True
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /* Selecting from a dropdown */
    private Select findDropdownElement(WebDriver driver, String DropdownId) {
        return new Select(driver.findElement(By.id(DropdownId))); // Find dropdown element
    }
    public void selectFromDropdown(WebDriver driver, String DropdownId, String pickFromDropdown) {
        findDropdownElement(driver, DropdownId).selectByVisibleText(pickFromDropdown); // Selecting from the dropdown
    }
    public List<String> getSelected(WebDriver driver, String DropdownID) {
        List<WebElement> selectedElements = findDropdownElement(driver, DropdownID).getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
        // Getting all the Dropdown Element without looping
    }

    /* Downloaded item checker */
    public static boolean isFileDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.home");
        File dir = new File(downloadPath+"/Downloads/" + fileName + ".xlsx");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }


    /*______________________*/
    /* General Date Picker  */
    /*----------------------*/

    By yearSelectorButton = By.xpath("//button[@class='mat-focus-indicator mat-calendar-period-button mat-button mat-button-base']");
    By prevCalenderPageButton = By.xpath("//button[@class='mat-focus-indicator mat-calendar-previous-button mat-icon-button mat-button-base']");
    By nextCalenderPageButton = By.xpath("//button[@class='mat-focus-indicator mat-calendar-next-button mat-icon-button mat-button-base']");

    public void clickYearSelector(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(yearSelectorButton)).click();
    }
    public void pickYearNumber(WebDriverWait wait, String yearNumber) { // Choose the Start Year (ex: 2021)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"" + yearNumber + "\")]"))).click();
    }
    public void pickMonth(WebDriverWait wait, String monthAbbreviation) { // Choose the Start Date (JAN - DES)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"" + monthAbbreviation + "\")]"))).click();
    }
    public void pickDateNumber(WebDriverWait wait, String dateNumber) { // Choose the Start Date (1 - 32)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"" + dateNumber + "\")]"))).click();
    }
    public void clickNextPageCalender(WebDriverWait wait) { // Can also be used for Year
        wait.until(ExpectedConditions.elementToBeClickable(nextCalenderPageButton)).click();
    }
    public void clickPrevPageCalender(WebDriverWait wait) { // Can also be used for Year
        wait.until(ExpectedConditions.elementToBeClickable(prevCalenderPageButton)).click();
    }

    public static Integer getTodayDate() {
        Integer todayDate = Integer.valueOf(valueOf(now()).substring(valueOf(now()).length() - 2));
        System.out.println("Date hari ini: " + todayDate);
        return todayDate;
    }

    /*______________________*/
    /*   Back Office Util   */
    /*----------------------*/



    private By listDataBO = By.xpath("//tbody/tr[@role='row']"); // To list the Table Content of some BO
    private By searchFieldBO = By.xpath("//input[contains(@class,'mat-input-element')]"); // To use the Search Bar of some BO
    private By dataNull = By.xpath(".//tr[2]/th"); // If the Table Content is Null



    /* Enter search key for All Search bar in Back Office */
    String type = "";
    String values;

    public String setSearchData(WebDriver driver, WebDriverWait wait, String search) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBO));
        driver.findElement(searchFieldBO).clear();
        driver.findElement(searchFieldBO).sendKeys(search, Keys.ENTER);
        if (type.equalsIgnoreCase("deleted") || type.equalsIgnoreCase("cancel")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dataNull));
            search = driver.findElement(dataNull).getText();
            values = driver.findElement(dataNull).getText();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(listDataBO));
        }
        type = "";
        return search;
    }

    /* Picking Item from List of Table after Searching */
    WebElement temp;
    public WebElement listData(WebDriver driver, String data) {
        try {
            Thread.sleep(2000);
            List<WebElement> listTR = driver.findElements(listDataBO);
            for (WebElement dataList : listTR) {
                WebElement datas = dataList.findElement(By.xpath(".//td[2]"));
                if (dataList.getText().equalsIgnoreCase(data) || datas.getText().equalsIgnoreCase(data)) {
                    temp = dataList;
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
