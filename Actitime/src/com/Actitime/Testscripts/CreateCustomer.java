  package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLiabrary.BaseClass;
import com.Actitime.GenericLiabrary.FileLibrary;
import com.Actitime.pom.Homepage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends BaseClass{
	
@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
    {
		Homepage hp= new Homepage(driver);
		hp.getTaskbtn().click();
		TaskPage tp= new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f1= new FileLibrary();
		String customer = f1.readDataFromExcel("Data", 2, 1);
		tp.getCustname().sendKeys(customer);
		String description = f1.readDataFromExcel("Data", 1, 2);
		tp.getCustdesp().sendKeys(description);
		tp.getCreatebtn().click();
		String expectedresult = customer;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualresult, expectedresult);
		sa.assertAll();
	}
}
