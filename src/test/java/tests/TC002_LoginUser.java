package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.listeners.CustomListeners;
import com.pageObjects.HomePage;
import com.pageObjects.SignInPage;
import com.util.ConfigReader;

@Listeners({CustomListeners.class})
public class TC002_LoginUser extends BaseClass {

	@BeforeMethod
	void init() {
		setupDriver(null);
	}

	@Test
	void Login() throws Exception {

		HomePage home = new HomePage();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home Page title mismatch");
		
		home.click("signin");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login",
				"Signup/Login page title mismatch");
		
		SignInPage signIn = new SignInPage();
		signIn.doLogin(ConfigReader.get("gmail"), ConfigReader.get("password"));

		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Login Page Title Not match");
		
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
