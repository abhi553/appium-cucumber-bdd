package com.shoal.qa.mobile.pages;

import com.shoal.qa.mobile.utils.CommonUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage{


    CommonUtils utils = new CommonUtils();
    public SignUpPage(){
    }
    @AndroidFindBy(accessibility = "SIGNUP")
    @iOSXCUITFindBy(id = "SIGNUP")
    private WebElement signUpBtn;

    public static class clickSignup {
    }
}
