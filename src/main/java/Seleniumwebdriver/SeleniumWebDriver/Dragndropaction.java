package Seleniumwebdriver.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Dragndropaction {
	 WebDriver driver;
	 @BeforeTest
	  public void beforeTest()
	  {
		 driver=Utilityclass.openBrowser("chrome");
		 driver.get("http://jqueryui.com/droppable/");
	  }
	 @Test
	  public void dragdropDemo()
	  {
		  WebDriverWait wait = new WebDriverWait(driver, 5);
		  WebElement ifrm= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/iframe"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ifrm)); 
		  WebElement srcLocator=driver.findElement(By.xpath("/html/body/div[1]"));
		  WebElement destLocator= driver.findElement(By.xpath("/html/body/div[2]"));
		  dD(srcLocator,destLocator);
	  }
	  public void dD(WebElement srcLocator, WebElement destLocator) 
	  {
		Actions act = new Actions(driver); 
		act.dragAndDrop(srcLocator, destLocator).build().perform();
		String actText= destLocator.getText();
		System.out.println(actText);
		Assert.assertEquals(destLocator.getText(), "Dropped!");
	  }
	  @AfterTest
	  public void afterTest()
	  {
		  driver.close();
	  }
	}

