package com.client.NM_HospitalManage.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HmsDoctorHomePage {
	WebDriver driver;
	public HmsDoctorHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement logoutDD;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logout;
	public WebElement getLogoutDD() {
		return logoutDD;
	}
	public WebElement getLogout() {
		return logout;
	}
	

}
