package com.client.NM_HospitalManage.BaseClassUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.NM_HospitalManage.ObjectRepository.HmsPatientHomePage;
import com.client.NM_HospitalManage.ObjectRepository.HmsPatientLoginPage;
import com.client.NM_HospitalManage.ObjectRepository.MultipleLoginPage;
import com.client.NM_HospitalManage.webdriverutility.WebDriverUtility;

public class PatientBaseClass extends BaseClass {
	public WebDriverUtility wlib = new WebDriverUtility();

	@BeforeMethod
	public void beforeMethodConfig() {
		System.out.println("login to patient portal");
		MultipleLoginPage mlp = new MultipleLoginPage(driver);
		mlp.getPatientLink().click();
		wlib.switchToNewTab(driver, "User-Login");
		String PUSER = futils.getDataFromPropertyFile("pusername");
		String PPWRD = futils.getDataFromPropertyFile("ppassword");

		HmsPatientLoginPage hplp = new HmsPatientLoginPage(driver);
		hplp.getUsernameEdit().sendKeys(PUSER);
		hplp.getPasswordEdit().sendKeys(PPWRD);
		hplp.getLoginEdit().click();

	}

	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from patient portal");
		HmsPatientHomePage hphp = new HmsPatientHomePage(driver);
		hphp.getLogoutDD().click();
		hphp.getLogoutEdit().click();

	}

}
