package YT;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

public class Excel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream inputStream = new FileInputStream("C:\\Users\\kalya\\Documents\\SwathiTestingYT\\admin.xls");
		/*HSSFWorkbook wb=new HSSFWorkbook(inputStream);*/
		Workbook wb=WorkbookFactory.create(inputStream);
		Sheet sh= wb.getSheet("login");
		//get row size
		int Allrows=sh.getLastRowNum();
		System.out.println();
		//HSSFRow row=sh.getRow(0);

		//get column size
		for(int i=1;i<Allrows;i++)
		{
			String admin=sh.getRow(i).getCell(0).getStringCellValue();
			String username=sh.getRow(i).getCell(1).getStringCellValue();
			String pass=sh.getRow(i).getCell(2).getStringCellValue();
			System.out.println(admin+"   "+username+"   "+pass);
			
		//write result data
		//create cell
		sh.getRow(i).getCell(3).setCellValue("Fail");
		}
			
		wb.close();
		File output=new File("C:\\Users\\kalya\\Documents\\SwathiTestingYT\\admin.xls");
		//Workbook wbWrite = WorkbookFactory.create(output);
		//Sheet sh1=wbWrite.createSheet("result");
		
		
		
		
	}

}
