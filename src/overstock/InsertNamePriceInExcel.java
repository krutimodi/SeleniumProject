package overstock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class InsertNamePriceInExcel {


	public static void main(String[] args) throws InterruptedException, BiffException, IOException, RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.overstock.com/");
		new WebDriverWait(driver, 10).
		until(ExpectedConditions.elementToBeClickable(By.id("cboxClose"))).click();
		driver.findElement(By.id("cboxClose")).click();
		
		//Read Item name from excel sheet
		Workbook excel=Workbook.getWorkbook(new File(".\\input\\Overstock_Name_Price.xls"));
		Sheet sh=excel.getSheet("Sheet1");
		
		//Pass item name in search field
		driver.findElement(By.id("search-input")).sendKeys(sh.getCell(0, 1).getContents());
		driver.findElement(By.className("btn-strongnav")).click();
		
		//Wait till page loads
		Thread.sleep(10000);
		
		//get the Item name and amount from screen and send it to excel sheet
		String itemName = driver.findElement(By.xpath("//*[@id='top-block-wrap']/div[1]/div[1]/h1")).getText();   
		String itemPrice = driver.findElement(By.xpath("//*[@id='result-products']/li/div/span[1]/strong")).getText();   
		System.out.println(itemName);
		System.out.println(itemPrice);
		driver.findElement(By.xpath("//*[@id='result-products']/li/div/a[1]/span")).click();
		
		
		Select dropdown = new Select(driver.findElement(By.className("options-dropdown")));
		dropdown.selectByIndex(1);
		/*Select quantity = new Select(driver.findElement(By.id("addqty7845843")));
		quantity.selectByIndex(1);*/
		
		Thread.sleep(10000);
		driver.findElement(By.id("addCartMain_addCartButton")).click();
		driver.findElement(By.className("os-btn")).click();
		
		FileOutputStream f = new FileOutputStream(".\\output\\output.xls",true);
		WritableWorkbook book = Workbook.createWorkbook(f); 
	    WritableSheet sheet = book.createSheet("output", 0);
	    Label label0 = new Label(0, 0, "Item");
	    Label label1 = new Label(1, 0, "Price");
	    Label label01 = new Label(0, 1, itemName);
	    Label label11 = new Label(1, 1, itemPrice);
	  
	    sheet.addCell(label0); 
	    sheet.addCell(label1); 
	    sheet.addCell(label01); 
	    sheet.addCell(label11); 
	    
	    book.write();
	    book.close(); 
	    
	    driver.close();//will close only the specific tab
  	}
}