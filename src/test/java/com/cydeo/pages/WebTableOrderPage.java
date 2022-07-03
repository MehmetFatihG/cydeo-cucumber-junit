package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableOrderPage extends BasePage {

    public WebTableOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//input[@placeholder='Full name of the customer']")
    public WebElement costumerName;

    @FindBy(xpath = "//input[@placeholder='Street address of the customer']")
    public WebElement streetName;

    @FindBy(xpath = "//input[@placeholder='City where the customer lives']")
    public WebElement cityName;

    @FindBy(xpath = "//input[@placeholder='State where the customer lives']")
    public WebElement stateName;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCard;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNo;

    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement cardExp;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "(//td)[1]")
    public WebElement firstRowOrder;


}
