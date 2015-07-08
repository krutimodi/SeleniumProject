package overstock;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginUsingExcelData {

		/**
		 * @param args
		 * @throws IOException 
		 * @throws BiffException 
		 * @throws InterruptedException 
		 */
		public static void main(String[] args) throws BiffException, IOException, InterruptedException {
			// TODO Auto-generated method stub
			
			File file = new File("C:\\driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("http://www.overstock.com/");
			driver.findElement(By.className("userMyAccountLink")).click();
			Thread.sleep(10000);//In milliseconds 

			Workbook excel=Workbook.getWorkbook(new File("C:\\Users\\krutim\\Desktop\\Testing\\Overstock.xls"));
	
			Sheet sh=excel.getSheet("sheet");
			//System.out.println(sh.getCell(0, 1).getContents());
			//System.out.println(sh.getCell(1, 1).getContents());
			driver.findElement(By.id("EmailAddress2")).sendKeys(sh.getCell(0, 1).getContents());
			driver.findElement(By.id("EnterPassword")).sendKeys(sh.getCell(1, 1).getContents());
			driver.findElement(By.id("loginSubmit")).click();
		}
	}

