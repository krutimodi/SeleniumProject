package WebDriver_6;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;


	public class ClickHoldMove {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://jqueryui.com/draggable/");
			driver.switchTo().frame(0);
			WebElement box=driver.findElement(By.id("draggable"));
			
			Actions obj=new Actions(driver);
			obj.clickAndHold(box).moveByOffset(100, 100).release()
			.build().perform();
			

		}

	}
