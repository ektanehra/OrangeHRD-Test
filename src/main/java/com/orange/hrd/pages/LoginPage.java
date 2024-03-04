package com.orange.hrd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//h5")
	WebElement LoginHeader;
	
	@FindBy(name = "username")
	WebElement unbox;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;

	@FindBy(xpath="//div[contains(@class,\"orangehrm-login-error\")]")
	WebElement greybox;
	
	@FindBy(xpath="//label[text()='Username']")
	WebElement usernamelabel;
	
	@FindBy(xpath="//label[text()='Password']")
	WebElement passwordlabel;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotpasswordlink;
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getLoginHeader() {
		return LoginHeader.getText();

	}
	public void setusername(String un) {
		unbox.sendKeys(un);
	}

	public void setpassword(String pw) {
		pwd.sendKeys(pw);
	}

	public void clicklogin()
	{
		loginbutton.click();
	}
	
	public String getUserrnamefieldlabel()
	{
		return usernamelabel.getText();
	}
	
	public String getPasswordfieldlabel()
	{
		return passwordlabel.getText();
	}
	
	public void clickforgotpassword()
	{
		forgotpasswordlink.click();
	}
	
	public void dologin(String un,String pw)
	{
		
		setusername(un);
		setpassword(pw);
		clicklogin();
	}
	
}
