package com.carousell.sg.steps.sell;

import com.carousell.sg.pages.LoginScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    LoginScreen loginScreen;

    @Step
    public void login_into_application(String user, String pass){
        loginScreen.clickLoginButton();
        loginScreen.enterUsername(user);
        loginScreen.enterPassword(pass);
        loginScreen.clickLoginButton();
    }
}
