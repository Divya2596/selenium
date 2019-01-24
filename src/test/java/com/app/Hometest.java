package com.app;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hometest {

	Homepage homepage;
	Basepage bp;
	
	int value = new Random().nextInt(7000);
	String email = "divya" + value + "@gmail.com";
	
	public Hometest() {
		homepage = new Homepage();
		bp = new Basepage();
	}
	@Test
	public void verifyTabs()
	{
		Assert.assertTrue(homepage.elementFound(homepage.getWomen1()));
		
		Assert.assertTrue(homepage.elementFound(homepage.getDresses1()));

		Assert.assertTrue(homepage.elementFound(homepage.getTshirts1()));
	}
	@Test
	public void verifypage()
	{
		homepage.clickWomen();
		Assert.assertTrue(homepage.verifyTitle(("Women - My Store")));
		homepage.Winback();
		
		homepage.clickDresses();
		Assert.assertTrue(homepage.verifyTitle("Dresses - My Store"));
		homepage.Winback();
		
		homepage.clickTshirts();
		Assert.assertTrue(homepage.verifyTitle("T-shirts - My Store"));
		homepage.Winback();
	}
	@Test
	public void Enteremail()
	{
		homepage.txtEmail.sendKeys(email);
		homepage.getbtnEmail().click();
		System.out.println(homepage.getMsgEmail().getText());
		Assert.assertTrue(homepage.verifyText(homepage.getMsgEmail(), "Newsletter"));
		}}