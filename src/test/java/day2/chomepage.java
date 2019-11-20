package day2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Seleniumwebdriver.SeleniumWebDriver.Utilityclass;
import junit.framework.Assert;

public class chomepage {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() 
  {
	 driver=Utilityclass.openBrowser("chrome");
	 driver.get("http://www.google.com");
	
  }
  @Test
  public void checkpage() 
  {
		 Assert.assertEquals("Google",driver.getTitle());
		 System.out.println("google page!!");
		 
	  }
  @AfterTest
  public void afterTest() 
  {
		 
		 driver.close();
	  }
}
