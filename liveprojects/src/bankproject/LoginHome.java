package bankproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/DEVIBALA/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(" http://www.demo.guru99.com/V4/");
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

}
