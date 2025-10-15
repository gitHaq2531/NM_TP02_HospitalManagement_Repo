package com.client.NM_HospitalManage.BaseClassUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.NM_HospitalManage.ObjectRepository.HmsAdminLoginPage;
import com.client.NM_HospitalManage.ObjectRepository.MultipleLoginPage;

public class AdminBaseClass extends BaseClass {

	
	
	
	@BeforeMethod
	public void beforeMethodConfig() {
		
		MultipleLoginPage mlp = new MultipleLoginPage(driver);
		HmsAdminLoginPage halp = new HmsAdminLoginPage(driver);
		
		System.out.println("login to admin portal");
	
		String USERNAME = System.getProperty("username", futils.getDataFromPropertyFile("username"));
		String PASSWORD = System.getProperty("password", futils.getDataFromPropertyFile("password"));
		
		mlp.getAdminLink().click();
		halp.getUserEdit().sendKeys(USERNAME);
		halp.getPasswordEdit().sendKeys(PASSWORD);
		halp.getLoginEdit().click();
		
		System.out.println("**********");
	}

	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from admin portal");
	}

}
