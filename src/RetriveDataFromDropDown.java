import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RetriveDataFromDropDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement months=driver.findElement(By.id("month"));
		List<WebElement>month=months.findElements(By.tagName("option"));
	 
		for(int i=0;i<month.size();i++){
		 System.out.println(month.get(i).getText());
	 }

	}

}
