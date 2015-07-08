import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandleMultipleWindows {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/OTHEFILES/Site4Guide.com/Jobs.html");
		driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div[1]/div/a/img")).click();
		Thread.sleep(10000);
		Set<String> uniqueids=driver.getWindowHandles();
		
		Iterator<String> itr=uniqueids.iterator();
		while(itr.hasNext())
		{
			String handle=itr.next();
			driver.switchTo().window(handle);
			
			System.out.println(handle);
			System.out.println(driver.getTitle());
			
			if(driver.getTitle().equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com"))
			{
				driver.findElement(By.id("emailId")).sendKeys("hello@gmail.com");
				
			}
		}
		

	}

}
