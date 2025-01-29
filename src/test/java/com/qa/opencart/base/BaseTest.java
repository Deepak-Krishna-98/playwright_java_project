package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.amazon.factory.Playwrightfactory;
import com.qa.amazon.pages.Homepage;
import com.qa.amazon.pages.LoginPage;

public class BaseTest {
	
	Playwrightfactory pf;
	Page page;
	protected Properties prop;
	
	protected Homepage homepage;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		pf= new Playwrightfactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		
		homepage=new Homepage(page);
		
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
		
	}
	

}
