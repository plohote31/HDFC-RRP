package ExecutionScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Config.RRPActionKeywords;
import Config.RRPConstants;
import TestCase.RRPExecutionTest;
import TestCase.RRPExecutionTest2;
import TestCase.RRPExecutionTest3;
import TestCase.RRPExecutionTest4;
import Utility.RRPExcelUtility;
import Utility.RRPLog;

public class RRPDriverScript {
	
	
	public static Properties OR;
	public static RRPExecutionTest et;
	public static RRPExecutionTest2 et2;
	public static RRPExecutionTest2 et3;
	public static RRPExecutionTest4 et4;
	public static RRPExcelUtility ex;
	public static Method mt1[],mt2[],mt3[],mt4[];
	public static int TotalTestCase;
	public static ArrayList<String> sheetNames,methodnames;
	public static String RunMode;
	public static String TestCaseIDName;
	public static String TestCaseDes;
	public static String TypeofBorrower;
	public static String SheetName;								
	public static int initialTestCase;
	public static int lastTestCase;
	public static int Mname,Mname2,Mname4;
	public static String TestintrimResult;
	public static ExtentSparkReporter reporter;
	public static String currentDir;
	public static String outPutFolder;
	public static String ScreenShotFolder ;
	public static String FailedScreenShotFolder;
	public static File flOutput;
	public static File flScreenShotFolder, src, dest;
	public static File flFailedScreenShotFolder;
	public static String PassScreenShot;
	public static String FailedScreenShot;
	public static  ExtentReports extent;
	public static ExtentTest ExtentTest;
	public static String extentrpt,DataEnginFile;
	public static String BorrowerID;
	public static String Borrowertype;
	public static String SMEBorrowerID;
	public static String SmallServiceBorrowerID;
	public static String SmallManufacturingBorrowerID;
	public static String LargeManufacturingBorrowerID;
	public static String LargeServiceBorrowerID;
	public static ArrayList<String> BorrowerIDFinance,BorrowerIDArray;
	public static ArrayList<String> BorrowerTypeFinance,BorrowerType;
	
	
	
	public static int finsheetrow=0,docsheetrow=0,sentsheetrow=0,authorizesheetrow=0,submitsheetrow=0,NBFCsubmitsheetrow=0,QualityChecklistSheetrow=0,warningsheetrow=0;
	public static int AllSheetUpdate=0;
	
public RRPDriverScript() {
	
	
	
	mt1= new RRPExecutionTest().getClass().getMethods();
	
	mt2= new RRPExecutionTest2().getClass().getMethods();
	mt3= new RRPExecutionTest3().getClass().getMethods();
	mt4= new RRPExecutionTest4().getClass().getMethods();
	
	Mname=mt1.length;
	Mname2=mt2.length;
	Mname4=mt4.length;
	System.out.println("I am Constructor");
	
	
}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		BorrowerIDArray = new ArrayList<String>();
		BorrowerType = new ArrayList<String>();
		BorrowerIDFinance = new ArrayList<String>();
		BorrowerTypeFinance = new ArrayList<String>();
		
		
	  RRPActionKeywords ak=new RRPActionKeywords();
	  RRPDriverScript DS=new RRPDriverScript();
	   String Path_OR=RRPConstants.Path_OR;
	  
	   FileInputStream fis=new FileInputStream(Path_OR);
	   OR=new Properties(System.getProperties());
	   OR.load(fis);
	  
	 
	   String SD = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
	   PassScreenShot = "PassScreenShot_"+SD;
		FailedScreenShot = "FailedScreenShot_"+SD;
	   
	    currentDir = System.getProperty("user.dir");
		outPutFolder = currentDir +"\\Output_"+SD;
		ScreenShotFolder = outPutFolder+"\\"+PassScreenShot;
		FailedScreenShotFolder = outPutFolder+"\\"+FailedScreenShot;
		flOutput = new File(outPutFolder);
		flScreenShotFolder = new File(ScreenShotFolder);
		flFailedScreenShotFolder = new File(FailedScreenShotFolder);
		flOutput.mkdir();
		flScreenShotFolder.mkdir();
		flFailedScreenShotFolder.mkdir();
	   
