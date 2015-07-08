package WebDriver_6;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ScrollingDownAndUp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		Thread.sleep(10000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,-1000)");

	}

}
