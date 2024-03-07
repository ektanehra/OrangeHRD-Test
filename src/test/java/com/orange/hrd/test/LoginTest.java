package com.orange.hrd.test;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.orange.hrd.pages.*;

public class LoginTest extends BaseTest {

	Logger log = LogManager.getLogger();
	
	@Test
	public void LoginPageTitleTest() {
		log.info("Login test start");
//		Reporter.log("Login test start", true);

		loginPO = new LoginPage(driver);
		Reporter.log("Login Page Header : " + loginPO.getLoginHeader(), true);
		Assert.assertEquals(loginPO.getLoginHeader(), "Login");

		LoginPage loginPO = new LoginPage(driver);

		
		Reporter.log("Login test end", true);
	}

	@Test
	public void ValidLoginTest() {
		Reporter.log("Valid Login Test start:", true);
		loginPO = new LoginPage(driver);
		loginPO.dologin("Admin", "admin123");
		Reporter.log(driver.getTitle(), true);
		Assert.assertEquals(driver.getTitle(), "OrangeHR", "Page Title Mismatch");
	}

	@Test
	public void VerifyLoginPageTest() {
		SoftAssert softAssert = new SoftAssert();

		Reporter.log("Verify Login Page test start", true);
		loginPO = new LoginPage(driver);
		Reporter.log("Login Page Header : " + loginPO.getLoginHeader(), true);
		Reporter.log("Title of login page:" + driver.getTitle(), true);

		softAssert.assertEquals(loginPO.getUserrnamefieldlabel(), "Username", "Username field text Mismatch");
		softAssert.assertEquals(loginPO.getPasswordfieldlabel(), "Password", "Password field text Mismatch");

		softAssert.assertAll();
	}

}