package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePagetest extends BaseTest {
	
			
	@Test
	public void homepageTitleTest() {
		String actualtitle=homepage.getHomePageTitle();
		Assert.assertEquals(actualtitle, AppConstants.Login_page_Title);
	}
	@Test
	public void homepageURLTest() {
		String actualurl=homepage.getHomePageURL();
		Assert.assertEquals(actualurl, prop.getProperty("url"));
	}
	
	@DataProvider
	
	public Object[][] getproductData() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"samsung"}
		};
	}
	
	
	
	@Test(dataProvider="getproductData")
	public void searchtest(String productname) {
		String actualheader=homepage.doSearch(productname);
		Assert.assertEquals(actualheader, "Search - " +productname);
	}
	
	
	

	
	
	//MacBook Air. Power that puts in the hours.
	

}
