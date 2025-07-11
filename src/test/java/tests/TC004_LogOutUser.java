package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.SignInPage;
import com.util.ConfigReader;

public class TC004_LogOutUser extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	void LogOut() throws Exception {
		HomePage home = new HomePage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");

		home.click("signin");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login",
				"Signup/Login page title mismatch");

		SignInPage signin = new SignInPage();
		signin.doLogin(ConfigReader.get("gmail"), ConfigReader.get("password"));

		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Login Fail Title Not match");

		if (home.isLoggedIn().contains("Logged in as")) {
			home.click("logout");
			// home.click("deleteAccount");
		} else {
			throw new Exception("User Not logged In");
		}

		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login",
				"Signup/Login page title mismatch");

	}

	@AfterMethod
	void close() {
		 tearDown();
	}

}
