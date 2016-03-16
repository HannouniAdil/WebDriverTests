package com.adiltutorials.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class FacebookLogin {
	
	WebDriver driver = null;

	 @BeforeClass(alwaysRun=true)
	 @Parameters("browser")
	  public void setDriver(String br) {
		 
		 if(br.equalsIgnoreCase("firefox")){
			 this.driver = new FirefoxDriver();
		 }
		 else if(br.equalsIgnoreCase("chrome")){
			 
			 System.setProperty("webdriver.chrome.driver", "/Users/adil/workspace/WebdriverTests/src/main/resources/chromedriver");
			 this.driver = new ChromeDriver();
		 }
		 
		 
	}

	
	@AfterClass(alwaysRun=true)
	  public void tearDown() {driver.close();}

	
	@Test(groups={"p1"})
	public void loadPage(){
		driver.navigate().to("http://www.facebook.com");
		AssertJUnit.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");
		System.out.print(driver.getTitle());
	}
  @Test(groups={"p2", "fillingFields"}, dependsOnMethods = "loadPage")
  public void logingtest() {
	  System.out.println("testing the second test");
	  driver.findElement(By.id("email")).sendKeys("anthony.thoms@gmail.com");
	  System.out.println(driver.getWindowHandle());
	  
  }
  /*@BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

 
  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
	  
  }*/

}
