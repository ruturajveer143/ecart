package com.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;

public class SignUpPage extends BaseClass {
	

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement userName;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement userEmail;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signupBtn;

	public void setUserDetails(String name, String email) {
		
		log.info("Entering the User Details!");
		userName.sendKeys(name);
		log.info("Set the Name: "+name);
		userEmail.sendKeys(email);
		log.info("Set the Email: "+email);
		signupBtn.click();
		log.info("Clicked on SignUp Button");

	}

	// Personal info
	@FindBy(id = "id_gender1")
	WebElement genderTitle1;
	@FindBy(id = "id_gender2")
	WebElement genderTitle2;
	@FindBy(id = "name")
	WebElement name;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "days")
	WebElement days;
	@FindBy(id = "months")
	WebElement months;
	@FindBy(id = "years")
	WebElement years;
	@FindBy(id = "newsletter")
	WebElement newsletterCheckBox;
	@FindBy(id = "optin")
	WebElement offersCheckBox;

	public void setPersonalInfo(String gender, String name1, String email1, String pass, String day, String month,
			String year) {
		log.info("Entering the Personal Inforamtion!");
		if (gender.toLowerCase().equals("male")) {
			genderTitle1.click();
		} else {
			genderTitle2.click();
		}

		// name.sendKeys(name1);
		// email.sendKeys(email1);

		password.sendKeys(pass);

		Select sc1 = new Select(days);
		sc1.selectByValue(day);

		Select sc2 = new Select(months);
		sc2.selectByValue(month);

		Select sc3 = new Select(years);
		sc3.selectByValue(year);

		// newsletterCheckBox.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", newsletterCheckBox);
		// offersCheckBox.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", offersCheckBox);

	}

	// Address
	@FindBy(id = "first_name")
	WebElement first_name;
	@FindBy(id = "last_name")
	WebElement last_name;
	@FindBy(id = "company")
	WebElement company;
	@FindBy(id = "address1")
	WebElement address1;
	@FindBy(id = "address2")
	WebElement address2;
	@FindBy(id = "country")
	WebElement country;
	@FindBy(id = "state")
	WebElement state;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "zipcode")
	WebElement zipcode;
	@FindBy(id = "mobile_number")
	WebElement mobile_number;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccountBtn;
	

	public void setAddressInfo(String f_name, String l_name, String companyName, String firstAddress,
			String secondAddress, String countryName, String stateName, String cityName, String zip, String mobile) {
		log.info("Entering the Address!");
		first_name.sendKeys(f_name);
		last_name.sendKeys(l_name);
		company.sendKeys(companyName);
		address1.sendKeys(firstAddress);
		address2.sendKeys(secondAddress);

		Select sc = new Select(country);
		sc.selectByVisibleText(countryName);

		state.sendKeys(stateName);
		city.sendKeys(cityName);
		zipcode.sendKeys(zip);
		mobile_number.sendKeys(mobile);
		
		log.info("Clicked On Create Account Button!");
		createAccountBtn.click();
	}
	

}
