package TestCase;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;


import Config.RRPActionKeywords;
import Config.RRPConstants;
import ExecutionScript.RRPDriverScript;
import Utility.RRPExcelUtility;
import Utility.RRPLog;



import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class RRPExecutionTest {

public static RRPExcelUtility ex;

	
//Small Service Borrower Creation 
public static void TC01() throws IOException, InterruptedException {
        
		//Borrower Creation
		RRPLog.StartTestCase("TC01");
		RRPActionKeywords ak=new RRPActionKeywords();
		
		   ak.OPENBROWSER("Main_URL");
		   ak.navigate("Main_URL");
		   ak.input("Username", 2);
		   ak.input( "Password", 3);
		   ak.click("Login",null);
		   ak.navigate("Borrower_Homepage");
   
		//   ak.click("plus_icon", null);
		   ak.navigate("Borrower_Creation_URL");
		   ak.input("PAN", 5);
		   ak.Tab("PAN");
		   Thread.sleep(2000);
		    ak.Clear("Borrower_Name");
		   Thread.sleep(2000);
		 
		   ak.Clear("Borrower_Name");
		   ak.input("Borrower_Name", 6);
		   ak.input("Date_of_Commencement", 7);
		//   ak.Select("Company_Type",8);
		   ak.input("Asset_Class",9);
		   ak.PickerSelect("Asset_Class",9);
		   ak.input("Lending_Type", 10);
		   ak.PickerSelect("Lending_Type",10);
		   
		   ak.input("Business_Type", 11);
		   ak.PickerSelect("Business_Type",11);
		   ak.click("Constitution", null);
		   Thread.sleep(3000);
		   ak.input("Grid_Search_Box",12);
		   
		   ak.ENTER("Grid_Search_Box");
		//   ak.click("Grid_Search_Box_Button", null);
		   Thread.sleep(2000);
		   ak.CLICKNEXTTEXTPATH1(12);
		   Thread.sleep(2000);
		   ak.click("Market_Segment", null);
		   Thread.sleep(2000);
		   ak.input("Grid_Search_Box", 13);
		   Thread.sleep(2000);
		   ak.ENTER("Grid_Search_Box");
		 //  ak.click("Grid_Search_Box_Button", null);
		   Thread.sleep(3000);
		   ak.CLICKNEXTTEXTPATH1(13);
		   Thread.sleep(3000);
		   
		   ak.click("Group_Name", null);
		   ak.input("Grid_Search_Box", 14);
		 //ak.click("Grid_Search_Box_Button", null);
		   ak.ENTER("Grid_Search_Box");
		   Thread.sleep(3000);
		   ak.CLICKNEXTTEXTPATH1(14);
		   Thread.sleep(3000);
		 
		   ak.click("RBI_Code1", null);
		   Thread.sleep(2000);
		   ak.input("Grid_Search_Box",16);
		   ak.ENTER("Grid_Search_Box");
		   Thread.sleep(3000);
		   ak.CLICKNEXTTEXTPATH1(16);
		   Thread.sleep(2000);
		   ak.click("RRP_Industry1", null);
		   ak.input("Grid_Search_Box", 17);
		   Thread.sleep(2000);
		   ak.ENTER("Grid_Search_Box");
		   //ak.click("Grid_Search_Box_Button", null);
		   Thread.sleep(5000);
		   ak.CLICKNEXTTEXTPATH1(17);
		   Thread.sleep(2000);
		   ak.click("Save_Proceed", null);
		   Thread.sleep(10000);
		   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
		   ex.setcelldata(ak.DS.BorrowerID,18);
		   
		   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
		   ak.DS.BorrowerTypeFinance.add("Services");
		   
		   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
		   ak.DS.BorrowerType.add("Services");
	
		   ak.DS.SMEBorrowerID=  ak.DS.BorrowerID;
		   ak.DS.SmallServiceBorrowerID=ak.DS.BorrowerID;
		   
		   Thread.sleep(5000);
	
		   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
		 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
		   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
		   Thread.sleep(2000);
		   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
		   Thread.sleep(2000);
		   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
		   Thread.sleep(2000);
		   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
		   Thread.sleep(2000);
		   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
		   je.executeScript("window.scrollBy(0,300)");
		//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
		   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
		   Thread.sleep(2000);
		    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
		   
		   String RBICode=ak.GetText("RBI_Code1_Detail");
		   String[] RBIArrary=RBICode.split("-");
		   String RBIcodeextract=RBIArrary[0];
		   RBIcodeextract=RBIcodeextract.trim();
		  // System.out.println("extracted RBI code ="+RBIcodeextract);
		   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
		   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName)); 
		   
		   
			
			ak.DocSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.SentSheetUpdate(ak.DS.BorrowerID, "Services"); 
			ak.AuthorizeSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.WarningSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.FinacialSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.QualityChecklistSheetUpdate(ak.DS.BorrowerID, "Services");
			ak.AllSheetUpdate(ak.DS.BorrowerID);
			
			ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Small_Service_Model, RRPConstants.Path_Excel);//Update Borrower ID in SME Model Sheet for rating
			ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
			ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
			ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
			
		   Thread.sleep(10000);
			
		   String temp=ak.PassScreenShot();
		   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		
		   RRPLog.EndTestCase("TC01");	
	
	}



				
