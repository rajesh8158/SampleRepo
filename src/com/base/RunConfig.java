package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class RunConfig {
	public ExtentReports extent;
	public ExtentTest extenttest;
	
	public Properties testdata;
	public String frameworkpath;
	public WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public ExtentReports getExtent() {
		return extent;
	}
	public void setExtent(ExtentReports extent) {
		this.extent = extent;
	}
	public Properties getTestdata() {
		return testdata;
	}
	public void setTestdata(Properties testdata) {
		this.testdata = testdata;
	}
	public String getFrameworkpath() {
		return frameworkpath;
	}
	public void setFrameworkpath(String frameworkpath) {
		this.frameworkpath = frameworkpath;
	}
	public ExtentTest getExtenttest() {
		return extenttest;
	}
	public void setExtenttest(ExtentTest extenttest) {
		this.extenttest = extenttest;
	}
	

}
