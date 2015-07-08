import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class FacebookAccount {

	public static void main(String[] args){
		File file = new File("C:\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://Facebook.com");
		driver.findElement(By.name("firstname")).sendKeys("abc");
		driver.findElement(By.name("lastname")).sendKeys("xyz");
		driver.findElement(By.name("reg_email__")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("xxx009");
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("2");
		
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("2");
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1990");
		
		driver.findElement(By.id("u_0_d")).click();
		driver.findElement(By.id("u_0_i")).click();
		
	}
}
