package org.retailmenot.tests;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.retailmenot.pages.HomePage;
import org.retailmenot.pages.ProductDealsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RetailMeNotTests {
	
	WebDriver driver;
	public static Properties prop;
	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	@Parameters({"browserType", "url"})
	@BeforeClass
	public void setUp(String browserType, String url) throws IOException
	{
		FileInputStream fis = new FileInputStream(new File("RM.properties"));
		prop = new Properties();
		prop.load(fis);
		
		
		if(browserType.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","ChromeDriver.exe");
			driver = new ChromeDriver();
		}		
		driver.get(url);
	}
	@Test
	public void validateProductDealsCount() throws InterruptedException
	{
				
		HomePage hPage =new HomePage(driver);
		hPage.browseCoupons("Product Deals");
		ProductDealsPage dealsPage = new ProductDealsPage(driver);
		dealsPage.jumpToDealType("Electronics");
		int actual = dealsPage.getDealsCount("Electronics");
		int expected = 58;
		Assert.assertEquals(actual, expected);
				
	}

}
