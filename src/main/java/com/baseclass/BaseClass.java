package com.baseclass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.ConfigReader;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log;

	public WebDriver setupDriver(String getBrowser) {
		log = (Logger) LogManager.getLogger(this.getClass());
		log.info("========== Starting ==========");
		String browser = getBrowser != null ? getBrowser : ConfigReader.get("browser");
		log.info("Opening Browser: " + browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			log.error("Browser Not Supported!: " + browser);
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().window().maximize();
		log.info("Maximize the Window!");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.get(ConfigReader.get("url"));
		log.info("Opening the URL: " + ConfigReader.get("url"));

		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			log.warn("Driver is Null!");
			throw new IllegalStateException("WebDriver has not been initialized. Call setupDriver() first.");
		}
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			log.info("Closeing the Browser!");
			log.info("========== Ending ==========\n");
			driver.quit();
			driver = null;
		}
	}
}

//package com.baseclass;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import com.util.ConfigReader;
//
//public class BaseClass {
//
//	WebDriver driver;
//
//	public void setupDriver(String getbrowser) {
//		String browser = getbrowser != null ? getbrowser : ConfigReader.get("browser");
//
//		switch (browser.toLowerCase()) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//
//		default:
//			throw new RuntimeException("Browser not Supported: " + browser);
//
//		}
//
//		driver.manage().window().maximize();
//		driver.get(ConfigReader.get("url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
//
//	}
//
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
//
//}
