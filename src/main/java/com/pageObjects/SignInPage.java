package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SignInPage extends BaseClass{
	
	public SignInPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement emaillogin;
	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement passwordlogin;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginBtn;

	public void doLogin(String getEmail, String getPass) {
		log.info("Performing Login!");
		
		emaillogin.sendKeys(getEmail);
		passwordlogin.sendKeys(getPass);
		log.info("Sending Login Details- Email: "+getEmail+"| Password: "+getPass);
		log.info("Click on Login Button");
		loginBtn.click();

	}
	

}
