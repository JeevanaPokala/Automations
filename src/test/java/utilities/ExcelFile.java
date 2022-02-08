package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	static Workbook wb;
	public ExcelFile(String inputStreamExcel) throws Exception
	{
		FileInputStream inputStream = new FileInputStream(inputStreamExcel);
		wb=WorkbookFactory.create(inputStream);
	}

	public  int getrowSize(String sheetName)  
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public  String getCellData(String sheetName,int row,int col)
	{
		String data="";
		if(wb.getSheet(sheetName).getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata = (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return data =String.valueOf(celldata);	
		}
		else
		{
		data=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
		}
	}
	public  void setCellData(String sheetName,int row,int col,String status,String outputStreamExcel) throws Exception
	{
		
		wb.getSheet(sheetName).getRow(row).createCell(col).setCellValue(status);
		if(status.equalsIgnoreCase("Pass"))
		{
			Font font=wb.createFont();
			font.getBold();
			font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
			CellStyle cs=wb.createCellStyle();
			cs.setFont(font);
			wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(cs);
		}
		if(status.equalsIgnoreCase("Fail"))
		{
			Font font=wb.createFont();
			font.getBold();
			font.setColor(IndexedColors.DARK_RED.getIndex());
			CellStyle cs=wb.createCellStyle();
			cs.setFont(font);
			wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(cs);
		}
		if(status.equalsIgnoreCase("Blocked"))
		{
			Font font=wb.createFont();
			font.getBold();
			font.setColor(IndexedColors.ROYAL_BLUE.getIndex());
			CellStyle cs=wb.createCellStyle();
			cs.setFont(font);
			wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(cs);
		}
		FileOutputStream output=new FileOutputStream(outputStreamExcel);
		wb.write(output);
		
	}

}
