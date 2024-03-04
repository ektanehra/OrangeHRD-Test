package com.orange.hrd.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.orange.hrd.pages.BasePage;
import com.orange.hrd.pages.EmployeePage;
import com.orange.hrd.pages.LoginPage;
import com.orange.hrd.utils.DriverManager;
import com.orange.hrd.utils.Helper;
import com.orange.hrd.utils.ListenersTestNG;

@Listeners(ListenersTestNG.class)
public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPO;
	public BasePage basePO;
	public EmployeePage empPO;
	public DriverManager dm;
	public WebDriverWait webWait;

	Helper helper = new Helper();
	Logger log = LogManager.getLogger();

	@BeforeMethod
	public void setup() {
		log.info("Setup - Before Test");
		dm = new DriverManager();
		driver = dm.getDriver();
		webWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		webWait.until(ExpectedConditions.titleContains("OrangeHRM"));

		webWait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

		helper.takeScreenshot(dm.getDriver());
	}

	@AfterMethod
	public void cleardown() throws InterruptedException {
		log.info("Teardown - After Test");
		helper.takeScreenshot(dm.getDriver());
		Thread.sleep(5000);
		dm.closeDriver();
	}

	public void tempWait() {
		webWait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("");
			}
		});
	}
}
