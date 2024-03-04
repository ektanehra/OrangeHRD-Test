package com.orange.hrd.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.orange.hrd.pages.BasePage;
import com.orange.hrd.pages.EmployeePage;
import com.orange.hrd.pages.LoginPage;

public class PIMTest extends BaseTest {

	Logger log = LogManager.getLogger();
	Faker faker = new Faker();

	@Test
	public void AddEmpTest()  {
		Reporter.log("Add Employee Test", true);

		/*
		 * Generate employee details
		 */
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();

		// Login
		loginPO = new LoginPage(driver);
		loginPO.dologin("Admin", "admin123");

		// Goto PIM Module
		basePO = new BasePage(driver);
		String pimHeaderText = basePO.gotoPIMmodule();
		Assert.assertEquals(pimHeaderText, "PIM", "Error while navigating to PIM page");

		// GoTo AddEmployee
		empPO = new EmployeePage(driver);
		empPO.gotoAddEmployee();

		// Add employee
		empPO.addemployee(firstName, lastName);

		String empName = empPO.getEmpName(driver, firstName, lastName);
		Assert.assertEquals(empName, firstName + " " + lastName, "Employee not added !");
		
		
	}
	
	@Test
	public void SearchEmployee() {
		
		Reporter.log("Search Employee Test", true);

		/*
		 * Generate employee details
		 */
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();

		// Login
		loginPO = new LoginPage(driver);
		loginPO.dologin("Admin", "admin123");

		// Goto PIM Module
		basePO = new BasePage(driver);
		String pimHeaderText = basePO.gotoPIMmodule();
		Assert.assertEquals(pimHeaderText, "PIM", "Error while navigating to PIM page");

		// GoTo AddEmployee
		empPO = new EmployeePage(driver);
		empPO.gotoAddEmployee();

		// Add employee
		empPO.addemployee(firstName, lastName);

		String empName = empPO.getEmpName(driver, firstName, lastName);
		Assert.assertEquals(empName, firstName + " " + lastName, "Employee not added !");
		
		
		
		//Search Employee with first name
		empPO.searchEmp(driver,firstName,lastName);
		empPO.getScreenshot(driver);
		
		Assert.assertEquals(empName,firstName + " "+ lastName,"Employee record not found ");
		
	}
}
