package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement taskbtn;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportbtn;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement usertab;
	
	@FindBy(id="logoutlink")
	private WebElement logout;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTaskbtn() {
		return taskbtn;
	}

	public WebElement getReportbtn() {
		return reportbtn;
	}

	public WebElement getUsertab() {
		return usertab;
	}

	public WebElement getLogout() {
		return logout;
	}
	
}
