package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("User is on the login page of Web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }

    @When("User enters username {string}")
    public void user_enters_username(String string) {
        webTableLoginPage.usernameInput.sendKeys(string);
    }

    @When("User enters password {string}")
    public void user_enters_password(String string) {
        webTableLoginPage.passwordInput.sendKeys(string);
    }

    @When("User click login button")
    public void user_click_login_button() {
        webTableLoginPage.loginButton.click();
    }

    @Then("User should see url contains orders")
    public void user_should_see_url_contains_orders() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.endsWith("orders"));
    }

    @When("User enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        webTableLoginPage.login(username,password);
    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String, String> credentials) {
        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));


    }
}
