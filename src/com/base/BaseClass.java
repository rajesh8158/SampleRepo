package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	private static String frameworkpath = null;
	private static Properties configproperties = null;
	private static Properties testdata = null;
	private static WebDriver driver = null;
	private static ExtentReports extent=null;
	private ExtentTest extenttest=null;
	public RunConfig runconfig=null;

	public BaseClass() {
		frameworkpath = getFrameworkRootPath();

	}
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		
		setUpConfig();
		setUpExtentReport();
		
		
		
			
	}
	@BeforeClass
	public void beforeTest() throws FileNotFoundException, IOException {
		setUpTestData();				
		LaunchBrowser();
		setupRunConfig();
		driver.navigate().to(configproperties.getProperty("ApplicationUrl"));
	}
	@AfterClass
	public void afterTest() {
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void afterSuite() {
		//extent
	}
	

	private void LaunchBrowser() {
		if (configproperties.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			String driverpath = frameworkpath + File.separator + "resource"+File.separator+"chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
			maximizeBrowser();

		} else if (configproperties.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.err.println("Implementation of the code is pending");
		} else if (configproperties.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.err.println("Implementation of the code is pending");
		} else  if (configproperties.getProperty("Browser").equalsIgnoreCase("Edge")){
			System.err.println("Implementation of the code is pending");
		}
	}

	public String getFrameworkRootPath() {
		return System.getProperty("user.dir");

	}

	private void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void closeBrowser() {
		driver.close();
		driver.quit();

	}

	private void setUpConfig() throws FileNotFoundException, IOException {
		String configfilepath = frameworkpath + File.separator + "Config.properties";
		configproperties = new Properties();
		configproperties.load(new FileReader(configfilepath));

	}
	private void setUpTestData() throws FileNotFoundException, IOException {
		String configfilepath = frameworkpath + File.separator + "TestData"+File.separator+"TestData.properties";
		testdata = new Properties();
		testdata.load(new FileReader(configfilepath));

	}
	private void setUpExtentReport() {
		extent=new ExtentReports();
		ExtentSparkReporter extentspark=new ExtentSparkReporter(frameworkpath+File.separator+"Result"+File.separator+"ExecutionExtentReport.html");
		extent.attachReporter(extentspark);
		
	}
	private String getTimeStamp() {
		Calendar cal=Calendar.getInstance();
		return String.valueOf(cal.getTime().parse("MMddyyhhmmss"));
		
	}
	private void setupRunConfig() {
		//setup runconfig
		runconfig=new RunConfig();
		runconfig.setExtent(extent);
		runconfig.setFrameworkpath(frameworkpath);
		runconfig.setTestdata(testdata);
		runconfig.setDriver(driver);
	}
	public void createTestInExtent(String testname ){
		runconfig.setExtenttest( extent.createTest(testname));
	}

}
