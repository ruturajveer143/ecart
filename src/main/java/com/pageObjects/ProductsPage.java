package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class ProductsPage {

	public ProductsPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	// products page

	@FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")

	List<WebElement> productsList;
	
	@FindBy(xpath="//div[@class='productinfo text-center']/p") List<WebElement> productName;

	@FindBy(xpath = "//a[text()='View Product']")
	List<WebElement> viewProductsBtn;
	
	

	public List<WebElement> allProducts() {
		
		return productsList;
	}

	public int productCount() {
		
		return  productsList.size();
	}

	public String singleProductName(int n) {
		return productName.get(n).getText();
	}

	public void viewProductBtn(int n) {
		// ((JavascriptExecutor) BaseClass.getDriver())
		// .executeScript("document.getElementById('aswift_5').style.display='none';");

		WebElement viewProd = viewProductsBtn.get(n);
		viewProd.click();

	}

}
