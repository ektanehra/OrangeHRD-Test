package com.orange.hrd.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orange.hrd.pages.ClaimsPage;
import com.orange.hrd.pages.LoginPage;

public class ClaimTest extends BaseTest {

	@Test
	public void createClaim() {

		Reporter.log("Create claim Test", true);
		//to login
		
		loginPO = new LoginPage(driver);
		loginPO.dologin("Admin", "admin123");
		
		
		// to enter name
		claimPO = new ClaimsPage(driver);
		
		//go to claim
		claimPO.gotoClaim();
		
		//go to assignclaim
		claimPO.gotoAssignClaim();
		
		claimPO.setname("Odis  Adalwin",driver );

		// to select event

		claimPO.toSelectEvent(driver);

		// to select currency

		claimPO.toSelectCurrency(driver);

		// to click submit button

		claimPO.toSubmitClaim();

	}
}
