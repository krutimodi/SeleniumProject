package overstock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsertPriceByName {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		//Read Item name from excel sheet
		Workbook excel=Workbook.getWorkbook(new File(".\\input\\Overstock_Name_Price.xls"));
		Sheet sh=excel.getSheet("Sheet1");
		
		FileOutputStream f = new FileOutputStream(".\\output\\output.xls",true);
		WritableWorkbook book = Workbook.createWorkbook(f); 
	    WritableSheet sheet = book.createSheet("output", 0);
		
	    Label label0 = new Label(0, 0, "Item");
	    Label label1 = new Label(1, 0, "Price");
	    sheet.addCell(label0); 
	    sheet.addCell(label1); 
	    
	    int column0 = 0;
	    int column1 = 1;
		for(int i=1;i<sh.getRows();i++){
			
			driver.get("http://www.overstock.com/");
			if(i == 1){
				new WebDriverWait(driver, 10).
				until(ExpectedConditions.elementToBeClickable(By.id("cboxClose"))).click();
			}
			
			driver.findElement(By.id("search-input")).sendKeys(sh.getCell(0, i).getContents());
			driver.findElement(By.className("btn-strongnav")).click();
			
			//Wait till page loads
			/*new WebDriverWait(driver, 10).
			until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='result-products']/li[1]/div/a[1]/span")));*/
			
			//get the Item name from screen and send it to excel sheet
			WebElement itemName = driver.findElement(By.xpath("//*[@id='result-products']/li[1]/div/a[1]/span"));   
			List <WebElement>listItemName = new ArrayList<WebElement>();
			listItemName.add(itemName);
			String listnames = listItemName.get(0).getText();
			System.out.println("names List"+listnames);
	        Label nameLabel = new Label(column0,i,listnames);    
	        sheet.addCell(nameLabel);
	        
			//get the Item price from screen and send it to excel sheet
			WebElement itemPrice = driver.findElement(By.xpath("//*[@id='result-products']/li/div/span[1]/strong"));
			List <WebElement>listItemPrice = new ArrayList<WebElement>();
			listItemPrice.add(itemPrice);
			String listprices = listItemPrice.get(0).getText();
			System.out.println("price List"+listprices);
	        Label priceLabel = new Label(column1,i,listprices); 
	        sheet.addCell(priceLabel);
	        
			driver.findElement(By.xpath("//*[@id='result-products']/li/div/a[1]/span")).click();
			
			/*//select color or size for the selected item
			Select dropdown = new Select(driver.findElement(By.className("options-dropdown")));
			dropdown.selectByIndex(1);
						
			Thread.sleep(10000);
			driver.findElement(By.id("addCartMain_addCartButton")).click();
			driver.findElement(By.className("os-btn")).click();*/
			
		}
		
	    book.write();
	    book.close(); 
	
	    driver.close();//will close only the specific tab
  	}
}
