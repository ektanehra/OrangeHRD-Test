package com.orange.hrd.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public void takeScreenshot(WebDriver driver) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		String timestamp = dateFormat.format(new Date());

		
		TakesScreenshot t = ((TakesScreenshot) driver);
		File scrImage = t.getScreenshotAs(OutputType.FILE);

		File dstImage = new File("./images/Screenshot_" + timestamp + ".png");
		try {
			FileUtils.copyFile(scrImage, dstImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
