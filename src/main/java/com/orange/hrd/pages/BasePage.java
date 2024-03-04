package com.orange.hrd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	@FindBy(xpath = "//*[contains(@href,'viewPimModule')]")
	WebElement PIM;

	@FindBy(xpath="//h6[text()='PIM']")
	WebElement PIMHeader;
	
    public BasePage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this); 
    }
	
	public String gotoPIMmodule()
	{
		PIM.click();
		return PIMHeader.getText();
		
	}
}
