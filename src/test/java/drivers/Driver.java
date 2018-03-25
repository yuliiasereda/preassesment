package drivers;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getInstance(String driverManagerType) {
        if (driverManagerType == null) {
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new ChromeDriver();
        }
        switch (driverManagerType) {
        case "CHROME":
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new ChromeDriver();
        case "FIREFOX":
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new FirefoxDriver();
        case "OPERA":
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new OperaDriver();
        case "IEXPLORER":
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new InternetExplorerDriver();
        case "EDGE":
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new EdgeDriver();
        default:
            WebDriverManager.getInstance(DriverManagerType.valueOf(driverManagerType)).setup();
            return driver = new ChromeDriver();
        }
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void deleteCookies() {
        driver.manage().deleteAllCookies();
    }
}