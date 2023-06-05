package com.Actitime.GenericLiabrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is Generic Class which is having generic methods.
 * @author Dipashree Patil
 *
 */
public class FileLibrary 
{
	/**
	 * This method is generic method which is use to read the data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./testdata/commondata.property");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This is generic method which is use to read the data from excel sheet
	 * @param sn
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sn, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./testdata/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sn).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
}
