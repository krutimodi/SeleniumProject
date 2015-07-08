package overstock;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		File file = new File("C:\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.overstock.com/");
		driver.findElement(By.className("userMyAccountLink")).click();
		Thread.sleep(10000);//In milliseconds 
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("CreatePassword")).sendKeys("xyz@");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("xyz@");
		driver.findElement(By.id("createSubmit")).click();
		
	}

}
