package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.base.RunConfig;
import com.common.ReusuableFunctions;

public class MakeMytripLandingPage extends ReusuableFunctions{
	
	public MakeMytripLandingPage(RunConfig runconfig) {
		super(runconfig);
	}
	
	By fromcity=By.id("fromCity");
	By tocity=By.id("toCity");
	By depdatecal=By.xpath("//p[@data-cy='departureDate']");
	By searchbtn=By.xpath("//p[@data-cy='submit']");
	By autosugbox=By.xpath("//div[contains(@class,'hsw_autocomplePopup autoSuggestPlugin')]/descendant::input");
	By autosugfirstelement=By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/descendant::li");
	By flight=By.xpath("//li[@class='menu_Flights']");
	By Loginpopup=By.xpath("//p[contains(.,'Login/Signup for Best Prices')]");
	By loginorcreate=By.xpath("//p[contains(.,'Login or Create Account')]");
	
	private By getDateOfJourney(String doj) {
		return By.xpath("//div[@class='DayPicker-Day' and @aria-label='"+doj+"']");
		
	}
	private By getAutoSugFirstEle(String city) {
		return By.xpath("(//div[contains(@class,'autoSuggestPlugin')]/descendant::li[contains(.,'"+city+"')])[1]");
	}
	
	public void enterFromCity() {
		clickElement(fromcity,  "From City textBox");
		waitForElementToBeClickable(autosugbox, "Auto Suggestion Box");
		setdata(autosugbox, testdata.getProperty("FromCity"), " From City textBox");
		hardWait(2);
		waitForElementVisible(getAutoSugFirstEle(testdata.getProperty("FromCity")), testdata.getProperty("FromCity"));
		clickElement(getAutoSugFirstEle(testdata.getProperty("FromCity")), testdata.getProperty("FromCity")+ " from List");
		
	}
	public void enterToCity() {
		//clickElement(tocity,  "To City textBox");//because this will be always opned up after entering to city
		waitForElementToBeClickable(autosugbox, "Auto Suggestion box");
		setdata(autosugbox, testdata.getProperty("ToCity"), " To City textBox");
		hardWait(2);
		waitForElementToBeClickable(getAutoSugFirstEle(testdata.getProperty("ToCity")), "Auto suggestion result");
		clickElement(getAutoSugFirstEle(testdata.getProperty("ToCity")), testdata.getProperty("ToCity")+ " from List");
		
	}
	public void selectDateOfJourney() {
		//waitForElementToBeClickable(depdatecal, "date Calender");
		//clickElement(depdatecal, "date Calender");
		waitForElementToBeClickable(getDateOfJourney(testdata.getProperty("DOJ")), " Date on calender "+testdata.getProperty("DOJ"));
		clickElement(getDateOfJourney(testdata.getProperty("DOJ")), " Date on calender "+testdata.getProperty("DOJ"));
	}
	public void waitForLandingPage() {
		
		waitForElementToBeClickable(fromcity, "From City text box");
		
	}
	public void clickFlightToAvoidLoginPopup() {
		try {
			waitForElementVisible(Loginpopup, "Login popup",20);
			if(isDisplayed(Loginpopup)) {
				//clickElement(loginorcreate, "Login or Create Emnu");
				new Actions(driver).click(findElement(loginorcreate)).perform();
			}else {
				//do nothing //popup is not there
			}
		} catch (Exception e) {
			// TODO: handle exception
			//do nothing //popup is not there
			
			
		}
	}
	public void searchFlight() {
		clickElement(searchbtn, "Search button");
	}
	
	
	
	
}
