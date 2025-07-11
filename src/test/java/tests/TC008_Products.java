package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.ProductInfoPage;
import com.pageObjects.ProductsPage;

public class TC008_Products extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	void productCheck() {

		HomePage home = new HomePage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");
		home.click("products");

		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Products Page title mismatch");

		ProductsPage produ = new ProductsPage();

		//String productDetails = produ.singleProductIngo(1);
		//System.out.println(productDetails);
		
		int count = produ.productCount();
		Assert.assertTrue(count > 0, "Product list is empty!");

		produ.viewProductBtn(2);
		ProductInfoPage productInfo = new ProductInfoPage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Product Details",
				"Product Detail Page title mismatch");

		String getDetails = productInfo.productDetails();
		Assert.assertTrue(getDetails.contains("Category"), "Product Details is empty!"); 
		// System.out.println(getDetails);
	}

	@AfterClass
	void close() {
		tearDown();
	}
}
