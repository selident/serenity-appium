package com.carousell.sg.test.sell;

import com.carousell.sg.steps.sell.LoginSteps;
import com.carousell.sg.steps.sell.SellSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SellTest {

    @Managed(uniqueSession =  true)
    public WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    SellSteps sellSteps;

    @Test
    public void add_an_item_to_sell(){
        loginSteps.login_into_application();
        sellSteps.add_item_under_specific_category();
        sellSteps.verify_item_is_listed_under_specific_catogory();
    }
}
