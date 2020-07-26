package com.dyt.CICD_QATest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {
	
	@Test
	public void TC01_VerifyTitle() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/servers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://13.232.224.134:8080/CICD_DevTest/");
		
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "DevelopYou");
		driver.quit();
		
	}
	
	@Test
	public void TC02_VerifyLoginPage() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/servers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://13.232.224.134:8080/CICD_DevTest/");
		
		driver.findElement(By.name("txtUsername")).sendKeys("user02");
		driver.findElement(By.name("txtPassword")).sendKeys("TM1234");
		driver.findElement(By.name("btnLogin")).click();
		
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "DevelopYou Home");
		
		driver.quit();
	}

}
