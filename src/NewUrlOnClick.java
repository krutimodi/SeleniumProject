import java.io.File;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewUrlOnClick {

	//final static Logger logger = Logger.getLogger(NewUrlOnClick.class);
	//private static Log log = LogFactory.getLog(NewUrlOnClick.class);
 
	public static void main(String[] args) throws InterruptedException {
		File file = new File("C:\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		try{
			// logger.debug("start of gmail login");
			
			driver.get("https://www.gmail.com/");
			driver.findElement(By.id("Email")).sendKeys("abc");
			driver.findElement(By.id("next")).click();
			driver.findElement(By.id("Passwd")).sendKeys("xyz");
			driver.findElement(By.id("signIn")).click();
			new WebDriverWait(driver, 10).
			until(ExpectedConditions.elementToBeClickable(By.className("gb_d"))).click();
	
			//Perform the click operation that opens new window
			driver.findElement(By.className("gb_8b")).click();
			
			//Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			driver.findElement(By.id("Email")).sendKeys("krutimodi1988");
			driver.findElement(By.id("next")).click();
			driver.findElement(By.name("Passwd")).sendKeys("abc");
			driver.findElement(By.name("signIn")).click();
			
			// logger.debug("end of gmail login");
		
		//driver.findElement(By.className("gb_d")).click();
		//driver.findElement(By.id("gb_71")).click();
		//driver.quit();//will close complete window with all tabs
		//driver.close();//will close only the specific tab
		}catch (ElementNotVisibleException ne) {
			// logger.error("There is no such element"+ne.getMessage());
        }finally{
        	driver.close();
        }
	}

}