		extentrpt = "HDFC_RRP_Automation_Report_"+SD;
	   
	   reporter=new ExtentSparkReporter(outPutFolder+"//"+extentrpt+".html");
	   reporter.config().setReportName("RRP Test result");
	   
	   extent=new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Project Name", "HDFC RRP New Models");
	   
//	   DataEnginFile = outPutFolder+"//DataEngin_"+SD+".xlsx";
//		src = new File(RRPConstants.Path_Excel);
//		dest = new File(DataEnginFile);
//		FileUtils.copyFile(src, dest);
	   
	   DOMConfigurator.configure("D:\\Automation\\HDFC_RRP_NEW_MODELS\\RRP_Auto_BorrowerCreation_00\\src\\main\\resources\\Log4j.xml");
	   ex.SetExcelFile(RRPConstants.Path_Excel);
	   System.out.println("method name 1 "+Mname);
	   System.out.println("method name 2 "+Mname2);
	   System.out.println("method name 4 "+Mname4);
	   TotalTestCase=ex.getnumberofrows(RRPConstants.TestCaseSheet);
	   
	   System.out.println("Total Test cases on Test Case Sheet : "+TotalTestCase);
	   
	   int TotalSheetsNum=ex.workbook.getNumberOfSheets();
	   
	   System.out.println("Total Number of sheets "+TotalSheetsNum);
	   
	   sheetNames = new ArrayList<String>();
	   
	   for(int i=0;i<TotalSheetsNum;i++) {
		   System.out.println("Sheet name in for Loop : "+ex.workbook.getSheetName(i));
		   sheetNames.add(ex.workbook.getSheetName(i));
		  
	   }
	
	   for(int i=0;i<TotalTestCase;i++) {
		   
		   RunMode=ex.GetCellData(i, RRPConstants.RunModeCol, RRPConstants.TestCaseSheet);
		   System.out.println("Run mode is "+RunMode);
		   TestCaseIDName=ex.GetCellData(i, RRPConstants.TestCaseIDCol, RRPConstants.TestCaseSheet);
		   
		   TestCaseDes=ex.GetCellData(i, RRPConstants.TestCasedesCol, RRPConstants.TestCaseSheet);
		   
		   if (RunMode.equalsIgnoreCase("Yes")) {
			   
			   System.out.println("Total Sheets in array list : "+sheetNames.size());
			   
			   for(int j=1;j<sheetNames.size();j++) {
				   
				   SheetName=sheetNames.get(j);
				   System.out.println("Sheet name ="+SheetName);
				   System.out.println("Test case id name = "+TestCaseIDName );
				   initialTestCase=ex.getrowcontains(TestCaseIDName, RRPConstants.TestCaseIDCol, SheetName);
				   System.out.println("initial test case "+initialTestCase);
				   System.out.println("match of test case = "+ex.GetCellData(initialTestCase, RRPConstants.TestCaseIDCol, SheetName));   
				   if(TestCaseIDName.equalsIgnoreCase(ex.GetCellData(initialTestCase, RRPConstants.TestCaseIDCol, SheetName))) {
					   
					   lastTestCase=ex.getstepcount(initialTestCase, TestCaseIDName, SheetName);
					   System.out.println("last test case "+lastTestCase);
					
						
					
					   for(;initialTestCase<lastTestCase;initialTestCase++) {
						   System.out.println("Execute Action");
						   
						   TypeofBorrower=ex.GetCellData(initialTestCase, 5, SheetName);
						   
						   execute_actions();
						   
						   if(TestintrimResult.equalsIgnoreCase(RRPConstants.KEYWORD_FAIL))
						   {
							   //ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes+" "+TypeofBorrower);
							   ex.setcelldata(RRPConstants.KEYWORD_FAIL, 500);
							
							 
								 
							 //  String temp=ak.FailScreenShot();
							  //ExtentTest.log(Status.FAIL, TestCaseIDName+" "+TestCaseDes+" is failed",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
							 //  ExtentTest.log(Status.FAIL, TestCaseIDName+" "+TestCaseDes+" "+TypeofBorrower+" is failed",MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
							  //extent.flush();
							   
						   }else {
							   //ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes+" "+TypeofBorrower);
							   ex.setcelldata(RRPConstants.KEYWORD_PASS, 500);
							   
							  // String temp=ak.PassScreenShot();
							   
							  // ExtentTest.log(Status.PASS, TestCaseIDName+" "+" "+TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
							   //ExtentTest.log(Status.PASS, TestCaseIDName+" "+" "+TestCaseDes+" "+TypeofBorrower+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
							   //ExtentTest.addScreenCaptureFromPath(temp);
							   //ExtentTest.log(Status.PASS,TestCaseIDName+" is passed"+" "+TestCaseDes);
							   //extent.flush();
							   
						   }
						//ak.driver.close();
						   }
					   
					}
					   
					   
				   }   
		   }
		    
		   }
	   DataEnginFile = outPutFolder+"//DataEngin_"+SD+".xlsx";
		src = new File(RRPConstants.Path_Excel);
		dest = new File(DataEnginFile);
		FileUtils.copyFile(src, dest); 
	   }
	   
	
	public static void execute_actions() throws Exception, IllegalArgumentException, InvocationTargetException {
		
		ea1();
		ea2();
		ea3();
		ea4();
		
		
	}
	
