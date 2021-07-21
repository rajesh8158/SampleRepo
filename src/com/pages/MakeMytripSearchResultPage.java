package com.pages;

import org.openqa.selenium.By;

import com.base.RunConfig;
import com.common.ReusuableFunctions;

public class MakeMytripSearchResultPage extends ReusuableFunctions{
	
	public MakeMytripSearchResultPage(RunConfig runconfig) {
		super(runconfig);
	}
	private By okaypopup=By.xpath("//button[contains(.,'OKAY, GOT IT!')]");
	private By filtersection=By.xpath("//div[@class='filterWrapper']");
	private By flightfromlabel=By.xpath("//div[@class='listingRhs']/p[contains(.,'Flights from ')]");
	private By viewpricesfirst=By.xpath("(//span[@class='appendRight8' and contains(.,'View Prices')])[1]");
	private By booknow=By.xpath("(//button[contains(@id,'bookbutton') and contains(.,'Book Now')])[1]");
	
	
	public void waitforSearchResultToLoad() {
		waitForElementVisible(filtersection, "Filter Section");
		waitForElementToBeClickable(flightfromlabel, "Flight from lable");
		//check if ok pop up there
		clickIfExist(okaypopup, "Ok Popup", 10);
	}
	public void ViewPrice() {
		clickElement(viewpricesfirst, "First View Price Button");
		
	}
	public void bookNow() {
		waitForElementToBeClickable(booknow, "First Book Now Button");
		clickElement(booknow, "First Book Now Button");
	}
	
	
	
	
	
	
}
