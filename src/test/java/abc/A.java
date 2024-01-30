package abc;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pmt.generic.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	static WebDriver driver;

	@Test(priority = 1)
	public void updateResume() throws InterruptedException
	{
		//System.out.println("Hello");
		//driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
		 WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://www.naukri.com/");
			driver.manage().window().maximize();
			driver.findElement(By.id("login_Layer")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("vanishree9964@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Chinti@123");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='View & Update Profile']")).click();
			Thread.sleep(8000);
		     WebElement element = driver.findElement(By.xpath("//input[@value='Update resume']"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			Thread.sleep(5000);
			String path = System.getProperty("user.dir");
	        Random r=new Random();
	        int n = r.nextInt(3);
	        //System.out.println(n);
	        if(n==1)
	        {
			driver.findElement(By.xpath("//input[@id='attachCV']")).sendKeys(path+"/src/test/resources/Vanishree M B.pdf");
	        }
	        else
	        {
	        	driver.findElement(By.xpath("//input[@id='attachCV']")).sendKeys(path+"/src/test/resources/Vanishree M B (1).pdf");
	        }
	        
			Thread.sleep(5000);
	}
			
	
	}

