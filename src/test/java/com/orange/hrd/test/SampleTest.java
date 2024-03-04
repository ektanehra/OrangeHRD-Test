package com.orange.hrd.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {
	Logger log = LogManager.getLogger();

	@Test(description = "Sample Test")
	public void HelloTest() {

		log.info("Sample Test...Start");

		Assert.assertEquals("Hello World !", "Hello World !");
	}

	@Test(testName = "Sample test to validate Screenshot")
	public void ScreenshotTest() throws InterruptedException {
		log.info("Take Screenshot Test !");

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
			String timestamp = dateFormat.format(new Date());

			Thread.sleep(20000);
			TakesScreenshot t = ((TakesScreenshot) driver);
			File scrImage = t.getScreenshotAs(OutputType.FILE);

			File dstImage = new File("./images/Screenshot_" + timestamp + ".png");
			FileUtils.copyFile(scrImage, dstImage);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
