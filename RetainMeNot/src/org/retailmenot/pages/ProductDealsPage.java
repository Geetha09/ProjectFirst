package org.retailmenot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDealsPage {
	WebDriver driver;
	
	public ProductDealsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void jumpToDealType(String dealType) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[contains(text(),'"+dealType+"')])[2]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'"+dealType+"')]"));
		//System.out.println("hello..in dealpage");
		//Thread.sleep(3000);
		
	}
	public int getDealsCount(String dealType)
	{
		//System.out.println("hello..in countmethod");
		List<WebElement> dealList= driver.findElements(By.cssSelector("#"+dealType+">div>div"));
		int size = dealList.size();
		return size;
		
	}

}
