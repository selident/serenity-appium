package com.carousell.sg.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SellScreen extends MobileObject {

    private WebDriver driver;

    public SellScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id="com.thecarousell.Carousell:id/button_sell")
    private WebElement BtnSell;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='image_selection_page_photo_1']")
    private WebElement FirstImgProduct;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='NEXT']")
    private WebElement BtnNext;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='category_page_search_label']")
    private WebElement TxtCategory;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Everything Else']")
    private WebElement OptEverythingElseCategory;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='title']")
    private WebElement TxtListingTitle;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='price']")
    private WebElement TxtPrice;

    @AndroidFindBy(xpath="//android.widget.Switch[@content-desc='mailing']")
    private WebElement TglMailing;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='mailing_details']")
    private WebElement TxtMailing;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='description']")
    private WebElement TxtDescription;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/btn_close")
    private WebElement BtnCloseSummary;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/button_close")
    private WebElement BtnCloseListed;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='LIST IT!']")
    private WebElement BtnListIt;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/header_page_search_text_field")
    private WebElement TxtSearchField;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/input_search_bar")
    private WebElement TxtSearchBar;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='OK, Got it!']")
    private WebElement BtnOkGotIt;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/blank_placeholder")
    private WebElement FilterBar;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@content-desc='time_created,descending']")
    private WebElement RdoRecent;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/btn_filter")
    private WebElement BtnSeeFilteredResults;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/text_attribute_1")
    private WebElement ProductPost;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/text_attribute_2")
    private WebElement ProductPrice;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/text_attribute_3")
    private WebElement ProductDescription;

    @AndroidFindBy(id="com.thecarousell.Carousell:id/text_attribute_4")
    private WebElement ProductCondition;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private WebElement BtnMoreOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete listing']")
    private WebElement OptDeleteListing;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Delete']")
    private WebElement BtnDelete;

    //Listing item methods
    public void clickSellButton(){
        element(BtnSell).waitUntilClickable().click();
    }

    public void allowToAccessPhotos(){
        waitAndAcceptAlert();
    }

    public void selectProductImages(){
        element(FirstImgProduct).waitUntilClickable().click();
    }

    public void clickNextButton(){
        element(BtnNext).waitUntilClickable().click();
    }

    public void selectListingCategory(String category){
        sleep(1);
        WebElement mobileElement = TxtCategory;
        element(mobileElement).waitUntilClickable().clear();
        element(mobileElement).sendKeys(category);
        element(OptEverythingElseCategory).click();
    }

    public void enterTitle(String title){
        element(TxtListingTitle).waitUntilEnabled().sendKeys(title);
    }

    public void enterPrice(String price){
        WebElement mobileElement = TxtPrice;
        element(mobileElement).click();
        element(mobileElement).clear();
        element(mobileElement).sendKeys(price);
        pressBackButton();
    }

    public void selectItemCondition(String condition){
        driver.findElement(By.xpath(String.format("//android.widget.RadioButton[@text='%s']", condition))).click();
    }

    public void turnOnMailing(String mailingDetail){
        element(TglMailing).click();
        WebElement mobileElement = TxtMailing;
        element(mobileElement).clear();
        element(mobileElement).sendKeys(mailingDetail);
    }

    public void enterDescription(String description){
        scrollAndClick("DESCRIPTION");
        WebElement mobileElement = TxtDescription;
        element(mobileElement).clear();
        element(mobileElement).sendKeys(description);
    }

    public void submitListing(){
        element(BtnListIt).click();
    }

    //Verify the item after listing successfully methods
    public void closeSummaryScreens(){
        waitAndClick(By.id("com.thecarousell.Carousell:id/btn_close"));
        waitAndClick(By.id("com.thecarousell.Carousell:id/button_close"));
        //element(BtnCloseSummary).waitUntilClickable().click();
        //element(BtnCloseListed).waitUntilClickable().click();
    }

    public void selectMainTab(String tabName){
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='"+tabName+"']"));
        element(element).waitUntilClickable().click();
    }

    public void searchCategory(String category){
        element(TxtSearchField).waitUntilClickable().click();
        sleep(2);
        element(BtnOkGotIt).waitUntilClickable().click();
        element(TxtSearchBar).waitUntilEnabled().sendKeys(category);
    }

    public void selectEverythingElseCategory(){
        element(OptEverythingElseCategory).click();
    }

    public void selectRecentFilter(){
        clickElementByText("SORT/FILTER");
        element(RdoRecent).waitUntilClickable().click();
    }

    public void clickSeeFilteredResults(){
        element(BtnSeeFilteredResults).waitUntilClickable().click();
    }

    public void searchItem(String title) {
        element(TxtSearchField).waitUntilClickable().click();
        WebElement mobiElement = TxtSearchBar;
        element(mobiElement).waitUntilEnabled().clear();
        element(mobiElement).sendKeys(title);
        ((AndroidDriver)appiumDriver).pressKeyCode(66); //Enter key
    }

    public void verifyProductPostTitle(String title){
        waitVisibility(By.xpath("com.thecarousell.Carousell:id/text_attribute_1"));
        assertEquals(element(ProductPost).waitUntilEnabled().getText(), title);
    }

    public void verifyProductPrice(String price){
        assertEquals(element(ProductPrice).getText(), "S$"+price);
    }

    public void verifyProductDescription(String description){
        assertEquals(element(ProductDescription).getText(), description);
    }

    public void verifyProductCondition(String condition){
        assertEquals(element(ProductCondition).getText(), condition);
        pressBackButton();
    }

    //Remove listed item from the system
    public void selectListedProduct(int index){
        List<WebElement> elements = driver.findElements(By.id("com.thecarousell.Carousell:id/pic_product"));
        elements.get(index - 1).click();
    }

    public void deleteListedProduct(){
        element(BtnMoreOptions).waitUntilClickable().click();
        element(OptDeleteListing).waitUntilClickable().click();
        element(BtnDelete).click();
    }

    public void closeApplication(){
        appiumDriver.closeApp();
    }
}
