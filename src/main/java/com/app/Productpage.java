package com.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage extends Basepage{
	
	public Productpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class = 'socialsharing_product list-inline no-print']/button[1]")
	private WebElement lnkTweet;
	
	@FindBy(xpath = "//*[@class = 'socialsharing_product list-inline no-print']/button[2]")
	private WebElement lnkShare;
	
	@FindBy(xpath = "//*[@id='homefeatured']/li//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement Pdt;
	
	@FindBy(xpath = "//*[@id='homefeatured']/li[1]//*[text()='More']")
	private WebElement moreBtn;
	
	@FindBy(xpath = "//*[@class ='pb-center-column col-xs-12 col-sm-4']//*[@id='short_description_content']/p")
	public WebElement prdDescription;
	

	public WebElement getTweet()
	{
		return lnkTweet;
	}
	public WebElement getShare()
	{
		return lnkShare;
	}
	
	public WebElement getPdt()
	{
		return Pdt;
	}
	public WebElement getMoreBtn()
	{
		return moreBtn;
	}
	public WebElement getprdDescription()
	{
		return prdDescription;
	}
	}

