package WebDriver_6;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TakeScreenShot {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		driver.findElement(By.id("Email")).sendKeys("madhureddy97");
		driver.findElement(By.id("Passwd")).sendKeys("defdg");
		driver.findElement(By.id("signIn")).click();
		
		File screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\krutim\\Documents\\gmailscreenshot.jpg"));

	}

}
