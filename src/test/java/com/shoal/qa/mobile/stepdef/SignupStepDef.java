package com.shoal.qa.mobile.stepdef;


import com.shoal.qa.mobile.pages.SignUpPage;
import io.cucumber.java.en.When;

public class SignupStepDef {
    @When("clicks on signup")
    public void clickOnSignup() throws InterruptedException {
        new SignUpPage.clickSignup();
    }


}
