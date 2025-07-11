package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.ContactUsPage;
import com.pageObjects.HomePage;
import com.util.ConfigReader;

public class TC006_ContactUs extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	void contactUs() {
		HomePage home = new HomePage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");
		
		home.click("contact");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us", "Contact Title Not match");
		
		ContactUsPage contact = new ContactUsPage();
		String path = "C:\\Users\\rutur\\eclipse-workspace\\com.ecartproject\\screenshots\\Login.png";
		String confirmationMsg = contact.doContactUs(ConfigReader.get("user_name"), ConfigReader.get("gmail"), "LoginError",
				"NULL NULL xyz", path);

		Assert.assertEquals(confirmationMsg, "Success! Your details have been submitted successfully.", "Fail! Your details not submitted");
		
		home.click("home");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");
	}
	
	@AfterClass
	void close() {
		tearDown();
	}

}
