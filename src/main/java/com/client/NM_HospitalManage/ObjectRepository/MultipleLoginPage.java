package com.client.NM_HospitalManage.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleLoginPage {
	WebDriver driver;
	public MultipleLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h6[text()='Patient Login']/following-sibling::a/child::button")
	private WebElement patientLink;
	@FindBy(xpath = "//h6[text()='Doctors login']/following-sibling::a/child::button")
	private WebElement doctorLink;
	@FindBy(xpath = "//h6[text()='Admin Login']/following-sibling::a/child::button")
	private WebElement adminLink;
	
	public WebElement getPatientLink() {
		return patientLink;
	}
	public WebElement getDoctorLink() {
		return doctorLink;
	}
	public WebElement getAdminLink() {
		return adminLink;
	}
	

}
