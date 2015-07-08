import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class HandlingRadioButtonAndDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("u_0_1")).sendKeys("selenium");
		driver.findElement(By.id("u_0_3")).sendKeys("script");
		driver.findElement(By.id("u_0_5")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("u_0_8")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("u_0_a")).sendKeys("selenium_123");
		
		//dropdown code
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("2");
		
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("2");
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1990");
		
		driver.findElement(By.id("u_0_e")).click();
		driver.findElement(By.id("u_0_i")).click();
		
	}

}
