package WebDriver_6;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UploadAFile {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://convertonlinefree.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("MainContent_fu")).click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C:\\Users\\krutim\\Desktop\\Kruti data\\Selenium Script Videos\\WebDriver_DAY_6\\convert_upload.exe");
	}

}
