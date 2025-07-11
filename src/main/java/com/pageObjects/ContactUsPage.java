package com.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class ContactUsPage {

	public ContactUsPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);

	}

	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement name;
	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement email;
	@FindBy(xpath = "//input[@data-qa='subject']")
	WebElement subject;

	@FindBy(id = "message")
	WebElement messageBox;
	@FindBy(name = "upload_file")
	WebElement fileUpload;

	@FindBy(name = "submit")
	WebElement submitBtn;

	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement alertMesg;

	@FindBy(xpath = "//div[@id='form-section']/a")
	WebElement homeBtn;

	public String doContactUs(String setName, String setEmail, String setSubject, String setMessage, String filePath) {
		name.sendKeys(setName);
		email.sendKeys(setEmail);
		subject.sendKeys(setSubject);
		messageBox.sendKeys(setMessage);
		fileUpload.sendKeys(filePath);
		submitBtn.click();

		Alert alert1 = BaseClass.getDriver().switchTo().alert();

		alert1.accept();
		
		String msg = alertMesg.getText();

		homeBtn.click();

		return msg;

	}

}
