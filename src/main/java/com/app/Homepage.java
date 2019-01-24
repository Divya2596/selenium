package com.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement Women1;
	
	@FindBy(xpath = "//ul[contains(@class, 'menu-content')]/li[2]/a[@title='Dresses']")
	private WebElement Dresses1;
	
	@FindBy(xpath = "//ul[contains(@class, 'clearfix menu-content')]//li[3]//a[@title='T-shirts']")
	private WebElement Tshirts1;
	
	@FindBy(id="newsletter-input")
	public WebElement txtEmail;
	
	@FindBy(xpath="//*[@name='submitNewsletter']")
	public WebElement btnEmail;
	
	@FindBy(xpath= "//*[@class='alert alert-success']")
	public WebElement MsgEmail;
	
	public WebElement getWomen1() {
		return Women1;
	}
	public void clickWomen() {
		Women1.click();
	}
	public WebElement getDresses1() {
		return Dresses1;
}
	public void clickDresses() {
		Dresses1.click();
	}
	public WebElement getTshirts1() {
		return Tshirts1;
	}
	public void clickTshirts() {
		Tshirts1.click();
	}
	public WebElement getEmail()
	{
		return txtEmail;
	}
	public WebElement getbtnEmail()
	{
		return btnEmail;
	}
	public WebElement getMsgEmail()
	{
		return MsgEmail;
	}}