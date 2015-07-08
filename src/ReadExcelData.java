import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcelData {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws IOException, BiffException {
		// TODO Auto-generated method stub
		Workbook excel=Workbook.getWorkbook(new File("C:\\Users\\krutim\\Documents\\TestData.xls"));

	Sheet sh=excel.getSheet("Months");
	//System.out.println(sh.getCell(1, 2).getContents());
	
		for(int i=0;i<sh.getRows();i++)
		{
			System.out.println(sh.getCell(1, i).getContents());
		}
	}
}
