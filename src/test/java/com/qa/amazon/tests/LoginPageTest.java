package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	

	@Test(priority = 1)
	public void loginPageNavigationTest() throws InterruptedException {
		 loginPage = homepage.navigateToLoginPage();
		String actLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
//
	@Test(priority = 2)
	
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotpasswordLinkExist());
	}
	@Test (priority = 3)
	public void homepageURLTest() {
		String actualurl=loginPage.getLoginPageURL();
		Assert.assertEquals(actualurl, prop.getProperty("loginurl"));
	}
	

	@Test(priority = 4)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}



}
