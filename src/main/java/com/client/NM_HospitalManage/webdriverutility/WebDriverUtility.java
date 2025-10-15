package com.client.NM_HospitalManage.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void selectDropDownVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectDropDownByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectDropDownBy(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void moveToAnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void scrollToAnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element);
	}

	public void switchToNewTab(WebDriver driver, String partialTitle) {
		String currentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String handle : allwindows) {
			driver.switchTo().window(handle);
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				return;
			}
			driver.switchTo().window(currentWindow);
			
		}
	}

}
