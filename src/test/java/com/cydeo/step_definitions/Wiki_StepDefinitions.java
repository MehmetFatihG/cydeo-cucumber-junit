package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.com");
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchKeyword ) {
        wikiSearchPage.searchBox.sendKeys(searchKeyword);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String searchKeyword) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(searchKeyword));
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String str) {
        String actualHeader = wikiSearchPage.mainHeader.getText();
        Assert.assertTrue(actualHeader.contains(str));
    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String string) {
        String actualImageHeader = wikiSearchPage.imageHeader.getText();
        Assert.assertTrue(actualImageHeader.contains(string));
    }
}
