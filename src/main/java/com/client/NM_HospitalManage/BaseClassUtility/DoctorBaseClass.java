package com.client.NM_HospitalManage.BaseClassUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.NM_HospitalManage.ObjectRepository.HmsDoctorHomePage;
import com.client.NM_HospitalManage.ObjectRepository.HmsDoctorLoginPage;
import com.client.NM_HospitalManage.ObjectRepository.MultipleLoginPage;
import com.client.NM_HospitalManage.webdriverutility.WebDriverUtility;

public class DoctorBaseClass extends BaseClass {
	public WebDriverUtility wlib = new WebDriverUtility();

	@BeforeMethod
	public void beforeMethodConfig() {
		System.out.println("login to doctor portal");

		MultipleLoginPage mlp = new MultipleLoginPage(driver);
		mlp.getDoctorLink().click();
		wlib.switchToNewTab(driver, "Doctor Login");
		String DUSER = futils.getDataFromPropertyFile("dusername");
		String DPWRD = futils.getDataFromPropertyFile("dpassword");

		HmsDoctorLoginPage hdlp = new HmsDoctorLoginPage(driver);
		hdlp.getUserNameEdit().sendKeys(DUSER);
		hdlp.getPasswordEdit().sendKeys(DPWRD);
		hdlp.getLoginEdit().click();

	}

	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from doctor portal");
		HmsDoctorHomePage hdhp = new HmsDoctorHomePage(driver);
		hdhp.getLogoutDD().click();
		hdhp.getLogout().click();

	}

}
