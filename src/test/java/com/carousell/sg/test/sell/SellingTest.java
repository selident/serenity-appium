package com.carousell.sg.test.sell;

import com.carousell.sg.steps.sell.CommonSteps;
import jxl.write.DateTime;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.carousell.sg.steps.sell.LoginSteps;
import com.carousell.sg.steps.sell.SellSteps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SerenityRunner.class)
public class SellingTest {

    @Managed(uniqueSession =  true)
    public WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SellSteps sellSteps;

    @BeforeClass
    public static void start_appium_server() {
        CommonSteps.stop_appium_server();
        CommonSteps.start_appium_server();
    }

    @Test
    public void add_an_item_to_sell(){
        DateFormat sdfr = new SimpleDateFormat("ddMMyyyyHHmmss");
        String title = sdfr.format(new Date());
        String category = "Everything Else";
        String price = "500";
        String condition = "Used";
        String description = "This is the testing item, please ignore it. Selling Cannon 70D + Lense 50mm, captured 12000 shots, still in the guarantee period.";

        loginSteps.login_into_application("longhoangly", "123456");
        sellSteps.add_item_under_specific_category(category, title, price, condition, "Free Ship", description);
        sellSteps.verify_item_is_listed_under_specific_catogory(category, title, price, description, condition);
        sellSteps.remove_the_listed_item(1);
        sellSteps.close_application();
    }

    @AfterClass
    public static void stop_appium_server() {
        CommonSteps.stop_appium_server();
    }
}
