package com.Restaurant.TestCases;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.Utilities.Log;

public class VerifyValidUserLoginTest extends BaseClass {

	@Test(groups = { "SMK" })
	public void VerifyUserLogin() {
		launchApp();
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.IsLogoDisplayed(), "Login page is not loaded");
		lp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(lp.IsLogoutDisplayed(), "Login page is not loaded");
		lp.LogoutFun();
	}

	@Test(dataProvider = "InvalidLoginDatas")
	public void VerifyInvalidUserLogin(String userName, String password) {
		Log.startTestCase("VerifyInvalidUserLogin");
		LoginPage lp = new LoginPage(driver);
		lp.InvalidLogin(userName, password);
		Assert.assertFalse(lp.IsLogoutDisplayed(), "Login to site");
		Log.endTestCase("VerifyInvalidUserLogin");
	}

}
