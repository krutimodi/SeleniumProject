import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
		File file = new File("C:\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		driver.findElement(By.id("Email")).sendKeys("abce32564");
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);//In milliseconds
		driver.findElement(By.id("Passwd")).sendKeys("Abce32564$");
		driver.findElement(By.id("signIn")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10).
		until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span"))).click();
		Thread.sleep(1000);//In milliseconds
		driver.findElement(By.id("gb_71")).click();
		//driver.quit();//will close complete window with all tabs
		driver.close();//will close only the specific tab
	}

}
