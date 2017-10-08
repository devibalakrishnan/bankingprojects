package bankproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginHome {
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;

	static	String url;
	static	String username;
	static	String password;
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
System.out.println(username);
System.out.println(password);
			
			
			

		} catch (IOException ex) {
			ex.printStackTrace();
		} 
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		LoginHome home=new LoginHome();
		home.readFile();
		System.setProperty("webdriver.chrome.driver", "D:/DEVIBALA/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		

		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password); 
		driver.findElement(By.name("btnLogin")).click();
		
		
		String title=driver.getTitle();
		System.out.println(title);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("D:\\screenshot.jpg"));
		
		if(title.contains("Guru99 Bank Manager HomePage")){
			System.out.println("passed");
		}else{
			System.out.println("failed");
		}

	}

}
