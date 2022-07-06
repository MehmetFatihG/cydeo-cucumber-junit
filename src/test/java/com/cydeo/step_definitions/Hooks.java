package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
in this class we will be able to pass pre- & post- conditions to each scenario and each step
 */
public class Hooks {

    //@Before(order = 0)//import from io.cucumber.java not from junit
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before");
    }

    //@Before (value = "@login", order = 1)
    public void setupScenarioForSettings(){
        System.out.println("===This will only apply to scenarios with @login tag");
    }

    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte [] screenShot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",scenario.getName());
        }

        Driver.closeDriver();
        //System.out.println("===Closing browser using cucumber @After");
        //System.out.println("===Scenario ended/ Take screenshot if failed");
    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("--------applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("--------applying teardown using @AfterStep");
    }

}
