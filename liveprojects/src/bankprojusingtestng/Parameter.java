package bankprojusingtestng;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankproject.LoginHome;

public class Parameter {

	@Test
	@Parameters({"username","password"})
	public void login(String user,String pass){
		
		System.setProperty("webdriver.chrome.driver", "D:/DEVIBALA/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		
		driver.findElement(By.name("uid")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass); 
		driver.findElement(By.name("btnLogin")).click();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
