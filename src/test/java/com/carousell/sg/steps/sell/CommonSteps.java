package com.carousell.sg.steps.sell;

import Utility.AppiumUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {

    @Step
    public static void start_appium_server(){
        AppiumUtil.startServer();
    }

    @Step
    public static void stop_appium_server(){
        AppiumUtil.stopServer();
    }
}
