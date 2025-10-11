package com.client.NM_HospitalManage.BaseClassUtility;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PatientBaseClass extends BaseClass{
	
	@BeforeMethod
	public void beforeMethodConfig() {
		System.out.println("login to patient portal");
		
	}
	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from patient portal");
	}

}
