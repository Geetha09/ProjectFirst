package org.retailmenot.pages;
import org.retailmenot.tests.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void browseCoupons(String coupounType) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No Thanks']")));

		if(e1.isDisplayed())
		{
			driver.findElement(By.cssSelector(".button-close.js-close")).click();
	
		}
		Thread.sleep(3000);
		driver.findElement(By.linkText(RetailMeNotTests.prop.getProperty("retailmenot.homepage.couponslink"))).click();
		driver.findElement(By.linkText(coupounType)).click();
		System.out.println("Testing");
		//Thread.sleep(3000);
		
	}

  }

