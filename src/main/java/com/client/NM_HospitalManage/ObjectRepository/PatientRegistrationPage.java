package com.client.NM_HospitalManage.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage {
	WebDriver driver;
	public PatientRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='full_name']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@name='address']")
	private WebElement add;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@id='rg-male']")
	private WebElement gender;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement psd;
	
	@FindBy(xpath = "//input[@id='password_again']")
	private WebElement cnfPsd;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement signupBtn;

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPsd() {
		return psd;
	}

	public WebElement getCnfPsd() {
		return cnfPsd;
	}

	public WebElement getSignupBtn() {
		return signupBtn;
	}
}
