package Seleniumwebdriver.SeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoaction {
	WebDriver driver;
	Actions act;

	@BeforeTest
	public void beforeTest() {
		driver = Utilityclass.openBrowser("chrome");
		driver.get("http://www.demoaut.com");
	}

	@Test(priority = 1)
	public void doAction() {
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Home"))).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Test(priority = 2)
	public void contextClick() {
		WebElement txt;
		txt = driver.findElement(By.name("userName"));
		act = new Actions(driver);
		act.click(txt).keyDown(Keys.SHIFT).sendKeys("tutorial").build().perform();
	}
}

