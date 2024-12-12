package com.ProjTFive.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ProjTFive.utils.ExtentReporter;
import com.ProjTFive.utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test execution started");
		extentReport = ExtentReporter.generateExtentReport();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {

		//System.out.println(testName + " started executing");
		  extentTest = extentReport.createTest(result.getName()); 
		  extentTest.log(Status.INFO,result.getName() + " started executing");
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//testName = result.getName();
		System.out.println(result.getName() + " Passed");
		extentTest.log(Status.PASS,result.getName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//testName = result.getName();
		System.out.println(result.getName() + " Failed");
		System.out.println(result.getThrowable());		
		
		
		  WebDriver driver = null;
		  

			  try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		  
			String destScreenshotPath = Utilities.captureScreenshot(driver, result.getName());
		  
		  extentTest.addScreenCaptureFromPath(destScreenshotPath);
		  extentTest.log(Status.INFO,result.getThrowable());
		  extentTest.log(Status.FAIL,result.getName() + " Failed");
		 

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//testName = result.getName();
		//System.out.println(testName + " is Skipped");
		
		  extentTest.log(Status.INFO, result.getThrowable());
		  extentTest.log(Status.SKIP, result.getName() + " is Skipped");
		 
	}


	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("Test execution is completed");
		extentReport.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File (pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
