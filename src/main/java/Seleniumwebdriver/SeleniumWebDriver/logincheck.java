package Seleniumwebdriver.SeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Seleniumwebdriver.SeleniumWebDriver.Utilityclass;
import junit.framework.Assert;
public class logincheck {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() 
  {
	 driver=Utilityclass.openBrowser("chrome");
	 driver.get("http://demoaut.com/");
	
  }
  @Test
  public void checkpage() 
  {
	   driver.findElement(By.name("userName")).sendKeys("tutorial");
	   driver.findElement(By.name("password")).sendKeys("tutorial");
	   driver.findElement(By.xpath("//input[@name='login']")).click();   
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   WebDriverWait wait=new WebDriverWait(driver,100);
	   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("tripType")));
		Assert.assertEquals("Find a Flight: Mercury Tours:",driver.getTitle());
	    System.out.println("logged in!!");
		 
	  }
  @Test
  public void ticketbooking()
  {
	  Select sel=new Select(driver.findElement(By.name("passCount")));
	  sel.selectByIndex(2);
	  sel=new Select(driver.findElement(By.name("fromPort")));
	  sel.selectByValue("London");
	  sel=new Select(driver.findElement(By.name("toPort")));
	  sel.selectByValue("Paris");
	  driver.findElement(By.xpath("//input[@value='First' and @type='radio']")).click();  
	  driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	  
  }
  @AfterTest
  public void afterTest() 
  {
		 
		 driver.close();
	  }
}
