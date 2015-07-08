package WebDriver_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions obj=new Actions(driver);
		obj.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
		.build().perform();

	}

}
