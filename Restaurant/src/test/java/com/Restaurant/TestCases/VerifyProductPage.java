package com.Restaurant.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Restaurant.Baseclass.BaseClass;
import Com.Restaurant.PageObject.ProductPage;
import Com.Restaurant.Utilities.Log;

public class VerifyProductPage extends BaseClass {
	@Test(groups= {"SMK"})
	public void VerifyProduct()
	{	
	Log.startTestCase("VerifyProductPage");
	ProductPage pp=new ProductPage(driver);
    pp.clickOnProductPage();
	Assert.assertTrue(pp.IsDisplayedProductType(),"product page is not loaded");
    Log.endTestCase("VerifyProductPage");
	}
	
	@Test(groups= {"SMK"},dependsOnMethods={"VerifyProduct"})
	public void VerifySelectEachElements()
	{	
	Log.startTestCase("VerifyProduct");
	ProductPage pp=new ProductPage(driver);
    pp.SelectEachElements();
	Assert.assertEquals(pp.IsDisplayedShowElement(),"100");
    Log.endTestCase("VerifyProduct");
	}

}
