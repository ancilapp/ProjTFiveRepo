package com.ProjTFive.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
		
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Aaron ninja test report");
		sparkReporter.config().setDocumentTitle("Test Execution Document Title");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ProjTFive\\config\\Config.properties");
		
		try {
		FileInputStream fisConfigProp = new FileInputStream(configPropFile); 
		configProp.load(fisConfigProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		extentReport.setSystemInfo("Appication URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser used",configProp.getProperty("browser"));
		extentReport.setSystemInfo("Operating Stsyem",System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version",System.getProperty("java.version"));
		
		return extentReport;
		
	}
}
