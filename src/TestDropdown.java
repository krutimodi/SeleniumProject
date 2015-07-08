import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestDropdown {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		
		Workbook excel=Workbook.getWorkbook(new File("C:\\Users\\krutim\\Documents\\TestData.xls"));
		Sheet sh=excel.getSheet("Months");
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement months=driver.findElement(By.id("month"));
		List<WebElement>month=months.findElements(By.tagName("option"));
		
	 
		for(int i=0;i<month.size();i++){
		 String actual_month = month.get(i).getText();
		 for(int j=0;j<sh.getRows();j++){
			 String expected_month = sh.getCell(1,i).getContents();
		 
			 if(actual_month.equalsIgnoreCase(expected_month)){
				 System.out.println("String does not match for month "+actual_month);
			 }
		 }
	 }

	}

}
