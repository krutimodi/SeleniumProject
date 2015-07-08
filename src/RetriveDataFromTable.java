import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RetriveDataFromTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://content.icicidirect.com/newsiteContent/Home/Pricing.asp");
		WebElement table=driver.findElement(By.id("Table4"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement>rows=tbody.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				System.out.println(cols.get(j).getText());
			}
		}

	}

}
