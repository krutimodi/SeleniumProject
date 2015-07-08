package WebDriver_6;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class testNgTest {
		
		public WebDriver driver;
		
		@BeforeClass
		public void setUp()
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.gmail.com/");
		}
		
		@Test(priority=0)
		public void enterEmail()
		{
			driver.findElement(By.id("Email")).sendKeys("msrqatech");
		}
		
		@Test(priority=1)
		public void enterPassword()
		{
			driver.findElement(By.id("Passwd1")).sendKeys("india$$1234");
		}
		
		@Test(priority=2,dependsOnMethods="enterPassword")
		public void clickOnSingnIn()
		{
			driver.findElement(By.id("signIn")).click();
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}

	}

