package com.adiltutorials.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adiltutorials.po.FacebookMainPage;

public class FacebookLoginTest {
	
	WebDriver driver = null;
	FacebookMainPage fbmp;
	
	 @BeforeClass(alwaysRun=true)
	 @Parameters("browser")
	  public void setDriver(String br) {
		 
		 if(br.equalsIgnoreCase("firefox")){
			 this.driver = new FirefoxDriver();
			 fbmp = PageFactory.initElements(driver, FacebookMainPage.class);
			 
		 }
		 else if(br.equalsIgnoreCase("chrome")){
			 
			 System.setProperty("webdriver.chrome.driver", "/WebdriverTests/lib/chromedriver");
			 this.driver = new ChromeDriver();
		 }
		 
		 
	}

	
	@AfterClass(alwaysRun=true)
	  public void tearDown() {driver.close();}

	
	@SuppressWarnings("static-access")
	@Test(groups={"p1"})
	public void loadPage(){
		driver.get(fbmp.PAGE_URL);
		AssertJUnit.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");
	}
  @Test(groups={"p2", "fillingFields"}, dependsOnMethods = "loadPage")
  public void logingtest() {
	  System.out.println("testing the second test");
	  fbmp.setText_emailLogin("anthony.thoms@gmail.com");
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
