package com.client.NM_HospitalManage.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoginPage {
	WebDriver driver;
	public HomeLoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Logins")
	private WebElement loginEdit;
	@FindBy(linkText = "Home")
	private WebElement homeEdit;
	public WebElement getLoginEdit() {
		return loginEdit;
	}
	public WebElement getHomeEdit() {
		return homeEdit;
	}
	

}
