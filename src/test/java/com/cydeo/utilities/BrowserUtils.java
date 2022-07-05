package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    //it accepts integer seconds and execute Thread.sleep
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //it switches between the open pages, gets the given Url and verifies the expected title
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> list = Driver.getDriver().getWindowHandles();
        for(String each : list ){
            Driver.getDriver().switchTo().window(each);
            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //it asserts if the expected title is true
    public static void verifyExpectedTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    //it waits explicitly for invisibility
    public static void waitForInvisibilityOf(WebElement element){
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //it accepts a dropdowns as a web elements and return all the options' text to list of string
    public static List<String> dropdownsOptionsAsString(WebElement dropdownOptions){
        Select select = new Select(dropdownOptions);
        List<WebElement> dropdownsOptionsAsWebElement = select.getOptions();
        List<String> result = new ArrayList<>();
        for (WebElement each : dropdownsOptionsAsWebElement) {
            result.add(each.getText());
        }
        return result;
    }

    //it selects given radio button from the list of radio buttons
    public static void clickRadioButton(List<WebElement> radioButtonList, String radioButton){
        for (WebElement each : radioButtonList) {
            String eachValue = each.getAttribute("value");
            if (eachValue.equalsIgnoreCase(radioButton)){
                each.click();
            }
        }
    }

}