//NBFC Borrower Creation 
@SuppressWarnings("static-access")
public static void TC02() throws IOException, InterruptedException {
			        
					//NBFC Borrower Creation
	RRPLog.StartTestCase("TC02");
					RRPActionKeywords ak=new RRPActionKeywords();
					
					   ak.OPENBROWSER("Main_URL");
					   ak.navigate("Main_URL");
					   ak.input("Username", 2);
					   ak.input( "Password", 3);
					   ak.click("Login",null);
					   ak.navigate("Borrower_Homepage");
					   Thread.sleep(2000);
					   //ak.click("plus_icon", null);
					   ak.navigate("Borrower_Creation_URL");
					   ak.input("PAN", 5);
					   ak.Tab("PAN");
					   Thread.sleep(2000);
					    ak.Clear("Borrower_Name");
					   Thread.sleep(2000);
					 
					   ak.Clear("Borrower_Name");
					   ak.input("Borrower_Name", 6);
					   ak.input("Date_of_Commencement", 7);
					 //  ak.Select("Company_Type",8);
					   ak.input("Asset_Class",9);
					   ak.PickerSelect("Asset_Class",9);
					   ak.input("Lending_Type", 10);
					   ak.PickerSelect("Lending_Type",10);
					   
					   ak.input("Business_Type", 11);
					   ak.PickerSelect("Business_Type",11);
					   ak.click("Constitution", null);
					   Thread.sleep(3000);
					   ak.input("Grid_Search_Box",12);
					   ak.ENTER("Grid_Search_Box");
					//   ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(12);
					   Thread.sleep(2000);
					   ak.click("Market_Segment", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box", 13);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					 //  ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(13);
					   Thread.sleep(3000);
					   
					   ak.click("Group_Name", null);
					   ak.input("Grid_Search_Box", 14);
					 //ak.click("Grid_Search_Box_Button", null);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(14);
					 
					   Thread.sleep(3000);
					   ak.click("RBI_Code1", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box",16);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(16);
					   Thread.sleep(2000);
					   ak.click("RRP_Industry1", null);
					   ak.input("Grid_Search_Box", 17);
					   ak.ENTER("Grid_Search_Box");
					   //ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(2000);
					   ak.CLICKNEXTTEXTPATH1(17);
					   
					   ak.click("Save_Proceed", null);
					   Thread.sleep(10000);
					   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
					   ex.setcelldata(ak.DS.BorrowerID,18);
					   
					   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerTypeFinance.add("NBFC");
					   
					   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerType.add("NBFC");
					   
					  // ex.setcelldata(BorrowerID,4);
					  // Thread.sleep(3000);
					 //  ak.input("Borrower_ID_Search",18);
					   Thread.sleep(5000);
					   //ak.click("Search_Button",null);
					   //ak.click("Proceed_Button",null);
					   
					 
					
					   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
					 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
					   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
					   je.executeScript("window.scrollBy(0,300)");
					//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
					   Thread.sleep(2000);
					    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
					   
					   String RBICode=ak.GetText("RBI_Code1_Detail");
					   String[] RBIArrary=RBICode.split("-");
					   String RBIcodeextract=RBIArrary[0];
					   RBIcodeextract=RBIcodeextract.trim();
					  // System.out.println("extracted RBI code ="+RBIcodeextract);
					   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName));
				
				
					   ak.FinacialSheetUpdate( ak.DS.BorrowerID, "NBFC");
						ak.DocSheetUpdate(ak.DS.BorrowerID, "NBFC");
						ak.SentSheetUpdate(ak.DS.BorrowerID, "NBFC");  
						ak.AuthorizeSheetUpdate(ak.DS.BorrowerID, "NBFC");
						ak.WarningSheetUpdate(ak.DS.BorrowerID, "NBFC");
						//ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "NBFC");	
						ak.NBFCRASubmitSheetUpdate(ak.DS.BorrowerID, "NBFC");
						ak.AllSheetUpdate(ak.DS.BorrowerID);
						
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.NBFC_Model_Sheet, RRPConstants.Path_Excel);//Update Borrower ID in NBFC Model Sheet for rating
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.PendDissagreeSentBackSheet, RRPConstants.Path_Excel);//Update Borrower ID in Pending for disagreement sent back sheet
						//ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Small_Service_Model, RRPConstants.Path_Excel);//Update Borrower ID in SME Model Sheet for rating
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
						
					   Thread.sleep(10000);
						
					   String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
					
					   RRPLog.EndTestCase("TC02");	
				}				


