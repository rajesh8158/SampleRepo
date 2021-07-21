package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.MakeMytripCompleteBookingPage;
import com.pages.MakeMytripLandingPage;
import com.pages.MakeMytripSearchResultPage;

public class MMT_SearchFlight_Negetive extends BaseClass {
	@Test
	public void TC_01_Search_Flight_Negetive() {
		
		
		createTestInExtent("Test Case-TC_01_Search_Flight_Negetive");
		
		MakeMytripLandingPage mtmlandingpage=new MakeMytripLandingPage(runconfig);
		MakeMytripSearchResultPage mtmsearchresult=new MakeMytripSearchResultPage(runconfig);
		MakeMytripCompleteBookingPage mtmcompltbooking=new MakeMytripCompleteBookingPage(runconfig);
		
		
		
		mtmlandingpage.waitForLandingPage();
		mtmlandingpage.clickFlightToAvoidLoginPopup();
		mtmlandingpage.enterFromCity();
		mtmlandingpage.enterToCity();
		mtmlandingpage.selectDateOfJourney();
		mtmlandingpage.searchFlight();
		
		mtmsearchresult.waitforSearchResultToLoad();
		mtmsearchresult.ViewPrice();
		mtmsearchresult.bookNow();
		
		mtmcompltbooking.navToNewWindow();
		//mtmcompltbooking.waitForCompleteBookingpageLoads();
		mtmcompltbooking.verifyDestinationNotFound();
		
		
		
	}

}
