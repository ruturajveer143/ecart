package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.SignUpPage;
import com.util.ConfigReader;

public class TC001_RegisterUser extends BaseClass {

	@BeforeMethod
	public void init() {
		setupDriver(null);
	}

	@Test(description = "Register a new user")
	public void doSignup() throws Exception {

		HomePage home = new HomePage();
		String Hometitle = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", " Home Page title mismatch");
		log.info("Verified Title: "+Hometitle);
		home.click("signup");
		
		SignUpPage signUp = new SignUpPage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login",
				"Signup/Login page title mismatch");

		signUp.setUserDetails(ConfigReader.get("user_name"), ConfigReader.get("gmail"));
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup", "Signup page title mismatch");

		signUp.setPersonalInfo("Male", null, null, ConfigReader.get("password"), "25", "2", "2000");

		signUp.setAddressInfo("Ruturaj", "Patil", "xyz pvt ltd", "PCMC", "Pune", "India", "MH", "Pune", "411019",
				"9745122541");

		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created",
				"Account Created title mismatch");
		
		home.contiuneLogin();
		
		if(home.isLoggedIn().contains("Logged in as")){
			
			home.click("logout");
			//home.click("deleteAccount");
		}else {
			throw new Exception ("User Not logged In");
		}
	}

	@AfterClass
	void close() {
		tearDown();
	}
}
