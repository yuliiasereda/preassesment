package tests;

import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GooglePage;


@Listeners({TestListener.class})
public class ExampleTest extends BaseTest {

    @Test (description = "Check the search result")
    @Description("Enter the text and then compare the search result")
    public void isTheSearchResultCorrect(){
        GooglePage googlePage = new GooglePage(driver, wait);
        googlePage.open();
        googlePage.typeToSearchField("JBehave");
        googlePage.submit();
        Assert.assertEquals(googlePage.getOneSearchResult(0), "What?");
    }
}
