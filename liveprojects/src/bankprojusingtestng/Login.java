package bankprojusingtestng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
@SuppressWarnings("unused")
public class Login {
	WebDriver driver;

	@BeforeSuite
	public void openingbrowser(){
		System.setProperty("webdriver.chrome.driver", "D:/DEVIBALA/chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void hittingurl()
	{
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mngr98518");
		driver.findElement(By.name("password")).sendKeys("jagUjAg"); 
		driver.findElement(By.name("btnLogin")).click();
		String man=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		if(man.contains("Manger Id")){
			System.out.println("login successfull");
		}
		else{
			System.out.println("login failed");
		}
	}

	@AfterSuite
	public void closingbrowser()
	{
		driver.close();
	}










}
