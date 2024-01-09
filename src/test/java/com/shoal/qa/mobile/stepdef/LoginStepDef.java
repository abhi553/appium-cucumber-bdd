package com.shoal.qa.mobile.stepdef;

import com.shoal.qa.mobile.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class LoginStepDef {


    @Given("that the user launches the BASRON application on the mobile")
    public void thatTheuserLaunchesTheBarsonAppOnMobile() throws InterruptedException {
        new LoginPage().launchApp();
    }
    @When("the sign in screen displayed")
    public void theSignInScreenDisplayed() throws InterruptedException {
        new LoginPage().verifyLoginScreen();
    }

    @When("user enters username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("user enters password as {string}")
    public void iEnterPasswordAs(String password) {

        new LoginPage().enterPassword(password);
    }

    @When("the user clicks on Login button")
    public void theUserClicksOnLoginButton() {

        new LoginPage().pressLoginBtn();
    }
    @Then("user clicks on Login button after entering data")
    public void userClicksOnLoginButtonAfterEnteringData() {
        new LoginPage().clickOnLoginMainPage();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {

        Assert.assertEquals(new LoginPage().getErrTxt(), err);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals("Product page", title);
    }

    @Given("that user is on the Dashboard")
    public void thatUserIsOnTheDashboard() {

    }

    @When("the user verify the list")
    public void theUserVerifyTheList(){

    }
    @Then ("user sees requests")
    public void userSeesRequest(){

    }

    @And("user seees the option to historical requests")
    public void userSeesTheOptionToHistoricalRequests(){

    }

    @And ("user sees the option to trigger the reconciliation")
    public void userSeesTheOptionToTriggerTheReconciliation(){

    }
}
