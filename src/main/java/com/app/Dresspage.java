package com.app;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Dresspage extends Basepage {
public Dresspage()
{
	PageFactory.initElements(driver, this);
}
   
     @FindBy(xpath = "//*[@id = 'ul_layered_id_attribute_group_1']/li[1]//a/span")
     public WebElement SizeS;

     @FindBy(xpath = "//*[@id = 'ul_layered_id_attribute_group_1']/li[2]//a/span")
     public WebElement SizeM;

     @FindBy(xpath = "//*[@id = 'ul_layered_id_attribute_group_1']/li[3]//a/span")
     public WebElement SizeL;
     
     @FindBy(xpath = "//*[@class = 'heading-counter']")
     public WebElement ProductHeader;

     @FindBys(@FindBy(xpath="//ul[@class='product_list grid row']/li"))
     private List <WebElement> lstProducts; 
    
    @FindBy(xpath = "//*[@class='product_list grid row']/li[1]//a[1]//img[1]")
    public WebElement firstdress;
    
    @FindBy(xpath = "//*[@class='product_list grid row']/li[1]//*[text()='Add to cart']")
    public WebElement addtocart;
    
    @FindBy(xpath = "//*[@title='Close window']")
    public WebElement closeBtn;
    
    @FindBy(xpath = "//*[@id='layer_cart']//div[1]/h2")
    public WebElement pdtmsg;
    
    @FindBy(xpath = "//*[@id='selectProductSort']")
    public WebElement dropdownsort;
    
    @FindBys(@FindBy(xpath = "//*[@class='right-block']//span[@class='price product-price']"))
    public List<WebElement> lstProductPrices;
    
    @FindBy(xpath = "//*[@id='layered_ajax_loader']/p/img")
    public WebElement iconload;
    
    @FindBys(@FindBy(xpath = "//*[@class='right-block']//a[@class='product-name']"))
    public List<WebElement> lstProductNames;
    
    public WebElement getSizeS()
    {
    	return SizeS;
    }
    
    public WebElement getSizeM()
    {
    	return SizeM;
    }
    
    public WebElement getDrsproducthover()
    {
    	return SizeL;
    }
    public int getProductCountFromHeaderText() {
    	return Integer.parseInt(ProductHeader.getText().split(" ")[2]);
    }
    
    public int getProductCount() {
    	return lstProducts.size();
    }
    
    public WebElement getfirstdress() {
    	return firstdress;
    }
    
    public WebElement getaddtocart() {
    	return addtocart;
    } 
  
    
    public WebElement getcloseBtn() {
    	return closeBtn;
    } 
    public void clickcloseBtn() {
    	closeBtn.click();
    }
    
    public WebElement getprdcticon() {
    	isElementVisible(pdtmsg);
    	return pdtmsg;
    } 
    
    public String getpdtmsg() {
    	return pdtmsg.getText();
    } 
    public String selectSortOption(String input) {
    	return selectFromDropDown(dropdownsort,input);
    }
    public List<Double> getProductPrices(){
    	List<Double> lst=new ArrayList<Double>();
    	isElementVisible(iconload);
    	isElementInVisible(iconload);
        	for(WebElement e : lstProductPrices) {
    		String txt=e.getText();
    		txt=txt.replace("$", "").trim();
    		Double b=Double.parseDouble(txt);
    		lst.add(b);
    		}
    	return lst;
    }
    public List<String> getProductNames(){
    	ArrayList<String>ProductNames=new ArrayList<String>();
    	isElementVisible(iconload);
    	isElementInVisible(iconload);
    	for(WebElement e:lstProductNames) {
    		String txt=e.getText();
    		ProductNames.add(txt.trim());
    	}
    	return ProductNames;
    	}
    }