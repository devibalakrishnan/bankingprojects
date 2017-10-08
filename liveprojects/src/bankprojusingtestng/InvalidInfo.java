package bankprojusingtestng;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class InvalidInfo {

	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
static	String username;
static	String password;
static	String url;

	public void readFile(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			url=	prop.getProperty("url");
			username=	prop.getProperty("username");
			password=	prop.getProperty("password");

		} catch (IOException ex) {
			ex.printStackTrace();
		} 
	}

	@BeforeSuite
	public void openingBrowserAndHittingURL(){
		InvalidInfo info=new InvalidInfo();
		info.readFile();
		System.setProperty("webdriver.chrome.driver", "D:/DEVIBALA/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void invalidUsernamePassword()
	{

		driver.findElement(By.name("uid")).sendKeys("mngr985181.....");
		driver.findElement(By.name("password")).sendKeys("jagUjAG....."); 
		driver.findElement(By.name("btnLogin")).click();


		Alert  alert=driver.switchTo().alert();
		String invalid=  alert.getText();
		alert.accept();

		if(invalid.contains("not valid")){
			System.out.println("wrong username and password");
		}
		else{
			System.out.println("login succesful");
		}}


	@Test
	public void invalidUsername()
	{
		driver.findElement(By.name("uid")).sendKeys("mngr985181.....");
		driver.findElement(By.name("password")).sendKeys("jagUjAg"); 
		driver.findElement(By.name("btnLogin")).click();


		Alert  alert1=driver.switchTo().alert();
		String invalid1=  alert1.getText();
		alert1.accept();


		if(invalid1.contains("User or Password is not valid")){
			System.out.println("wrong username ");
		}
		else{
			System.out.println("login succesful");
		}
	}


	@Test
	public void invalidPassword()
	{
		driver.findElement(By.name("uid")).sendKeys("mngr985181");
		driver.findElement(By.name("password")).sendKeys("jagUjAg...."); 
		driver.findElement(By.name("btnLogin")).click();

		Alert  alert2=driver.switchTo().alert();
		String invalid2=  alert2.getText();
		alert2.accept();


		if(invalid2.contains("User or Password is not valid")){
			System.out.println("wrong password ");
		}
		else{
			System.out.println("login succesful");
		}
	}


	

	@AfterSuite
	public void closingBrowser()
	{
		driver.close();
	}
}



















