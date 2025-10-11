package com.client.NM_HospitalManage.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HmsAdminLoginPage {
	WebDriver driver;
	public HmsAdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userEdit;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordEdit;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginEdit;
	public WebElement getUserEdit() {
		return userEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginEdit() {
		return loginEdit;
	}
	

}
