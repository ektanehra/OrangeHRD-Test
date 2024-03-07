package com.orange.hrd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimsPage  {

	@FindBy(xpath = "//span[text()='Claim']")
	WebElement claim;

	@FindBy(xpath = "//a[text()='Assign Claim']")
	WebElement assignclaim;

	@FindBy(xpath = " //input[@placeholder='Type for hints...']")
	WebElement eNameTxtbox;

	@FindBy(xpath = "(//*[text()='-- Select --'])[1]")
	WebElement selectEvent;

	@FindBy(xpath = "(//*[contains(text(),'Select')])[2]")
	WebElement selectCurrency;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement create;

	public ClaimsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

		public void gotoClaim()
		{
			claim.click();
		}
		
		public void gotoAssignClaim()
		{
			assignclaim.click();
			
		}
	public void setname(String ename, WebDriver driver) {
		eNameTxtbox.sendKeys(ename);
		driver.findElement(By.xpath("//*[contains(text(),'"+ ename +"')]")).click();

	}

	public void toSelectEvent(WebDriver driver) {
		selectEvent.click();
		driver.findElement(By.xpath("//*[contains(text(),'Accommodation')]")).click();

	}

	public void toSelectCurrency(WebDriver driver) {
		
		//selectCurrency.click();
		driver.findElement(By.xpath("(//*[contains(text(),'Select')])[2]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Pound Sterling')]")).click();
	}

	public void toSubmitClaim() {
		create.click();
	}

}
