package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    HomePage homePage;
    protected WebDriverWait wait;
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");

        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Make the browser fullscreen - is optional
        driver.manage().window().maximize();

        driver.get("https://www.makeoverforall.com/");
        homePage = new HomePage(driver, wait);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
