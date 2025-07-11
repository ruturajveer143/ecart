package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class ProductInfoPage {

	public ProductInfoPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='product-information']")
	WebElement productInfo;

	public String productDetails() {
		return productInfo.getText();

	}

}
