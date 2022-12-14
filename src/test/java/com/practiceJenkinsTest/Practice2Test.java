package com.practiceJenkinsTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2Test {

	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	
	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void signInMouseHover() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		
		webDriverDataUtility.moveToElement(driver, actionsClassPage.mouseHoverSignIn());
		webDriverDataUtility.pause(driver);
//		webDriverDataUtility.moveToElementWithoutPerform(driver, actionsClassPage.mouseHoverSignIn());
//		webDriverDataUtility.setActiveKeyboard(driver);
		webDriverDataUtility.clickElement(driver, actionsClassPage.clickText());

		
			
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
	
}
