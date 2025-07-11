package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.ProductsPage;
import com.pageObjects.SearchProducts;

public class TC009_SearchProduct extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	void searchProduct() {
		HomePage home = new HomePage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");
		home.click("products");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Products Page title mismatch");

		ProductsPage product = new ProductsPage();

		// int count = product.productCount();

		List<String> productNames = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			productNames.add(product.singleProductName(i).replaceAll("\\s+", " ").trim());

		}

		SearchProducts search = new SearchProducts();

		for (String name : productNames) {
			search.doSearch(name);

			String title = search.gettitle();
			Assert.assertEquals(title, "SEARCHED PRODUCTS", "Searched Products title mismatch");

			product = new ProductsPage();
			int cnt = product.productCount();
			System.out.println("Found " + cnt + " products for search: " + name);

			List<WebElement> list = product.allProducts();
			for (WebElement li : list) {
				System.out.println(li.getText() + "\n");
			}
		}
	}

	// search.doSearch("White");

	@AfterMethod
	void close() {
		tearDown();
	}

}
