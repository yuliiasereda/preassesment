package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePage extends BasePage {
    private static final String URL = "https://www.google.com/";
    private static final By SEARCH_BAR_LOCATOR = By.id("lst-ib");
    private static final By LIST_SEARCH_RESULT = By.xpath("//div[@id=\"ires\"]//h3/a");

    public GooglePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    protected By getUniqueElement() {
        return By.id("hplogo");
    }

    @Step("Open the page")
    @Override
    public void open() {
        driver.get(URL);
        isLoaded();
    }

    @Step("Type: {0} to the search field")
    public void typeToSearchField(String text) {
        driver.findElement(SEARCH_BAR_LOCATOR).sendKeys(text);
    }

    @Step("Confirm inputs in the search bar")
    public void submit() {
        driver.findElement(SEARCH_BAR_LOCATOR).submit();
    }

    @Step("See list of results of the search")
    public List<WebElement> getSearchResult() {
        return driver.findElements(LIST_SEARCH_RESULT);
    }

    @Step("See the first result of the search")
    public String getOneSearchResult(int number) {
        String result = "";
        try {
            result = getSearchResult().get(number).getText();
        } catch (Exception e) {
            // TODO Logirovanie
        }
        return result;
    }

}
