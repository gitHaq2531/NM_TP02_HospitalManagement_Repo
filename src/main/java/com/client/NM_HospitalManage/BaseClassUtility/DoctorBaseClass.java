package com.client.NM_HospitalManage.BaseClassUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DoctorBaseClass {
	@BeforeMethod
	public void beforeMethodConfig() {
		System.out.println("login to doctor portal");
		
	}
	@AfterMethod
	public void afterMethodConfig() {
		System.out.println("logout from doctor portal");
	}

}
