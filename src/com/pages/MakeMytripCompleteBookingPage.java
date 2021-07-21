package com.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.base.RunConfig;
import com.common.ReusuableFunctions;

public class MakeMytripCompleteBookingPage extends ReusuableFunctions{
	
	public MakeMytripCompleteBookingPage(RunConfig runconfig) {
		super(runconfig);
	}
	private By completebookinlabel=By.xpath("//div[@class='pageHeader' and contains(.,'Complete your booking')]");
	public By fromtolabel=By.xpath("//h2[@class='blackFont']");
	private By reviewbookinlabel=By.xpath("//h4[ contains(.,'Review your booking')]");
	public By reviewfromtolabel=By.xpath("//div[@class='rvw-labelView-block']/following-sibling::div//span");
	
	public void waitForCompleteBookingpageLoads() {
		waitForElementVisible(completebookinlabel, "Comlpete Booking Label",30);
		
	}
	public void verifyDestinationAndSource() {
		if(clickVisible(completebookinlabel,"Complete Booking header",30)) {
			String fromtotext=findElement(fromtolabel).getText();
			assertEquals(fromtotext.split(" ")[0].trim().toUpperCase(), testdata.getProperty("FromCity").toUpperCase());
		}else {//if review booking details displayed
			waitForElementVisible(reviewfromtolabel, "From and TO ");
			String fromtotext=findElement(reviewfromtolabel).getText();
			assertEquals(fromtotext.split("-")[0].trim().toUpperCase(), testdata.getProperty("FromCityCode").toUpperCase());
			
		}
		
		addScreenshotInReport();
	
	}
	public void navToNewWindow() {
		switchToNewtab();
	}
	public void verifyDestinationNotFound() {
		String destinationnotused=testdata.getProperty("FromCityNotUsed");
		String destinationcodenotused=testdata.getProperty("FromCityCodeNotUsed");
		if(clickVisible(completebookinlabel,"Complete Booking header",20)) {
			String fromtotext=findElement(fromtolabel).getText();
			assertEquals(fromtotext.split(" ")[0].trim().toUpperCase(), destinationnotused.toUpperCase());
		}else {//if review booking details displayed
			String fromtotext=findElement(reviewfromtolabel).getText();
			assertEquals(fromtotext.split("-")[0].trim().toUpperCase(), destinationcodenotused.toUpperCase());
			
		}
		
		addScreenshotInReport();
	}
	
	
	
	
	
	
}
