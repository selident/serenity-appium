package com.carousell.sg.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MobileObject extends PageObject {

    protected WebDriver driver;

    protected AppiumDriver appiumDriver;

    protected WebDriverWait wait;

    public MobileObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(((WebDriverFacade) getDriver()).getProxiedDriver(), this.getImplicitWaitTimeout()), this);
        wait = new WebDriverWait(driver, 60);

        this.driver = driver;
        this.appiumDriver = (AppiumDriver)((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    protected void pressBackButton(){
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void waitVisibility (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitAndFindElement (By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected List<WebElement> waitAndFindElements (By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected String waitAndGetText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    protected void waitAndSendText (By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    protected void waitAndAcceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    protected void assertEquals (String actual, String expected) {
        Assert.assertEquals(expected, actual);
    }

    protected void scrollAndClick(String visibleText) {
        ((AndroidDriver)appiumDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    protected void scrollTo(String visibleText) {
        ((AndroidDriver)appiumDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
    }

    protected void clickElementByText(String visibleText) {
        ((AndroidDriver) appiumDriver).findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + visibleText + "\")").click();
    }

    protected void sleep (long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
