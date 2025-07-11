package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.HomePage;

public class TC000_HomePage extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	 void TC001_HomePage() {
		
		String homeTitle = driver.getTitle();
//		String expectedTitle = "Automation Exercise";
		Assert.assertEquals(homeTitle, "Automation Exercise", "Home Page title mismatch");
		log.info("Verified Title: "+homeTitle);
	}

	@AfterClass
	void close() {
		tearDown();
	}

}
