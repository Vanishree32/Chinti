package com.pmt.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream ("./src/test/resources/config.properties");//System.getProperty("user.dir")+"\\src\\main\\java\\Config.Properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
    	 

	public static void initilization() throws InterruptedException
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		   WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		   
		}
		else if(browserName.equals("FF"))
		{
			 WebDriverManager.firefoxdriver().setup();
		    driver= new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		WaitTil(6000);	
	}
	
	public static void Wait(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void WaitUnTil(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(900));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void WaitTil(int Wait)
	{
		try {
			Thread.sleep(Wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	 

		
}
