package com.common;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.RunConfig;

public class ReusuableFunctions {
	public ExtentReports extent;
	
	public Properties testdata;
	public String frameworkpath;
	public WebDriver driver;
	private static final long timeout=30;
	public ExtentTest extenttest=null;
	
	public ReusuableFunctions(RunConfig runconfig) {
		this.extent=runconfig.getExtent();
		this.testdata=runconfig.getTestdata();
		this.frameworkpath=runconfig.getFrameworkpath();
		this.driver=runconfig.getDriver();
		this.extenttest=runconfig.getExtenttest();
	}
	protected void clickElement(By by,String identifiername) {
		driver.findElement(by).click();
		extenttest.pass("Element "+identifiername +" was clicked successfully");
		extent.flush();
		
	}
	protected void setdata(By by,String data,String identifiername) {
		driver.findElement(by).sendKeys(data);
		extenttest.pass("data '"+data+"' was entered in element "+identifiername +" was clicked successfully");
		extent.flush();
	}
	protected void waitForElementVisible(By by,String identifiername) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		extenttest.pass("Waited for element "+identifiername +" to be visible:True");
		extent.flush();
		
	}
	protected void waitForElementVisible(By by,String identifiername,int sec) {
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		extenttest.pass("Waited for element "+identifiername +" to be visible:True");
		extent.flush();
		
	}
	protected void waitForElementToBeClickable(By by,String identifiername)  {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		hardWait(2);//to handle the sync of dyanamic elements
		extenttest.pass("Waited for element "+identifiername +" to be clickable:True");
		extent.flush();
		
	}
	protected void waitForElementToBeClickable(By by,String identifiername,int sec)  {
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		hardWait(2);//to handle the sync of dyanamic elements
		extenttest.pass("Waited for element "+identifiername +" to be clickable:True");
		extent.flush();
		
	}
	
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
		
	}
	protected boolean isDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}
	protected void hardWait(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected void clickIfExist(By by,String identifiername,int timeout) {
		try {
			waitForElementToBeClickable(by, identifiername,timeout);
			clickElement(by, identifiername);
		} catch (Exception e) {
			// TODO: handle exception
			extenttest.info("Element not found : "+identifiername);
			extent.flush();
		}
	}
	protected boolean clickVisible(By by,String identifiername,int timeout) {
		try {
			waitForElementToBeClickable(by, identifiername,timeout);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			extenttest.info("Element not found : "+identifiername);
			return false;
		}
	}
	protected void switchToNewtab(){
		
		String curwindow=driver.getWindowHandle();
		Set<String> list= driver.getWindowHandles();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(!curwindow.equalsIgnoreCase(string)) {
				driver.switchTo().window(string);
				break;
			}
			
		}
		
		
	}
	public void addScreenshotInReport() {
		TakesScreenshot screen=(TakesScreenshot)driver;
		String base64=screen.getScreenshotAs(OutputType.BASE64);
		extenttest.addScreenCaptureFromBase64String(base64);
		
	}
	
	
	
}
