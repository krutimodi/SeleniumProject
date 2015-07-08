import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandleAlerts {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/");
		driver.findElement(By.className("redbtn")).click();
		Alert obj=driver.switchTo().alert();
		Thread.sleep(10000);
		System.out.println(obj.getText());
		obj.accept();

	}

}
