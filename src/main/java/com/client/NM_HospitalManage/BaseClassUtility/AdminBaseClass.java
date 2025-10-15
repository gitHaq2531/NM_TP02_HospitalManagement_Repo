package com.client.NM_HospitalManage.BaseClassUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.NM_HospitalManage.ObjectRepository.HmsAdminHomePage;
import com.client.NM_HospitalManage.ObjectRepository.HmsAdminLoginPage;
import com.client.NM_HospitalManage.ObjectRepository.MultipleLoginPage;
import com.client.NM_HospitalManage.webdriverutility.WebDriverUtility;

public class AdminBaseClass extends BaseClass {

	WebDriverUtility wlib = new WebDriverUtility();
	
	@BeforeMethod
	public void beforeMethodConfig() {
		MultipleLoginPage mlp = new MultipleLoginPage(driver);
		mlp.getAdminLink().click();
		wlib.switchToNewTab(driver, "Admin-Login");
		String AUSER = futils.getDataFromPropertyFile("ausername");
		String APWRD = futils.getDataFromPropertyFile("apassword");

		HmsAdminLoginPage halp = new HmsAdminLoginPage(driver);
		halp.getUserEdit().sendKeys(AUSER);
		halp.getPasswordEdit().sendKeys(APWRD);
		halp.getLoginEdit().click();
	}

	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from admin portal");
		HmsAdminHomePage hamp = new HmsAdminHomePage(driver);
		hamp.getLogoutDD().click();
		hamp.getLogoutEdit().click();

	}

}