//Trader Borrower Creation 
@SuppressWarnings("static-access")
public static void TC03() throws IOException, InterruptedException {
			        
					//Borrower Creation
	RRPLog.StartTestCase("TC03");				
					RRPActionKeywords ak=new RRPActionKeywords();
					
					   ak.OPENBROWSER("Main_URL");
					   ak.navigate("Main_URL");
					   ak.input("Username", 2);
					   ak.input( "Password", 3);
					   ak.click("Login",null);
					   ak.navigate("Borrower_Homepage");
					   ak.click("plus_icon", null);
					   ak.navigate("Borrower_Creation_URL");
					   ak.input("PAN", 5);
					   ak.Tab("PAN");
					   Thread.sleep(2000);
					    ak.Clear("Borrower_Name");
					   Thread.sleep(2000);
					 
					   ak.Clear("Borrower_Name");
					   ak.input("Borrower_Name", 6);
					   ak.input("Date_of_Commencement", 7);
					 //  ak.Select("Company_Type",8);
					   ak.input("Asset_Class",9);
					   ak.PickerSelect("Asset_Class",9);
					   ak.input("Lending_Type", 10);
					   ak.PickerSelect("Lending_Type",10);
					   
					   ak.input("Business_Type", 11);
					   ak.PickerSelect("Business_Type",11);
					   ak.click("Constitution", null);
					   Thread.sleep(3000);
					   ak.input("Grid_Search_Box",12);
					   ak.ENTER("Grid_Search_Box");
					//   ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(2000);
					   ak.CLICKNEXTTEXTPATH1(12);
					   Thread.sleep(2000);
					   ak.click("Market_Segment", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box", 13);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					 //  ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(13);
					   Thread.sleep(3000);
					   
					   ak.click("Group_Name", null);
					   ak.input("Grid_Search_Box", 14);
					 //ak.click("Grid_Search_Box_Button", null);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(14);
					   
					   Thread.sleep(3000);
					   ak.click("RBI_Code1", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box",16);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(16);
					   Thread.sleep(3000);
					   ak.click("RRP_Industry1", null);
					   ak.input("Grid_Search_Box", 17);
					   ak.ENTER("Grid_Search_Box");
					   //ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(2000);
					   ak.CLICKNEXTTEXTPATH1(17);
					   
					   ak.click("Save_Proceed", null);
					   Thread.sleep(10000);
					   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
					   ex.setcelldata(ak.DS.BorrowerID,18);
					   
					   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerTypeFinance.add("Trader");
					   
					   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerType.add("Trader");
					   
					   
					  // ex.setcelldata(BorrowerID,4);
					  // Thread.sleep(3000);
					 //  ak.input("Borrower_ID_Search",18);
					   Thread.sleep(5000);
					   //ak.click("Search_Button",null);
					   //ak.click("Proceed_Button",null);
					   
					 
					 
					
					   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
					 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
					   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
					   je.executeScript("window.scrollBy(0,300)");
					//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
					   Thread.sleep(2000);
					    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
					   
					   String RBICode=ak.GetText("RBI_Code1_Detail");
					   String[] RBIArrary=RBICode.split("-");
					   String RBIcodeextract=RBIArrary[0];
					   RBIcodeextract=RBIcodeextract.trim();
					  // System.out.println("extracted RBI code ="+RBIcodeextract);
					   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName));
				
					   	ak.FinacialSheetUpdate( ak.DS.BorrowerID, "Trader");
					   	ak.DocSheetUpdate(ak.DS.BorrowerID, "Trader");
					   	ak.SentSheetUpdate(ak.DS.BorrowerID, "Trader");
					   	ak.AuthorizeSheetUpdate(ak.DS.BorrowerID,"Trader");
					   	ak.WarningSheetUpdate(ak.DS.BorrowerID, "Trader");
					   	ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Trader");
					   	ak.QualityChecklistSheetUpdate(ak.DS.BorrowerID, "Trader");
					   	ak.AllSheetUpdate(ak.DS.BorrowerID);
							
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Trader_Model, RRPConstants.Path_Excel);//Update Borrower ID in Bank Model Sheet for rating
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.FCRSheet, RRPConstants.Path_Excel);//Update Borrower ID in Override special sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
						//ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
						
						
						
					   String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
					   Thread.sleep(5000);
			   RRPLog.EndTestCase("TC03");	   
			
				}	
