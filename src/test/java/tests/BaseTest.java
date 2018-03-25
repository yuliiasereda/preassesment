package tests;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = Driver.getInstance("CHROME");
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,30);
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void deleteAllCookies() {
        Driver.deleteCookies();
    }

    @AfterClass(alwaysRun = true)
    public void suiteTearDown() {
        Driver.close();
    }
}
