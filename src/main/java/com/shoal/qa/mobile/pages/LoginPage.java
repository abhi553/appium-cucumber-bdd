package com.shoal.qa.mobile.pages;

import com.shoal.qa.mobile.utils.CommonUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
	CommonUtils utils = new CommonUtils();

	@AndroidFindBy (xpath = "//android.widget.EditText[1]")
	@iOSXCUITFindBy (id = "test-Username")
	private WebElement usernameTxtFld;


	@AndroidFindBy (accessibility = "Shoal")
	@iOSXCUITFindBy (id = "Shoal")
	private WebElement appnameShoal;

	@AndroidFindBy (accessibility = "100%, Good for the world Good for your wallet")
	@iOSXCUITFindBy (id = "100%, Good for the world Good for your wallet")
	private WebElement appDecription;

	@AndroidFindBy (accessibility = "show password")
	@iOSXCUITFindBy (id = "show password")
	private WebElement showPasswordBtn;


	@AndroidFindBy (accessibility = "Forgot Password?")
	@iOSXCUITFindBy (id = "Forgot Password?")
	private WebElement forgotPasswordBtn;



	@AndroidFindBy (xpath = "//android.widget.EditText[2]")
	@iOSXCUITFindBy (id = "test-Password")
	private WebElement passwordTxtFld;
	
	@AndroidFindBy (accessibility = "Login")
	@iOSXCUITFindBy (id = "Login")
	private WebElement loginBtn;

	@AndroidFindBy (accessibility = "LOGIN")
	@iOSXCUITFindBy (id = "LOGIN")
	private WebElement userdataLoginBtn;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private WebElement errTxt;

	public LoginPage(){
	}

public LoginPage enterUserName(String username) throws InterruptedException {
	click(usernameTxtFld);
	sendKeys(usernameTxtFld, username, "login with " + username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public ProductsPage pressLoginBtn() {
	click(loginBtn, "press login button");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    return new ProductsPage();
}

public ProductsPage login(String username, String password) throws InterruptedException {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

public String getErrTxt() {
	String err = getText(errTxt, "error text is - ");
	return err;
}

	public void verifyLoginScreen() {
		if(loginBtn.isDisplayed()){
			Assert.assertEquals(appnameShoal.getText(),"Shoal");
		}else{
			utils.log().info("User is not on Login screen");
		}
	}

	public void loginButtonDisplayed() {
		loginBtn.isDisplayed();

	}

	public void clickOnLoginMainPage() {
		click(userdataLoginBtn, "User is has clicked on login button after entering details");
		Assert.assertEquals(loginBtn.getText(),"Title of page");
	}
}
