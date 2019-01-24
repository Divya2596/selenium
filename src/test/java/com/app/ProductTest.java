package com.app;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {
	Productpage PP;
	ProductTest()
	{
		PP = new Productpage();
	}
	
	/*@BeforeMethod
	public void beforeMethod() {
		PP.myActions(PP.getPdt());
		PP.myActionsclick(PP.getMoreBtn());
	}*/
	@Test(priority= 1)
	public void VerifySocialbuttons()
	{
		PP.myActions(PP.getPdt());
		PP.myActionsclick(PP.getMoreBtn());
		Assert.assertTrue(PP.verifyText(PP.getTweet(), "Tweet"), "Tweet element is not present");
		Assert.assertTrue(PP.verifyText(PP.getShare(), "Share"), "Share element is not present");
		PP.Winback();
	}
	
	@Test(priority = 2)
	public void verifytDescription()
	{
		PP.myActions(PP.getPdt());
		PP.myActionsclick(PP.getMoreBtn());
		Assert.assertTrue(PP.isElementVisible(PP.getprdDescription()), "Product message is not present");
	}
}