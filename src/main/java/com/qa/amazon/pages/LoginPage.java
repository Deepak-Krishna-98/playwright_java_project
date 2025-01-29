package com.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	//String locators
	private String emailId= "//input[@id=\'input-email\']";
	private String password= "//input[@id=\'input-password\']";
	private String loginBtn= "//input[@value=\'Login\']";
	private String ForgotpasswordLink="//div[@class=\'form-group\']//a[normalize-space()=\'Forgotten Password\']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	//page constructor
	
		public LoginPage(Page page) {
			this.page=page;
		}

	//page actions
		public String getLoginPageTitle() {
			String title= page.title();
			System.out.println("page title is: " +title);
			return title;
				
		}

		public String getLoginPageURL() {
			String url= page.url();
			System.out.println("page title is: " +url);
			return url;
				
		}
		
		public boolean isForgotpasswordLinkExist() {
			return page.isVisible(ForgotpasswordLink);
		}
		
		public boolean doLogin(String appUserName, String appPassword) {
			System.out.println("App creds: " + appUserName + ":" + appPassword);
			page.fill(emailId, appUserName);
			page.fill(password, appPassword);
			page.click(loginBtn);
			page.locator(logoutLink).waitFor();
			if(page.locator(logoutLink).isVisible()) {
				System.out.println("user is logged in successfully....");
				return true;
			}else {
				System.out.println("user is not logged in successfully....");
				return false;
			}
		}
		
		

}
