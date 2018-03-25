package pages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected abstract By getUniqueElement();
    protected abstract void open();

    protected void isLoaded() throws Error {
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());
        Assert.assertTrue((uniqueElement.size() > 0),
                "Unique Element \'" + getUniqueElement().toString() + "\' not found for " + this.getClass().getSimpleName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
    }


}
