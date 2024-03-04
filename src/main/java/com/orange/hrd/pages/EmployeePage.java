package com.orange.hrd.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

	Logger log = LogManager.getLogger();
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployee;

	@FindBy(xpath = "//a[text()='Employee list']")
	WebElement employeeList;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement fNameTxtBox;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lNameTxtBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

//    @FindBy(xpath = "//h6[text()='f l']")
//	WebElement empNameText;

	@FindBy(xpath="//a[text()='Employee List']")
	WebElement empList;

	@FindBy(xpath=" //input[@placeholder='Type for hints...']")
	WebElement eNameTxtbox;

	@FindBy(xpath="//button[@type='submit']")
	WebElement searchbutton;

	
	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void setfirstname(String fname) {
		fNameTxtBox.sendKeys(fname);
	}

	public void setlastname(String lname) {
		lNameTxtBox.sendKeys(lname);
	}

	public void clicksave() {
		savebutton.click();
	}

	public void gotoAddEmployee() {
		addEmployee.click();

	}

	public void addemployee(String fname, String lname) {
		setfirstname(fname);
		setlastname(lname);
		clicksave();
	}

	public String getEmpName(WebDriver driver, String fname, String lname) {
		String empNameXpath = "//h6[text()='" + fname + " " + lname + "']";
		return driver.findElement(By.xpath(empNameXpath)).getText();
	}


	public String searchEmp(WebDriver driver,String fname ,String lname)
	{
		empList.click();
		eNameTxtbox.sendKeys(fname + " "+ lname);
		
		searchbutton.click();
		String record = "//*[text()='" + fname + " " + lname + "']";
		return driver.findElement(By.xpath(record)).getText();
	}

	public static String timestamp() 
	{
		
	
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

	}
	
//	public void getScreenshot(WebDriver driver)  {
//		try {
//			TakesScreenshot t = (TakesScreenshot) driver;// type casting
//			File scrFile = t.getScreenshotAs(OutputType.FILE);
//			File dstFile = new File("./screenshots/emprecord" + timestamp() + ".png");// copy and paste file
//			FileUtils.copyFile(scrFile, dstFile);
//		}
//		catch(IOException exe){
//			log.error("error while taking screenshort");
//		}
		
	public void getScreenshot(WebDriver driver)
	{
	
		String resourceName = "match_record.txt";

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();

		System.out.println(absolutePath);

		assertTrue(absolutePath.endsWith("/match_record.txt"));

		
	}
	
}