//Small Manufacturing Borrower Creation 
	public static void TC04() throws IOException, InterruptedException {
	        
			//Borrower Creation
			RRPLog.StartTestCase("TC04");
			RRPActionKeywords ak=new RRPActionKeywords();
			
			   ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			   ak.navigate("Borrower_Homepage");
	   
			//   ak.click("plus_icon", null);
			   ak.navigate("Borrower_Creation_URL");
			   ak.input("PAN", 5);
			   ak.Tab("PAN");
			   Thread.sleep(2000);
			    ak.Clear("Borrower_Name");
			   Thread.sleep(2000);
			 
			   ak.Clear("Borrower_Name");
			   ak.input("Borrower_Name", 6);
			   ak.input("Date_of_Commencement", 7);
			//   ak.Select("Company_Type",8);
			   ak.input("Asset_Class",9);
			   ak.PickerSelect("Asset_Class",9);
			   ak.input("Lending_Type", 10);
			   ak.PickerSelect("Lending_Type",10);
			   
			   ak.input("Business_Type", 11);
			   ak.PickerSelect("Business_Type",11);
			   ak.click("Constitution", null);
			   Thread.sleep(3000);
			   ak.input("Grid_Search_Box",12);
			   
			   ak.ENTER("Grid_Search_Box");
			//   ak.click("Grid_Search_Box_Button", null);
			   Thread.sleep(2000);
			   ak.CLICKNEXTTEXTPATH1(12);
			   Thread.sleep(2000);
			   ak.click("Market_Segment", null);
			   Thread.sleep(2000);
			   ak.input("Grid_Search_Box", 13);
			   Thread.sleep(2000);
			   ak.ENTER("Grid_Search_Box");
			 //  ak.click("Grid_Search_Box_Button", null);
			   Thread.sleep(3000);
			   ak.CLICKNEXTTEXTPATH1(13);
			   Thread.sleep(3000);
			   
			   ak.click("Group_Name", null);
			   ak.input("Grid_Search_Box", 14);
			 //ak.click("Grid_Search_Box_Button", null);
			   ak.ENTER("Grid_Search_Box");
			   Thread.sleep(3000);
			   ak.CLICKNEXTTEXTPATH1(14);
			   Thread.sleep(3000);
			 
			   ak.click("RBI_Code1", null);
			   Thread.sleep(2000);
			   ak.input("Grid_Search_Box",16);
			   ak.ENTER("Grid_Search_Box");
			   Thread.sleep(3000);
			   ak.CLICKNEXTTEXTPATH1(16);
			   Thread.sleep(2000);
			   ak.click("RRP_Industry1", null);
			   ak.input("Grid_Search_Box", 17);
			   Thread.sleep(2000);
			   ak.ENTER("Grid_Search_Box");
			   //ak.click("Grid_Search_Box_Button", null);
			   Thread.sleep(5000);
			   ak.CLICKNEXTTEXTPATH1(17);
			   Thread.sleep(2000);
			   ak.click("Save_Proceed", null);
			   Thread.sleep(10000);
			   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
			   ex.setcelldata(ak.DS.BorrowerID,18);
			   
			   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
			   ak.DS.BorrowerTypeFinance.add("Manufacturing");
			   
			   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
			   ak.DS.BorrowerType.add("Manufacturing");
		
			   ak.DS.SMEBorrowerID=  ak.DS.BorrowerID;
			   ak.DS.SmallManufacturingBorrowerID=ak.DS.BorrowerID;
			   
			   Thread.sleep(5000);
		
			   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
			 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
			   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
			   Thread.sleep(2000);
			   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
			   Thread.sleep(2000);
			   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
			   Thread.sleep(2000);
			   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
			   Thread.sleep(2000);
			   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
			   je.executeScript("window.scrollBy(0,300)");
			//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
			   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
			   Thread.sleep(2000);
			    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
			   
			   String RBICode=ak.GetText("RBI_Code1_Detail");
			   String[] RBIArrary=RBICode.split("-");
			   String RBIcodeextract=RBIArrary[0];
			   RBIcodeextract=RBIcodeextract.trim();
			  // System.out.println("extracted RBI code ="+RBIcodeextract);
			   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
			   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName)); 
			   
			   
				
				ak.DocSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.SentSheetUpdate(ak.DS.BorrowerID, "Manufacturing"); 
				ak.AuthorizeSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.WarningSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.FinacialSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.QualityChecklistSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
				ak.AllSheetUpdate(ak.DS.BorrowerID);
				
				ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Small_Manufacturing_Model, RRPConstants.Path_Excel);//Update Borrower ID in SME Model Sheet for rating
				ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
				ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
				//ex.setcelldatawithrow(ak.DS.Borrowertype, 1, 5, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
				
			   Thread.sleep(10000);
				
			   String temp=ak.PassScreenShot();
			   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
			   RRPLog.EndTestCase("TC04");	
		
		}
	
	//Large Manufacturing Borrower Creation 
			public static void TC05() throws IOException, InterruptedException {
			        
					//Borrower Creation
					RRPLog.StartTestCase("TC05");
					RRPActionKeywords ak=new RRPActionKeywords();
					
					   ak.OPENBROWSER("Main_URL");
					   ak.navigate("Main_URL");
					   ak.input("Username", 2);
					   ak.input( "Password", 3);
					   ak.click("Login",null);
					   ak.navigate("Borrower_Homepage");
			   
					//   ak.click("plus_icon", null);
					   ak.navigate("Borrower_Creation_URL");
					   ak.input("PAN", 5);
					   ak.Tab("PAN");
					   Thread.sleep(2000);
					    ak.Clear("Borrower_Name");
					   Thread.sleep(2000);
					 
					   ak.Clear("Borrower_Name");
					   ak.input("Borrower_Name", 6);
					   ak.input("Date_of_Commencement", 7);
					//   ak.Select("Company_Type",8);
					   ak.input("Asset_Class",9);
					   ak.PickerSelect("Asset_Class",9);
					   ak.input("Lending_Type", 10);
					   ak.PickerSelect("Lending_Type",10);
					   
					   ak.input("Business_Type", 11);
					   ak.PickerSelect("Business_Type",11);
					   ak.click("Constitution", null);
					   Thread.sleep(3000);
					   ak.input("Grid_Search_Box",12);
					   
					   ak.ENTER("Grid_Search_Box");
					//   ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(2000);
					   ak.CLICKNEXTTEXTPATH1(12);
					   Thread.sleep(2000);
					   ak.click("Market_Segment", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box", 13);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					 //  ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(13);
					   Thread.sleep(3000);
					   
					   ak.click("Group_Name", null);
					   ak.input("Grid_Search_Box", 14);
					 //ak.click("Grid_Search_Box_Button", null);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(14);
					   Thread.sleep(3000);
					 
					   ak.click("RBI_Code1", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box",16);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(16);
					   Thread.sleep(2000);
					   ak.click("RRP_Industry1", null);
					   ak.input("Grid_Search_Box", 17);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					   //ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(5000);
					   ak.CLICKNEXTTEXTPATH1(17);
					   Thread.sleep(2000);
					   ak.click("Save_Proceed", null);
					   Thread.sleep(10000);
					   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
					   ex.setcelldata(ak.DS.BorrowerID,18);
					   
					   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerTypeFinance.add("Manufacturing");
					   
					   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerType.add("Manufacturing");
				
					   ak.DS.SMEBorrowerID=  ak.DS.BorrowerID;
					   ak.DS.LargeManufacturingBorrowerID=ak.DS.BorrowerID;
					   
					   Thread.sleep(5000);
				
					   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
					 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
					   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
					   je.executeScript("window.scrollBy(0,300)");
					//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
					   Thread.sleep(2000);
					    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
					   
					   String RBICode=ak.GetText("RBI_Code1_Detail");
					   String[] RBIArrary=RBICode.split("-");
					   String RBIcodeextract=RBIArrary[0];
					   RBIcodeextract=RBIcodeextract.trim();
					  // System.out.println("extracted RBI code ="+RBIcodeextract);
					   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName)); 
					   
					   
						
						ak.DocSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
						ak.SentSheetUpdate(ak.DS.BorrowerID, "Manufacturing"); 
						ak.AuthorizeSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
						ak.WarningSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
						ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
						ak.FinacialSheetUpdate(ak.DS.BorrowerID, "Large Manufacturing");
						ak.QualityChecklistSheetUpdate(ak.DS.BorrowerID, "Manufacturing");
						ak.AllSheetUpdate(ak.DS.BorrowerID);
						
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Large_Manufacturing_Model, RRPConstants.Path_Excel);//Update Borrower ID in SME Model Sheet for rating
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
						//ex.setcelldatawithrow(ak.DS.Borrowertype, 1, 5, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
						
					   Thread.sleep(10000);
						
					   String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
					
					   RRPLog.EndTestCase("TC05");	
				
				}
			//Large Service Borrower Creation 
			public static void TC06() throws IOException, InterruptedException {
			        
					//Borrower Creation
					RRPLog.StartTestCase("TC06");
					RRPActionKeywords ak=new RRPActionKeywords();
					
					   ak.OPENBROWSER("Main_URL");
					   ak.navigate("Main_URL");
					   ak.input("Username", 2);
					   ak.input( "Password", 3);
					   ak.click("Login",null);
					   ak.navigate("Borrower_Homepage");
			   
					//   ak.click("plus_icon", null);
					   ak.navigate("Borrower_Creation_URL");
					   ak.input("PAN", 5);
					   ak.Tab("PAN");
					   Thread.sleep(2000);
					    ak.Clear("Borrower_Name");
					   Thread.sleep(2000);
					 
					   ak.Clear("Borrower_Name");
					   ak.input("Borrower_Name", 6);
					   ak.input("Date_of_Commencement", 7);
					//   ak.Select("Company_Type",8);
					   ak.input("Asset_Class",9);
					   ak.PickerSelect("Asset_Class",9);
					   ak.input("Lending_Type", 10);
					   ak.PickerSelect("Lending_Type",10);
					   
					   ak.input("Business_Type", 11);
					   ak.PickerSelect("Business_Type",11);
					   ak.click("Constitution", null);
					   Thread.sleep(3000);
					   ak.input("Grid_Search_Box",12);
					   
					   ak.ENTER("Grid_Search_Box");
					//   ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(2000);
					   ak.CLICKNEXTTEXTPATH1(12);
					   Thread.sleep(2000);
					   ak.click("Market_Segment", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box", 13);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					 //  ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(13);
					   Thread.sleep(3000);
					   
					   ak.click("Group_Name", null);
					   ak.input("Grid_Search_Box", 14);
					 //ak.click("Grid_Search_Box_Button", null);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(14);
					   Thread.sleep(3000);
					 
					   ak.click("RBI_Code1", null);
					   Thread.sleep(2000);
					   ak.input("Grid_Search_Box",16);
					   ak.ENTER("Grid_Search_Box");
					   Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(16);
					   Thread.sleep(2000);
					   ak.click("RRP_Industry1", null);
					   ak.input("Grid_Search_Box", 17);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					   //ak.click("Grid_Search_Box_Button", null);
					   Thread.sleep(5000);
					   ak.CLICKNEXTTEXTPATH1(17);
					   Thread.sleep(2000);
					   ak.click("Save_Proceed", null);
					   Thread.sleep(10000);
					   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
					   ex.setcelldata(ak.DS.BorrowerID,18);
					   
					   ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerTypeFinance.add("Services");
					   
					   ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
					   ak.DS.BorrowerType.add("Services");
				
					   ak.DS.SMEBorrowerID=  ak.DS.BorrowerID;
					   ak.DS.LargeServiceBorrowerID=ak.DS.BorrowerID;
					   
					   Thread.sleep(5000);
				
					   ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
					 //  ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
					   ak.ValidateString(ak.GetText("Borrower_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Lending_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,10 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   ak.ValidateString(ak.GetText("Business_Type_Detail"), ex.GetCellData(ak.DS.initialTestCase,11 , ak.DS.SheetName));
					   Thread.sleep(2000);
					   JavascriptExecutor je = (JavascriptExecutor)ak.driver;
					   je.executeScript("window.scrollBy(0,300)");
					//   Assert.assertEquals(ak.GetText("Constitution_Detail"), ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("Market_Segment_Detail"), ex.GetCellData(ak.DS.initialTestCase,13 , ak.DS.SheetName));
					   Thread.sleep(2000);
					    ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase,14 , ak.DS.SheetName));
					   
					   String RBICode=ak.GetText("RBI_Code1_Detail");
					   String[] RBIArrary=RBICode.split("-");
					   String RBIcodeextract=RBIArrary[0];
					   RBIcodeextract=RBIcodeextract.trim();
					  // System.out.println("extracted RBI code ="+RBIcodeextract);
					   ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
					   ak.ValidateString(ak.GetText("RRP_Industry1_Detail"), ex.GetCellData(ak.DS.initialTestCase,17 , ak.DS.SheetName)); 
					   
					   
						
						ak.DocSheetUpdate(ak.DS.BorrowerID, "Services");
						ak.SentSheetUpdate(ak.DS.BorrowerID, "Services"); 
						ak.AuthorizeSheetUpdate(ak.DS.BorrowerID, "Services");
						ak.WarningSheetUpdate(ak.DS.BorrowerID, "Large Services");
						ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Services");
						ak.FinacialSheetUpdate(ak.DS.BorrowerID, "Large Services");
						ak.QualityChecklistSheetUpdate(ak.DS.BorrowerID, "Large Services");
						ak.AllSheetUpdate(ak.DS.BorrowerID);
						
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Large_Service_Model, RRPConstants.Path_Excel);//Update Borrower ID in SME Model Sheet for rating
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.RAapprovedSheet, RRPConstants.Path_Excel);//Update Borrower ID in RA Approved sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 4, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);//Update the Borrower ID in Quality checklist sheet
						ex.setcelldatawithrow(ak.DS.BorrowerID, 1, 19, RRPConstants.RM_reassignment, RRPConstants.Path_Excel);
						
					   Thread.sleep(10000);
						
					   String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
					
					   RRPLog.EndTestCase("TC06");	
				
				}
}	



