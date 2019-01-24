package com.app;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	public static WebDriver driver;
	public String browser = "chrome";

	public Basepage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ADMIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementInVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public String getTitlte() {
		return driver.getTitle();
	}	
	
	public void quitDriver() {
		driver.quit();
	}
	public void Winback()
	{
		driver.navigate().back();
	}
public Boolean verifyTitle(String string)
{
	try {
			String title= driver.getTitle();
			if(title.contains(string))
				return true;
		}
		catch(Exception e)
{
			return false;
}
	return null;
	}
public String getTextvalue(WebElement element) {
	try {
		return element.getText();
	}
	catch(Exception e)
	{
		return null;
	}
	}
public Boolean verifyText(WebElement element, String s)
{
	try
	{
		String a = element.getText();
		if(a.contains(s))
			return true;
	}
	catch(Exception e)
	{
		return false;
	}
	return null;
}
public Boolean verifyText(WebElement element, int i)
{
	try
	{
		String a = element.getText();
		int j = Integer.parseInt(a);
		if(j==i)
			return true;
		else
			return false;
	}
	catch(Exception e)
	{
		return false;
	}
}
public void mywait(int time)
{
	WebDriverWait wait= new WebDriverWait(driver, time);
}
public WebElement myActions(WebElement element)
{
	Actions ac = new Actions(driver);
	ac.moveToElement(element).build().perform();
	return element;
	}
public WebElement myActionsclick(WebElement element)
{
	Actions ac = new Actions(driver);
	ac.moveToElement(element).click().build().perform();
	return element;
}
}