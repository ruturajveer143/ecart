package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.screenshot.ScreenShotUtil;

public class CustomListeners implements ITestListener {
	
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest tests;
	

	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/report.html");
		report = new ExtentReports();
		
		spark.config().setReportName("ECart");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Reports");
		report.attachReporter(spark);
		report.setSystemInfo("Computer Name", "Asus:localhost");
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Tester Name", "QA Lead");
        report.setSystemInfo("OS", "WINDOWS");
        report.setSystemInfo("Browser", "Chrome");
		
	}

	public void onTestStart(ITestResult result) {
		 tests = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String path = System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png";
		
		ScreenShotUtil.captureSC(path);
		tests.addScreenCaptureFromPath(path,"Failure Screenshot");
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
