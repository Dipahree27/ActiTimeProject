package com.Actitime.GenericLiabrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.Loginpage;

public class BaseClass
{

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	FileLibrary fl = new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseCennection() {
		Reporter.log("Database is connection",true);
	}
	@BeforeClass
	public void launchBowser() throws IOException {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = fl.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("Browser launched",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		Loginpage lp= new Loginpage(driver);
		String un = fl.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		String pwd = fl.readDataFromPropertyFile("password");
		lp.getPwdtbx().sendKeys(pwd);
		lp.getLgnbtn().click();
		Reporter.log("Logged in Successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out successfully",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser is closed",true);
	}
	@AfterSuite
	public void closeDatabaseConnection() {
		Reporter.log("Databse Disconnected",true);
	}
}


