package com.carousell.sg.steps.sell;

import com.carousell.sg.pages.SellScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SellSteps extends ScenarioSteps {

    SellScreen sellScreen;

    @Step
    public void add_item_under_specific_category(String category, String title, String price, String condition, String mailing, String description){
        sellScreen.clickSellButton();
        sellScreen.allowToAccessPhotos();
        sellScreen.selectProductImages();
        sellScreen.clickNextButton();
        sellScreen.selectListingCategory(category);
        sellScreen.enterTitle(title);
        sellScreen.enterPrice(price);
        sellScreen.selectItemCondition(condition);
        sellScreen.turnOnMailing(mailing);
        sellScreen.enterDescription(description);
        sellScreen.submitListing();
    }

    @Step
    public void verify_item_is_listed_under_specific_catogory(String category, String title, String price, String description, String condition){
        sellScreen.closeSummaryScreens();
        sellScreen.selectMainTab("BROWSE");
        sellScreen.searchCategory(category);
        sellScreen.selectEverythingElseCategory();
        sellScreen.selectRecentFilter(); //ToDo: Should allow to enter filter name here!!!
        sellScreen.clickSeeFilteredResults();
        sellScreen.searchItem(title);
        sellScreen.verifyProductPostTitle(title);
        sellScreen.verifyProductPrice(price);
        sellScreen.verifyProductDescription(description);
        sellScreen.verifyProductCondition(condition);
    }

    @Step
    public void remove_the_listed_item(int index){
        sellScreen.selectMainTab("ME");
        for (int i=0; i < index; i++){
            sellScreen.selectListedProduct(1);
            sellScreen.deleteListedProduct();
        }
    }

    @Step
    public void close_application(){
        sellScreen.closeApplication();
    }
}
