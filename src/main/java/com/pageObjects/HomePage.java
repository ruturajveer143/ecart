package com.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class HomePage extends BaseClass {
	
	private Map<String, WebElement> elements;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		elements = new HashMap<>();
		elements.put("home", homeBtn);
		elements.put("products", productsBtn);
		elements.put("signup", signUpBtn);
		elements.put("signin", signUpBtn);
		elements.put("testcases", testCasesBtn);
		elements.put("apilist", apiListBtn);
		elements.put("videos", videoBtn);
		elements.put("contact", contactUsBtn);
		elements.put("logout", logOutBtn);
		elements.put("deleteAccount", deleteAccount);
	}

	// Nav Bar Buttons
	@FindBy(xpath = "//li/a[@href='/']")
	WebElement homeBtn;
	@FindBy(xpath = "//a[@href='/products']")
	WebElement productsBtn;

	@FindBy(xpath = "//li/a[@href='/view_cart'])")
	WebElement cartBtn;
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signUpBtn;

	@FindBy(xpath = "//li/a[@href='/test_cases']")
	WebElement testCasesBtn;
	@FindBy(xpath = "//li/a[@href='/api_list']")
	WebElement apiListBtn;

	@FindBy(xpath = "//a[text()=' Video Tutorials']")
	WebElement videoBtn;
	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement contactUsBtn;
	
	@FindBy(xpath="//a[@href='/logout']") WebElement logOutBtn;
	@FindBy(xpath="//a[@href='delete_account']") WebElement deleteAccount;
	
	
	
	@FindBy(xpath = "//li/a[contains(text(),'Logged in as')]") WebElement loggedIn_User;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']") WebElement continueBtn;
	
	public String title() {
		return driver.getTitle();
	}
	public void contiuneLogin() {
		log.info("Clicked on Continue Button....");
		continueBtn.click();
	}
	
	public String isLoggedIn() {
		String name = loggedIn_User.getText();
		log.info("Verifying Logged in User Name: "+name);
		 boolean b = loggedIn_User.isDisplayed();
		return b +" "+ name;
	}
	

	public void click(String btnName) {
		
		WebElement element = elements.get(btnName);
		if (element == null) {
			log.warn("Element Not Present!");
			throw new IllegalArgumentException("No element for key: " + btnName);
		}
		log.info("Clicked on "+btnName+" Button!");
		element.click();
	}

}
