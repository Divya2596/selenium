package com.app;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DressTest {
     Dresspage dp;
     Homepage homepage;
     
     public DressTest()
     {
    	 dp = new Dresspage();
    	 homepage = new Homepage();
     }
     
     @BeforeMethod
     public void beforeMethod() {
    	 homepage.clickDresses();
     }
     
     @Test(priority=1)
     public void VerifySize()
     {
    	 homepage.clickDresses();
    	 Assert.assertTrue(dp.elementFound(dp.SizeS));
    	 Assert.assertTrue(dp.elementFound(dp.SizeM));
    	 Assert.assertTrue(dp.elementFound(dp.SizeL));
     }
     
     @Test(priority=2)
     public void verifyProductCount() {
    	 Assert.assertEquals(dp.getProductCountFromHeaderText(), dp.getProductCount());
     }
     
     @Test(priority=3)
     public void VerifyAddtoCart()
     {
    	 dp.myActions(dp.getfirstdress());
    	 dp.myActionsclick(dp.getaddtocart());
    	 Assert.assertTrue(homepage.elementFound(dp.getprdcticon()));
    	 dp.clickcloseBtn();
    	 dp.Winback();
     }
     
     @Test(priority=4)
     public void verifyPriceAscendingOrder() {
    	 dp.selectSortOption("price:asc");
    	 List<Double> prices = dp.getProductPrices();
    	 for(int index =  0; index<prices.size()-1; index++) {
    		 System.out.println("Price"+prices.get(index));
    		 Assert.assertTrue(prices.get(index)<prices.get(index+1),
    				 "Failed:price not in ascending order at index"+index);
    	 }
     }
     @Test(priority=5)
     public void verifyProductNameInAscendingOrder() {
    	 dp.selectSortOption("name:asc");
    	 List<String> names = dp.getProductNames();
    	 for(int i=0;i<names.size()-1;i++) {
    		 System.out.println(names.get(i).compareTo(names.get(i+1)));
    		 Assert.assertTrue(names.get(i).compareTo(names.get(i+1))<=0,
    				 "Not in Ascending Order and the product name is"+names.get(i));
    	 }
    	 }
     }
