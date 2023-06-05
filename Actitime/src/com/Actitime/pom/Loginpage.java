package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
//declaration	
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwdtbx;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement lgnbtn;

//initialization
	public Loginpage(WebDriver driver) //constructor
	{
		PageFactory.initElements(driver, this);
	}

//utilization
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwdtbx() {
		return pwdtbx;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	
}
