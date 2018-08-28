package com.carousell.sg.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen extends MobileObject {

    WebDriver driver;

    public LoginScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id="com.thecarousell.Carousell:id/login_button")
    private WebElement BtnLogin;

    @AndroidFindBy(xpath="//TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    private WebElement TxtUser;

    @AndroidFindBy(xpath="//TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private WebElement TxtPass;

    public void clickLoginButton(){
        element(BtnLogin).waitUntilClickable().click();
    }

    public void enterUsername(String username){
        WebElement elmt = TxtUser;
        element(elmt).clear();
        element(elmt).sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement elmt = TxtPass;
        element(elmt).clear();
        element(elmt).sendKeys(password);
    }
}
