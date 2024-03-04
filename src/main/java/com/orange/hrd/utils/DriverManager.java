package com.orange.hrd.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	Logger log = LogManager.getLogger();
	
	private WebDriver driver;

	public WebDriver getDriver() {
		log.info("get Driver");
		
		if (driver == null){
			log.info("driver is null");
			driver = createDriver("CHROME");
		}

		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

	private WebDriver createDriver(String browserName) {
		log.info("browser name is :" + browserName);
		switch (browserName) {
		case ("CHROME"): {
			driver = new ChromeDriver();
			break;
		}
		case ("FIREFOX"): {
			driver = new FirefoxDriver();
			break;
		}
		default:
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		return driver;
	}

}
