package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Config.RRPConstants;
import ExecutionScript.RRPDriverScript;

public class RRPExcelUtility {

	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static Row row;
	public static Cell cell;
	public static FileInputStream ExcelFile;
	public static void SetExcelFile(String FilePath) throws IOException
		{
		try {
		    ExcelFile=new FileInputStream(FilePath);
			workbook = new XSSFWorkbook(ExcelFile);
			RRPLog.info("Excel loaded successfully");
			
			}
		catch (Exception e) 
			{
			//RRPLog.info("Excel is not able to read due to " +e.getMessage());
			}
		
		}
	
	public static void CloseExcel() throws IOException {
		try{
			ExcelFile.close();
			RRPLog.info("Excel flushed successfully");
		}catch(Exception e) {
			RRPLog.info("Excel not flushed due to "+e.getMessage());
		}
		
	}
	
	public static String GetCellData(int RowNum,int ColNum,String Sheetname) 
	{
	try {
		worksheet=workbook.getSheet(Sheetname);
		XSSFCell  cell=worksheet.getRow(RowNum).getCell(ColNum);
		
		 DataFormatter formatter = new DataFormatter();
		// String CellData=formatter.formatCellValue(cell);
		String CellData=cell.getStringCellValue();
		return CellData;
		
		}
	catch (Exception e) 
		{
	//	RRPLog.info("Excel is not able to read " +e.getMessage());
		}
	return "";
	
	}
	
	
	public static int getnumberofrows(String sheetname) {
		int Numberofrows = 0;
		try 
		{
			worksheet=workbook.getSheet(sheetname);
			 Numberofrows=worksheet.getLastRowNum()+1;
				
			RRPLog.info("Read number of rows of sheet "+sheetname);
		}catch(Exception e)
		{
			RRPLog.info("Not able count number of row of sheet "+sheetname+" due to "+e.getMessage());
		}
		return 	Numberofrows;
	}
	
	/*public static int getrowcontains(String TestCaseName,int ColNum,String sheetname) {
		int RowNum = 0;
		try{
		 int RowCount=ExcelUtility.getnumberofrows(sheetname);
		for(;RowNum<RowCount;RowNum++) {
			if(TestCaseName.equalsIgnoreCase(ExcelUtility.GetCellData(RowNum, Constants.TestCaseIDCol, sheetname))) {
			break;
		}}
		Log.info("Successfully retuned rowcontains");

		
		}catch(Exception e) {
			Log.info("Not able to retuned rowcontains");
		
		}
		return RowNum;
		
	}*/
	
	public static int getrowcontains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int iRowNum = 0;
		try {
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = RRPExcelUtility.getnumberofrows(SheetName);
			for (; iRowNum < rowCount; iRowNum++) {
				if (RRPExcelUtility.GetCellData(iRowNum, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
		} catch (Exception e) {
			RRPLog.info("Not able to retuned rowcontains");
		}
		return iRowNum;
	}
	
public static int getstepcount(int itestcase,String TestCaseName,String sheetname) {
	
	int RowNum=0;

		try{
		
		int lRow=RRPExcelUtility.getnumberofrows(sheetname);

		for(int i=itestcase;i<lRow+1;i++) {
			if(TestCaseName.equalsIgnoreCase(RRPExcelUtility.GetCellData(i, RRPConstants.TestCaseIDCol, sheetname)))
			{
				 RowNum = i+1;
				
			 }
				
			}
		
		worksheet=workbook.getSheet(sheetname);
		 //RowNum=worksheet.getLastRowNum();
		
		RRPLog.info("Successfully retuned rowcontains");
		return RowNum;
		
		}catch(Exception e) {
			RRPLog.info("Not able to retuned rowcontains");
			return 0;
		}
		
		
	}
	
	
	

public static String setcelldata(String Result,int ColNum) throws IOException {
	try {
	RRPExcelUtility.SetExcelFile(RRPConstants.Path_Excel);
	
	//borrower1
	worksheet=workbook.getSheet(RRPDriverScript.SheetName);
	row=worksheet.getRow(RRPDriverScript.initialTestCase);
	cell=row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
	if(cell==null) {
		cell = row.createCell(ColNum);
		System.out.println(cell);
		cell.setCellValue(Result);
	}else {
		cell.setCellValue(Result);

	}
	FileOutputStream fileout=new FileOutputStream(RRPConstants.Path_Excel);
	workbook.write(fileout);
	
	fileout.close();
	RRPLog.info("Vaule set in excel file ");
	
	}
	catch(Exception e) {
		RRPLog.info("Not able to write in excel file "+e.getMessage());
	}
	
	return null;
}
public static String setcelldatawithrow(String Result,int RowNum,int ColNum,String SheetName,String FilePath) throws IOException {
	try {
		
		RRPExcelUtility.SetExcelFile(FilePath);
	
	worksheet=workbook.getSheet(SheetName);
	row=worksheet.getRow(RowNum);
	cell=row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);

		cell = row.createCell(ColNum);
		cell.setCellValue(Result);
	System.out.println("Value set in excel file is "+Result);
		//cell.setCellValue(Result);

	
	FileOutputStream fileout=new FileOutputStream(FilePath);
	workbook.write(fileout);
	fileout.close();
	RRPLog.info("Vaule set in excel file ");
	
	}
	catch(Exception e) {
		RRPLog.info("Not able to write in excel file due to "+e.getMessage());
	}
	
	return null;
}


}