public static void ea1() throws Exception {
		
	for (int i = 0; i < mt1.length; i++) {
		
		
		if(mt1[i].getName().equalsIgnoreCase(TestCaseIDName)) {
			System.out.println("Envoke method number"+mt1[i]);
					//ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes);
			mt1[i].invoke(et);
					//extent.flush();
			TestintrimResult=RRPActionKeywords.ResultFlag();
				
			System.out.println(TestCaseIDName+" : "+TestintrimResult);
				}
			
			}
		
		}


public static void ea2() throws Exception {
		
		for (int i = 0; i < mt2.length; i++) {
		
		
				if(mt2[i].getName().equalsIgnoreCase(TestCaseIDName)) {
					System.out.println("Envoke method number"+mt2[i]);
					//ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes);
					mt2[i].invoke(et2);
					//extent.flush();
					TestintrimResult=RRPActionKeywords.ResultFlag();
				
					System.out.println(TestCaseIDName+" : "+TestintrimResult);
				}
			
			}
		
		}

public static void ea3() throws Exception {
	
	for (int i = 0; i < mt3.length; i++) {
	
	
			if(mt3[i].getName().equalsIgnoreCase(TestCaseIDName)) {
				System.out.println("Envoke method number"+mt2[i]);
				//ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes);
				mt3[i].invoke(et3);
				//extent.flush();
				TestintrimResult=RRPActionKeywords.ResultFlag();
			
				System.out.println(TestCaseIDName+" : "+TestintrimResult);
			}
		
		}
	
	}

public static void ea4() throws Exception {
	
	for (int i = 0; i < mt4.length; i++) {
	
	
			if(mt4[i].getName().equalsIgnoreCase(TestCaseIDName)) {
				System.out.println("Envoke method number"+mt4[i]);
				//ExtentTest=extent.createTest(TestCaseIDName+" "+TestCaseDes);
				mt4[i].invoke(et4);
				//extent.flush();
				TestintrimResult=RRPActionKeywords.ResultFlag();
			
				System.out.println(TestCaseIDName+" : "+TestintrimResult);
			}
		
		}
	
	}




	}





