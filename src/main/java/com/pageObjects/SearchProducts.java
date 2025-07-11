package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SearchProducts {

	public SearchProducts() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(id = "search_product")
	WebElement searchBox;
	@FindBy(id = "submit_search")
	WebElement searchBtn;

	@FindBy(xpath = "//h2[text()='Searched Products']")
	WebElement title;

	public void doSearch(String productName) {
		searchBox.clear();
		searchBox.sendKeys(productName);
		searchBtn.click();

	}

	public String gettitle() {
		return title.getText();
	}

}
