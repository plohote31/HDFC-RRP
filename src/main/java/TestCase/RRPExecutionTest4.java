package TestCase;

import java.io.IOException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Config.RRPActionKeywords;
import Config.RRPConstants;
import ExecutionScript.RRPDriverScript;
import Utility.RRPExcelUtility;
import Utility.RRPLog;

public class RRPExecutionTest4 {

	
	public static RRPExcelUtility ex;
	
//Check Warning Signals
	public static void TC21() throws IOException, InterruptedException {

		//Warning signal
			RRPLog.StartTestCase("TC21");
			
			RRPActionKeywords ak=new RRPActionKeywords();
			String	BorrowerType=RRPExcelUtility.GetCellData(RRPDriverScript.initialTestCase, RRPConstants.BorrowerTypeCol, RRPDriverScript.SheetName);
			
			ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			 
			   Thread.sleep(3000);

			   ak.input("Borrower_ID_Search_Rating", 4);
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(4000);
			   ak.click("Proceed_Button", null);
			   Thread.sleep(5000);
			   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
			   if (BorrowerType.equalsIgnoreCase("NBFC")){
				   ak.click("Edit_Button",null); 
				    }else{
				    	ak.ExWait("validation_close");
						   ak.click("validation_close", null);
						   ak.click("Edit_Button",null); 
						}
			   
				//  Warning signal code
			    Thread.sleep(4000);
			 
			    	
				    ak.ExWait("Warning_Signal_tab1");
					ak.click("Warning_Signal_tab1", null);
				    
				Thread.sleep(3000);
				 if (BorrowerType.equalsIgnoreCase("NBFC")){
					 ak.ExWait("NBFCBusiness_Risk_Warning_Signal_Search"); //Is there a perceivable risk of supplier concentration within the company?
						ak.click("NBFCBusiness_Risk_Warning_Signal_Search", null);
						Thread.sleep(4000);
						ak.ExWait("NBFCSignificant");
						ak.click("NBFCSignificant", null);
					    }else{
					    	ak.click("summary_Downarrow", null);//  Expand /Collapse
							Thread.sleep(2000);
							ak.ExWait("Business_Risk_Warning_Signal_Search"); //Is there a perceivable risk of supplier concentration within the company?
							ak.click("Business_Risk_Warning_Signal_Search", null);
							ak.ExWait("Significant");
							ak.click("Significant", null);
					    }
				 
				
				ak.ExWait("Save_Proceed");
				ak.click("Save_Proceed", null);	
				Thread.sleep(6000);
				
				//ak.driver.navigate().refresh();
				//ak.ExWait("Checklist_detailpage_Downarrow");
				//ak.click("Checklist_detailpage_Downarrow", null);	
				ak.ExWait("validation_close");
				   ak.click("validation_close", null);
				
				ak.ExWait("Warning_Signal_tab1");
				ak.click("Warning_Signal_tab1", null);
				ak.ExWait("Warning_Signal_Click_Here_fetch");
				ak.click("Warning_Signal_Click_Here_fetch", null);
				
			   String temp=ak.PassScreenShot();
			   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			   Thread.sleep(6000);
			   RRPLog.EndTestCase("TC21");
	}

	
	//Submit for approval to RA
	public static void TC22() throws IOException, InterruptedException {

		//Submit for approval
			RRPLog.StartTestCase("TC22");
			
			RRPActionKeywords ak=new RRPActionKeywords();
			 ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			 
			   Thread.sleep(3000);

			   ak.input("Borrower_ID_Search_Rating", 4);
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(4000);
			   ak.click("Proceed_Button", null);
			   Thread.sleep(2000);
			   ak.ExWait("Submit_for_Approval_Button");
			   ak.click("Submit_for_Approval_Button", null);
			   ak.STOREWINDOWID();
			   ak.SWITCHWINDOW();
			   ak.ExWait("Search_Button_RA");
			   ak.click("Search_Button_RA", null);
			   ak.input("Grid_Search_Box", 6);
			   ak.ENTER("Grid_Search_Box");
			 //  ak.click("Emp_code", null);
			   Thread.sleep(2000);
			   ak.CLICKNEXTTEXTPATH1(6);
			   ak.click("Update_Comment", null);
			   Thread.sleep(2000);
			   ak.STOREWINDOWID();
			   ak.SWITCHWINDOW();
			   ak.click("Confirmation_OK", null);
			   
			//   ak.ValidateString(ak.GetText("Status_Code"),ex.GetCellData(ak.DS.initialTestCase, 7, ak.DS.SheetName));

			   Thread.sleep(3000);
			   ak.ExWait("validation_close");
			   ak.click("validation_close", null);
			   String temp=ak.PassScreenShot();
			   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

			   RRPLog.EndTestCase("TC22");
	}
	//NBFC Submit for approval to RA
		public static void TC23() throws IOException, InterruptedException {

			//NBFC Submit for approval
				RRPLog.StartTestCase("TC23");
				
				RRPActionKeywords ak=new RRPActionKeywords();
				 ak.OPENBROWSER("Main_URL");
				   ak.navigate("Main_URL");
				   ak.input("Username", 2);
				   ak.input( "Password", 3);
				   ak.click("Login",null);
				 
				   Thread.sleep(3000);

				   ak.input("Borrower_ID_Search_Rating", 4);
				   Thread.sleep(2000);
				   ak.click("Search_Button", null);
				   Thread.sleep(4000);
				   ak.click("Proceed_Button", null);
				   Thread.sleep(2000);
				   ak.ExWait("Submit_for_Approval_Button");
				   ak.click("Submit_for_Approval_Button", null);
				   ak.STOREWINDOWID();
				   ak.SWITCHWINDOW();
				   ak.click("Search_Button_RA", null);
				   ak.input("Grid_Search_Box", 6);
				   ak.ENTER("Grid_Search_Box");
				 //  ak.click("Emp_code", null);
				   Thread.sleep(2000);
				   ak.CLICKNEXTTEXTPATH1(6);
				   ak.click("Update_Comment", null);
				   Thread.sleep(2000);
				   ak.STOREWINDOWID();
				   ak.SWITCHWINDOW();
				   ak.click("Confirmation_OK", null);
				   Thread.sleep(2000);
				   
				//   ak.ValidateString(ak.GetText("Status_Code"),ex.GetCellData(ak.DS.initialTestCase, 7, ak.DS.SheetName));

				   Thread.sleep(3000);
				   //ak.ExWait("validation_close");
				  // ak.click("validation_close", null);
				   String temp=ak.PassScreenShot();
				   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				   RRPLog.EndTestCase("TC23");
		}
		
		//Quality Checklist
		public static void TC24() throws IOException, InterruptedException {
			//Quality Checklist
			RRPLog.StartTestCase("TC24");
			
			
			RRPActionKeywords ak=new RRPActionKeywords();
			String	BorrowerType=RRPExcelUtility.GetCellData(RRPDriverScript.initialTestCase, RRPConstants.BorrowerTypeCol, RRPDriverScript.SheetName);
			System.out.println(BorrowerType);
			ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			 
			   Thread.sleep(3000);
			   ak.ExWait("Borrower_ID_Search_Rating");
			   ak.input("Borrower_ID_Search_Rating", 4);
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(3000);
			   ak.click("Proceed_Button", null);
			   Thread.sleep(4000);
			   ak.ExWait("validation_close");
			   ak.click("validation_close", null);
			   //ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
			   
			   //Invoke checklist
			    ak.click("Invoke_Checklist", null);
			    Thread.sleep(3000);
			    ak.STOREWINDOWID();
				   ak.SWITCHWINDOW();
				   ak.click("Confirmation_OK", null);
				  // ak.STOREWINDOWID();
				  // ak.SWITCHWINDOW();
		  	      ak.click("validation_close", null);
		  	    ak.click("Edit_Button", null);
			    
		  	      
		  	    //if (ak.DS.BorrowerID.equalsIgnoreCase("Submit For Approval")){
			    	
				    ak.click("Down_arrow", null);
				    ak.click("Quality_checklist", null);
				    ak.ExWait("Compute_Rating");
				    ak.click("Compute_Rating", null);
				    
				    //}else{D:\Automation\HDFC_RRP_NEW_MODELS\RRP_Auto_BorrowerCreation_00\Resources\Corporate_Spread_Template_prod_LS.xlsx
				    	//ak.click("Down_arrow", null);
					  //  ak.click("Quality_checklist", null);
					//	}
		  	  
			    Thread.sleep(4000);
				  
				    
				     if(BorrowerType.equalsIgnoreCase("Large Serviecs")){
					    	ak.ExWait("plus_icon_LS");
					    	ak.click("plus_icon_LS", null); 
					    }else {
					    	ak.ExWait("Plus_icon");
						    ak.click("Plus_icon", null);
						    }
				     
				    Thread.sleep(2000);		    
				    ak.click("Comput_Rating_Button", null);
				    Thread.sleep(2000);
				    ak.Select("Classification", "Wholesale");
				    ak.Select("RA_User_Segment", "ECG");
				    Thread.sleep(2000);
				    ak.Select("Framework_Name", "GST");
				    ak.click("Cam_Date", null);
				    ak.input("Cam_Limit", 8);
				    Thread.sleep(2000);
				    ak.click("Last_date_of_Call_memo_available", null);
				    ak.Select("Listed_Company", "Yes");
				    ak.input("BSE_Code",17);
				    ak.input("No_of_Red_Triggers_in_last_12_months",18);
				    ak.input("Red_trigger_Remark", 19);
				    ak.Select("Second_Best_Rating", "AAA");
				    Thread.sleep(2000);
				    ak.Select("Rating_Agency", "Crisil");
				    Thread.sleep(2000);
				    ak.click("Rating_Date",null);
				    Thread.sleep(2000);
				    ak.Select("Issuer_non_co_op", "Yes");
				    Thread.sleep(2000);
				    ak.Select("Reason_for_Divergence1", "Not a model issue");
				    Thread.sleep(2000);
				    ak.Select("Reason_for_Divergence2", "Not a model issue");
				    Thread.sleep(2000);
				    ak.input("Divergence_Remark1", 9);
				    ak.input("Divergence_Remark2", 10);
				    ak.input("Divergence_Remark3", 11);
				    
				    ak.Select("Scale", "Good");
				    Thread.sleep(2000);
				    ak.Select("Operating_performance", "Good");
				    Thread.sleep(2000);
				    ak.Select("Capital_structure","Good");
				    
				    ak.input("Scale1", 12);
				    ak.input("Capital_structure1", 13);
				    ak.input("FA_Intensity1", 14);
				    ak.input("Stock_Statement_Analysis1", 15);
				    ak.input("Average_WC_Utlisation1", 16);
				    
				    
				   ak.Select("Model_Scale_Action_Reason", "Comfortable Liquidity");
				   Thread.sleep(4000);
				    ak.click("Master_Scale_Action_Reason",null);
				    Thread.sleep(2000);
					  ak.input("Grid_Search_Box",6);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					  Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(6);
					   Thread.sleep(2000);
				    ak.Select("Modifier", "+");
				    ak.input("Rating_Rationale",20);
				    ak.input("Key_Strengths",21);
				    ak.input("Key_Weakness",22);
				    ak.input("Liquidity_Assessment",23);
				    ak.input("Credit_Feedback",24);
				    ak.input("Discussion_with_RM",25);
				    ak.input("Key_Rating_Sensitivities_Triggers_Monitorables",26);
				    Thread.sleep(2000);
				    ak.Select("Avaibility", "Available");
				    //ak.BorderHighlight("Save_Proceed");
				    ak.click("Save_Proceed",null);
				    Thread.sleep(10000);
				    ak.ExWait("validation_close");
				    ak.click("validation_close",null);
				    Thread.sleep(3000);
				   
				    //Checklist Details Page
				    ak.click("Checklist_detailpage_Downarrow",null);
				    Thread.sleep(2000);
				    
				    
				     if (BorrowerType.equalsIgnoreCase("Manufacturing")||BorrowerType.contains("Large Services")){
				    ak.click("mfg_Checklist_Detail_Page",null);
				    }else{
					    ak.click("CheckList_Detail_Page",null);}
				    
				    Thread.sleep(5000);
				    
				 
				    ex.setcelldatawithrow(ak.EXTRCT("Classification_detail"), 1, 32, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Cam_Date_detail"), 1, 33, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("BSE_Code_detail"), 1, 34, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Second_Best_Rating_detail"), 1, 35, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Rating_Agency_detail"), 1, 36, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Rating_Date_detail"), 1, 37, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Issuer_non_co_op_detail"), 1, 38, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Proposed_Rating_detail"), 1, 39, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Min_Rating_detail"), 1, 40, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Max_Rating_detail"), 1, 41, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("IR_ERA_Final_Divergence"), 1, 42, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Min_Rating_internal_detail"), 1, 43, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Max_Rating_internal_detail"), 1, 44, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("IR_ERA_internal_Divergence"), 1, 45, RRPConstants.Quality_Checklist, RRPConstants.Path_Excel);
				    
				    String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

					   RRPLog.EndTestCase("TC24");
			   
			
		}

		//NBFC Quality Checklist
		public static void TC25() throws IOException, InterruptedException {
			//NBFC Quality Checklist
			RRPLog.StartTestCase("TC25");
			
			RRPActionKeywords ak=new RRPActionKeywords();
			
			
			 ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			 
			   Thread.sleep(3000);

			   ak.input("Borrower_ID_Search_Rating", 4);
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(3000);
			   ak.click("Proceed_Button", null);
			   Thread.sleep(4000);
//			   ak.STOREWINDOWID();
//			    ak.SWITCHWINDOW();
//			    ak.ExWait("validation_close");
//			    ak.click("validation_close",null);
			 
			   //Invoke checklist
			   ak.click("Invoke_Checklist", null);
			    Thread.sleep(3000);
			    ak.STOREWINDOWID();
			   ak.SWITCHWINDOW();
				   ak.click("Confirmation_OK", null);
					   ak.click("Edit_Button", null);
					   ak.click("NBFC_Quality_checklist", null);
					   ak.click("Plus_icon", null);
					    Thread.sleep(2000);
					    ak.click("Comput_Rating_Button", null);
					    Thread.sleep(2000);
				    ak.click("Comput_Rating_Button", null);
				    Thread.sleep(2000);
				    ak.Select("Classification", "Wholesale");
				    ak.Select("RA_User_Segment", "ECG");
				    Thread.sleep(2000);
				    ak.Select("Framework_Name", "GST");
				    ak.click("Cam_Date", null);
				    ak.input("Cam_Limit", 8);
				    Thread.sleep(2000);
				    ak.click("Last_date_of_Call_memo_available", null);
				    ak.Select("Listed_Company", "Yes");
				    ak.input("BSE_Code",17);
				    ak.input("No_of_Red_Triggers_in_last_12_months",18);
				    ak.input("Red_trigger_Remark", 19);
				    ak.Select("Second_Best_Rating", "AAA");
				    Thread.sleep(2000);
				    ak.Select("Rating_Agency", "Crisil");
				    Thread.sleep(2000);
				    ak.click("Rating_Date",null);
				    Thread.sleep(2000);
				    ak.Select("Issuer_non_co_op", "Yes");
				    Thread.sleep(2000);
				    ak.input("Divergence_Remark1", 9);
				    ak.input("Divergence_Remark2", 10);
				    
				    ak.Select("Scale", "Good");
				    Thread.sleep(2000);
				    ak.Select("Operating_performance", "Good");
				    Thread.sleep(2000);
				   // ak.Select("Capital_structure","Good");
				    
				    ak.Select("NBFC_Scale1", "Good");
				    Thread.sleep(2000);
				    //ak.Select("NBFC_Credit Costs", "Good");
				    //Thread.sleep(2000);
				    ak.Select("Portfolio_cuts_Assessment", "Good");
				    Thread.sleep(2000);
				    
				    
				   ak.Select("Model_Scale_Action_Reason", "Comfortable Liquidity");
				   Thread.sleep(4000);
				    ak.click("Master_Scale_Action_Reason",null);
				    Thread.sleep(2000);
					  ak.input("Grid_Search_Box",6);
					   Thread.sleep(2000);
					   ak.ENTER("Grid_Search_Box");
					  Thread.sleep(3000);
					   ak.CLICKNEXTTEXTPATH1(6);
					   Thread.sleep(2000);
				    ak.Select("Modifier", "+");
				    ak.input("Rating_Rationale",20);
				    ak.input("Key_Strengths",21);
				    ak.input("Key_Weakness",22);
				    ak.input("Liquidity_Assessment",23);
				    ak.input("Credit_Feedback",24);
				    ak.input("Discussion_with_RM",25);
				    ak.input("Key_Rating_Sensitivities_Triggers_Monitorables",26);
				    Thread.sleep(2000);
				   // ak.BorderHighlight("Save_Proceed");
				    ak.click("Save_Proceed",null);
				    Thread.sleep(3000);
				    ak.ExWait("validation_close");
				    ak.click("validation_close",null);
				    Thread.sleep(3000);
				  // ak.click("summary_Downarrow");
				    //ak.PassScreenShot("Rating Summary");
				    
				    //Thread.sleep(5000);
				    //Checklist Details Page
				    ak.click("Checklist_detailpage_Downarrow",null);
				    Thread.sleep(2000);
				    ak.click("NBFC_Quality_checklist_detailpage",null);
				    Thread.sleep(5000); 
				    
				 
				    ex.setcelldatawithrow(ak.EXTRCT("Classification_detail"), 1, 32, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Cam_Date_detail"), 1, 33, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("BSE_Code_detail"), 1, 34, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Second_Best_Rating_detail"), 1, 35, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Rating_Agency_detail"), 1, 36, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Rating_Date_detail"), 1, 37, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Issuer_non_co_op_detail"), 1, 38, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Proposed_Rating_detail"), 1, 39, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Min_Rating_detail"), 1, 40, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Max_Rating_detail"), 1, 41, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("IR_ERA_Final_Divergence"), 1, 42, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Min_Rating_internal_detail"), 1, 43, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("Max_Rating_internal_detail"), 1, 44, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    ex.setcelldatawithrow(ak.EXTRCT("IR_ERA_internal_Divergence"), 1, 45, RRPConstants.NBFC_Quality_Checklist, RRPConstants.Path_Excel);
				    
				    String temp=ak.PassScreenShot();
					   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

					   RRPLog.EndTestCase("TC25");

		}
	
	//RA approved
public static void TC26() throws IOException, InterruptedException {
	//RA approved
	RRPLog.StartTestCase("TC26");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(3000);
	   ak.click("Proceed_Button", null);
	   Thread.sleep(4000);
	   ak.ExWait("validation_close");
	   ak.click("validation_close", null);
	   
	   Thread.sleep(2000);
	   ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",6);
	   ak.Select("Rating_Outlook",7);
	   ak.input("RA_Approval_Comment",8);
	   ak.click("Update_Comment", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   //ak.SWICHTOPARENTWIN();	
	  // ak.ExWait("validation_close");
	  // ak.click("validation_close", null);
	   
	   ak.ExWait("Status_Code");
	   String StatusCode=ak.GetText("Status_Code");
	   if(!StatusCode.equalsIgnoreCase("Rating Finalized")) {
		   
		   ak.akFlag=false;
	   }
	   
	   ak.click("Final_Rating_Button",null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   Thread.sleep(3000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   //ak.click("validation_close", null);
	   
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC26");
	   
}

//pending for disagreement

public static void TC27() throws IOException, InterruptedException {
	//pending for disagreement

	RRPLog.StartTestCase("TC27");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   
	  ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",6);
	   ak.Select("Rating_Outlook",7);
	   ak.input("RA_Approval_Comment",8);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	  ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	  // ak.SWICHTOPARENTWIN();
	 //  ak.driver.navigate().refresh();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   
	  if (ak.EXTRCT("Large_mfg_model").equalsIgnoreCase("Large Manufacturer New Model")){
		  ak.ExWait("Pending_for_Dissagree_Button1");
		   ak.click("Pending_for_Dissagree_Button1", null);
		  
	  }else {
	   
	   ak.ExWait("Pending_for_Dissagree_Button");
	   ak.click("Pending_for_Dissagree_Button", null);
	  }
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.ExWait("summary_Downarrow");
	   ak.click("summary_Downarrow",null);
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC27");
	
	
	
}
//pending for disagreement sent back
public static void TC28() throws IOException, InterruptedException {
	//pending for disagreement

	RRPLog.StartTestCase("TC28");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   
	  ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",6);
	   ak.Select("Rating_Outlook",7);
	   ak.input("RA_Approval_Comment",8);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	  ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	  // ak.SWICHTOPARENTWIN();
	 //  ak.driver.navigate().refresh();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   
	   if (ak.EXTRCT("Large_mfg_model").equalsIgnoreCase("Large Manufacturer New Model")){
			  ak.ExWait("Pending_for_Dissagree_Button1");
			   ak.click("Pending_for_Dissagree_Button1", null);
			  
		  }else {
		   
		   ak.ExWait("Pending_for_Dissagree_Button");
		   ak.click("Pending_for_Dissagree_Button", null);
		  }
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	  // ak.SWICHTOPARENTWIN();
	   ak.ExWait("Reverse_Rating");
       ak.click("Reverse_Rating", null);  //click on Reverse Rating Custom action Button
       ak.ExWait("Discussion_Details");
       ak.input("Discussion_Details", 10);  // Discussion Details
       Thread.sleep(1000);
       ak.click("Reverse_Reason", null);  //Reverse Reason
       Thread.sleep(2000);
	   ak.input("Grid_Search_Box", 11); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
       ak.CHECKBOX("checkbox_select");  //Select Check box
       Thread.sleep(2000);
       ak.click("ok_Button", null);
       
       Thread.sleep(2000);
      
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.ExWait("Header_User_Icon");
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 9);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);

	   ak.click("Submit_for_Approval_Button", null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Search_Button_RA", null);
	   ak.input("Grid_Search_Box", 2);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.click("RA_click", null);
     Thread.sleep(2000);
	    
       //ak.CLICKNEXTTEXTPATH1(2);
	   ak.click("Update_Comment", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	  // ak.STOREWINDOWID();
	   //ak.SWITCHWINDOW();
	  // ak.click("Confirmation_OK", null);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   
	  ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",6);
	   ak.Select("Rating_Outlook",7);
	   ak.input("RA_Approval_Comment",8);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.ExWait("Final_Rating_Button");
	   ak.click("Final_Rating_Button",null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   ak.click("validation_close",null);
	   ak.ExWait("Final_Rating_Button");
	
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC28");
	
	
	
}

public static void TC29() throws IOException, InterruptedException {
	//Rating initiation Rating - RA REVERSE
	RRPLog.StartTestCase("TC29");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(5000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(5000);
	   ak.click("Search_Button", null);
	   Thread.sleep(5000);
	   ak.click("Proceed_Button", null);
	   Thread.sleep(5000);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.ExWait("Reverse_Rating");
       ak.click("Reverse_Rating", null);  //click on Reverse Rating Custom action Button
       ak.ExWait("Discussion_Details");
       ak.input("Discussion_Details", 6);  // Discussion Details
       Thread.sleep(1000);
       ak.click("Reverse_Reason", null);  //Reverse Reason
       Thread.sleep(2000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
       ak.CHECKBOX("checkbox_select");  //Select Check box
       
       Thread.sleep(2000);
       ak.ExWait("Confirmation_OK");
       ak.click("Confirmation_OK", null);
       ak.ExWait("Update");
       ak.click("Update", null);
       ak.ExWait("Confirmation_OK");
       ak.click("Confirmation_OK", null);
       ak.ExWait("validation_close");
	   ak.click("validation_close",null);
       
       
       
       String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC29");
       
}
//RA Reject
public static void TC30() throws IOException, InterruptedException {
	//RA Reject

	RRPLog.StartTestCase("TC30");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   Thread.sleep(4000);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.click("Reject_Rating_Button",null);
	   Thread.sleep(4000);
	   ak.input("Reject_Rating_Reason",6);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	  // ak.click("Confirmation_OK", null);
	 //  ak.driver.navigate().refresh();
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();	
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.ExWait("validation_close");
	   ak.click("validation_close",null);
	   ak.ExWait("Status_Code");
	   String StatusCode=ak.GetText("Status_Code");
	   if(!StatusCode.equalsIgnoreCase("Reject")) {
		   
		   ak.akFlag=false;
	   }
	   Thread.sleep(5000);
		
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC30"); 
	   
}

//Review Provided
public static void TC31() throws IOException, InterruptedException {
	//Review Provided

	RRPLog.StartTestCase("TC31");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("Review_Required_Button");
	   ak.click("Review_Required_Button", null);
	   ak.click("Credit_User_Search_Icon", null);
	  // ak.input("Grid_Search_Box",6);
	  // ak.ENTER("Grid_Search_Box");
	   ak.CLICKNEXTTEXTPATH1(6);
	   ak.click("Update_Comment", null);
	   Thread.sleep(10000);
	   ak.driver.navigate().refresh();
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   ak.input("Username", 6);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   
	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("Edit_button01");
	   ak.click("Edit_button01",null);
	   
	   ak.ExWait("summary_Downarrow");
	   ak.click("summary_Downarrow",null);

	   ak.input("AnyOther_Feedback",8);
	   ak.click("Review_Provided",null);
	   
	   ak.click("Save_Proceed",null);
	   Thread.sleep(10000);
	 ak.driver.navigate().refresh();
	 Thread.sleep(7000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(5000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",9);
	   ak.Select("Rating_Outlook",10);
	   ak.input("RA_Approval_Comment",11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(7000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();	
	   Thread.sleep(3000);
	   ak.ExWait("Final_Rating_Button");
	   ak.click("Final_Rating_Button",null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   Thread.sleep(3000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   //ak.click("validation_close", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	
		
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC31"); 
}

//Review Sent back 
public static void TC32() throws IOException, InterruptedException {
	//Review Sent back 
	RRPLog.StartTestCase("TC32");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(7000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("Review_Required_Button");
	   ak.click("Review_Required_Button", null);
	   ak.click("Credit_User_Search_Icon", null);
	 //  ak.input("Grid_Search_Box",6);
	   //ak.ENTER("Grid_Search_Box");
	   ak.CLICKNEXTTEXTPATH1(6);
	   ak.click("Update_Comment", null);
	   Thread.sleep(10000);
	   ak.driver.navigate().refresh();
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   ak.input("Username", 6);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   
	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("Sent_Back_RA_Button1");
	   ak.click("Sent_Back_RA_Button1",null);

	   Thread.sleep(10000);
	 ak.driver.navigate().refresh();
	 Thread.sleep(7000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.click("Apporve_Rating_Button",null);
	   ak.input("RA_rational",7);
	   ak.Select("Rating_Outlook",8);
	   ak.input("RA_Approval_Comment",9);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();	
	   Thread.sleep(3000);
	   ak.ExWait("Final_Rating_Button");
	   ak.click("Final_Rating_Button",null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   Thread.sleep(3000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   //ak.click("validation_close", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);

		
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC32"); 
}


//Override Approve
public static void TC33() throws IOException, InterruptedException {
	//Override Approve
	RRPLog.StartTestCase("TC33");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(5000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	    Thread.sleep(2000);
	   ak.ExWait("Edit_button01");
	   ak.click("Edit_button01",null);
	   Thread.sleep(2000);
	//   ak.click("Tab_Menu_Arrow", null);
	   String modelname=RRPExcelUtility.GetCellData(1, 5,"FinanceUpload");
	   ak.driver.navigate().refresh();
	   Thread.sleep(3000);
	   if ((modelname.equalsIgnoreCase("small services")) || (modelname.equalsIgnoreCase("Large Manufacturing"))){
		   ak.click("Tab_Menu_Arrow", null);
			  ak.ExWait("Override_tab");
			   ak.click("Override_tab", null);
			  
		  }else {
		   
		   ak.ExWait("Override_tab");
		   ak.click("Override_tab", null);
		  }
	   
	  // ak.click("Override_tab", null);
	   ak.click("Business_Risk_Override_Search", null);
	   Thread.sleep(3000);
	   ak.click("Other_factors_Override", null);
	   
	   ak.click("Override1_Srch", null);
	   
	   ak.click("Override1_Value", null);
	   Thread.sleep(3000);
	   ak.Select("Override_Value", 6);
	   Thread.sleep(3000);
	   ak.click("parameter_field",null);
	   ak.ExWait("parametr_value");
     ak.click("parametr_value", null);
	   ak.click("Compute_Rating",null);
	   ak.click("Save_Proceed",null);
	   Thread.sleep(7000);
	   
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	
	   ak.ExWait("Apporve_Rating_Button");
	   ak.click("Apporve_Rating_Button",null);
	/*  ak.ExWait("Override_Approver_1_delete");//As override 1 user is not not fetching by system after search these line of code is commented
       ak.click("Override_Approver_1_delete", null);  //Override Approver 1 clear
       ak.click("Override_Approver_1", null);   //Override Approver 1 
       
       Thread.sleep(5000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
       ak.CLICKNEXTTEXTPATH1(7);*/
       ak.ExWait("OA1_Approval_Comments");
       ak.input("OA1_Approval_Comments", 11);
       Thread.sleep(2000);
       ak.Select("Rating_Outlook", 8);
       ak.input("RA_rational", 9);
       Thread.sleep(2000);
	   
	
	
	   ak.click("Update_Comment", null);
	   Thread.sleep(7000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 10);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);
	   ak.ExWait("Borrower_ID_Search_Rating");
	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.driver.navigate().refresh();
	   ak.click("Override_Approve_Button", null);
	   ak.input("Override_Approve_Comment", 11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(10000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	 	
//	   //ak.driver.navigate().refresh();
//	   ak.click("Header_User_Icon",null);
//	   ak.click("Logout_link", null);
//	   
//	   ak.input("Username", 10);
//	   ak.input( "Password", 3);
//	   ak.click("Login",null);
//	 
//	   Thread.sleep(3000);
//
//	   ak.input("Borrower_ID_Search_Rating", 4);
//	   Thread.sleep(2000);
//	   ak.click("Search_Button", null);
//	   Thread.sleep(4000);
//	   ak.click("Proceed_Button", null);
//
//	   ak.click("Override_Approve_Button", null);
//	   ak.input("Override_Approve_Comment", 11);
//	   ak.click("Update_Comment", null);
//	   Thread.sleep(5000);
//	   ak.STOREWINDOWID();
//	   ak.SWITCHWINDOW();
//	   ak.click("Confirmation_OK", null);
//	   Thread.sleep(3000);
//	   ak.SWICHTOPARENTWIN();
	 
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC33");
	

	   
	   
}


//Override Sent back
public static void TC34() throws IOException, InterruptedException {
	//Override sent back
	RRPLog.StartTestCase("TC34");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	    Thread.sleep(2000);
	   ak.ExWait("Edit_button01");
	   ak.click("Edit_button01",null);
	//   ak.click("Tab_Menu_Arrow", null);
	   String modelname=RRPExcelUtility.GetCellData(1, 5,"FinanceUpload");
	   ak.driver.navigate().refresh();
	   Thread.sleep(3000);
	   if ((modelname.equalsIgnoreCase("small services")) || (modelname.equalsIgnoreCase("Large Manufacturing"))){
		   ak.click("Tab_Menu_Arrow", null);
			  ak.ExWait("Override_tab");
			   ak.click("Override_tab", null);
			  
		  }else {
		   
		   ak.ExWait("Override_tab");
		   ak.click("Override_tab", null);
		  }
	   ak.click("Business_Risk_Override_Search", null);
	   Thread.sleep(3000);
	   ak.click("Other_factors_Override", null);
	   
	   ak.click("Override1_Srch", null);
	   
	   ak.click("Override1_Value", null);
	   Thread.sleep(3000);
	   ak.Select("Override_Value", 6);
	   Thread.sleep(3000);
	   ak.click("parameter_field",null);
	   ak.ExWait("parametr_value");
      ak.click("parametr_value", null);
	   ak.click("Compute_Rating",null);
	   ak.click("Save_Proceed",null);
	   Thread.sleep(7000);
	   
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	//  ak.driver.navigate().refresh();
	  ak.ExWait("Apporve_Rating_Button");
	   ak.click("Apporve_Rating_Button",null);
	   
	   ak.ExWait("Override_Approver_2_delete");
      ak.click("Override_Approver_2_delete", null);  //Override Approver 2 clear
      ak.click("Override_Approver_2", null);   //Override Approver 2
      
      Thread.sleep(5000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
      ak.CLICKNEXTTEXTPATH1(7);
      ak.ExWait("Approval_Comments");
      ak.input("Approval_Comments", 11);
      Thread.sleep(2000);
      ak.Select("Rating_Outlook", 8);
      ak.input("RA_rational", 9);
      Thread.sleep(2000);
	  
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(5000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 10);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(5000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   ak.ExWait("Sent_Back_RA_Button");
	   ak.click("Sent_Back_RA_Button", null);
	   ak.input("Override_SentBack_Comment", 11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   
	   Thread.sleep(7000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 2);//RA Login
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   ak.ExWait("Apporve_Rating_Button");
	   ak.click("Apporve_Rating_Button",null);
	   ak.ExWait("Override_Approver_2_delete");
       ak.click("Override_Approver_2_delete", null);  //Override Approver 2 clear
       ak.click("Override_Approver_2", null);   //Override Approver 2
       
       Thread.sleep(5000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
	// ak.CLICKNEXTTEXTPATH1(7);
	   ak.click("OA_User", null);
       ak.ExWait("Approval_Comments");
       ak.input("Approval_Comments", 11);
       Thread.sleep(2000);
       ak.Select("Rating_Outlook", 8);
       ak.input("RA_rational", 9);
       Thread.sleep(2000);
	   ak.click("Update_Comment", null);
	   Thread.sleep(7000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 10);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	  // ak.driver.navigate().refresh();
	   ak.click("Override_Approve_Button", null);
	   ak.input("Override_Approve_Comment", 11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);

	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC34");
		   
}
//Override special Approve
public static void TC35() throws IOException, InterruptedException {
	//Override Approve
RRPLog.StartTestCase("TC35");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	 ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("Edit_button01");
	   ak.click("Edit_button01",null);
	//   ak.click("Tab_Menu_Arrow", null);
	   String modelname=RRPExcelUtility.GetCellData(1, 5,"FinanceUpload");
	   ak.driver.navigate().refresh();
	   Thread.sleep(3000);
	   if ((modelname.equalsIgnoreCase("small services")) || (modelname.equalsIgnoreCase("Large Manufacturing"))){
		   ak.click("Tab_Menu_Arrow", null);
			  ak.ExWait("Override_tab");
			   ak.click("Override_tab", null);
			  
		  }else {
		   
		   ak.ExWait("Override_tab");
		   ak.click("Override_tab", null);
		  }
	   Thread.sleep(3000);
	   ak.Select("Additional_Override_Value", 6);
	   Thread.sleep(3000);
	   ak.input("Additional_Override_Comment", 9);
	   Thread.sleep(3000);
	   ak.ExWait("Compute_Rating");
	   ak.click("Compute_Rating",null);
	   ak.click("Save_Proceed",null);
	   Thread.sleep(7000);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	
	   ak.ExWait("Apporve_Rating_Button");
	   ak.click("Apporve_Rating_Button",null);
	 /* ak.ExWait("Override_Approver_3_delete");//As override 1 user is not not fetching by system after search these line of code is commented
     ak.click("Override_Approver_3_delete", null);  //Override Approver 1 clear
     ak.click("Override_Approver_3", null);   //Override Approver 1 
     
     Thread.sleep(5000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
     ak.CLICKNEXTTEXTPATH1(7);*/
     ak.ExWait("Approval_Comments");
     ak.input("Approval_Comments", 11);
     Thread.sleep(2000);
     ak.Select("Rating_Outlook", 8);
     ak.input("RA_rational", 9);
     Thread.sleep(2000);
	   
	
	
	   ak.click("Update_Comment", null);
	   Thread.sleep(7000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 10);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	 //  ak.driver.navigate().refresh();
	   ak.click("Override_Approve_Button", null);
	   ak.input("Override_Approve_Comment", 11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	 	//ak.driver.navigate().refresh();
	    Thread.sleep(5000);
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC35");

	   
	   
}

//Withdraw rating
public static void TC36() throws IOException, InterruptedException {
	//Withdraw rating
	RRPLog.StartTestCase("TC36");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	    Thread.sleep(2000);
	   ak.ExWait("Edit_button01");
	   ak.click("Edit_button01",null);
	//   ak.click("Tab_Menu_Arrow", null);
	   
	   if (ak.EXTRCT("Small_services_model").equalsIgnoreCase("small services")){
		   ak.click("Tab_Menu_Arrow", null);
			  ak.ExWait("Override_tab");
			   ak.click("Override_tab", null);
			   
			  
		  }else {
		   
		   ak.ExWait("Override_tab");
		   ak.click("Override_tab", null);
		  }
	   ak.click("Business_Risk_Override_Search", null);
	   Thread.sleep(3000);
	   ak.click("Other_factors_Override", null);
	   
	   ak.click("Override1_Srch", null);
	   
	   ak.click("Override1_Value", null);
	   Thread.sleep(3000);
	   ak.Select("Override_Value", 6);
	   Thread.sleep(3000);
	   ak.click("parameter_field",null);
	   ak.ExWait("parametr_value");
       ak.click("parametr_value", null);
	   ak.click("Compute_Rating",null);
	   ak.click("Save_Proceed",null);
	   Thread.sleep(7000);
	   
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	//  ak.driver.navigate().refresh();
	  ak.ExWait("Apporve_Rating_Button");
	   ak.click("Apporve_Rating_Button",null);
	   
	   ak.ExWait("Override_Approver_2_delete");
       ak.click("Override_Approver_2_delete", null);  //Override Approver 2 clear
       ak.click("Override_Approver_2", null);   //Override Approver 2
       
       Thread.sleep(5000);
	   ak.input("Grid_Search_Box", 7); 
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(5000);
       ak.CLICKNEXTTEXTPATH1(7);
       ak.ExWait("Approval_Comments");
       ak.input("Approval_Comments", 11);
       Thread.sleep(2000);
       ak.Select("Rating_Outlook", 8);
       ak.input("RA_rational", 9);
       Thread.sleep(2000);
	  
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(5000);
	   ak.click("Header_User_Icon",null);
	   ak.click("Logout_link", null);
	   
	   ak.input("Username", 10);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	 
	   Thread.sleep(3000);

	   ak.input("Borrower_ID_Search_Rating", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(4000);
	   ak.click("Proceed_Button", null);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   ak.click("Override_Approve_Button", null);
	   ak.input("Override_Approve_Comment", 11);
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(7000);
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	   ak.ExWait("Withdraw_Button");
	   ak.click("Withdraw_Button",null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	  
	   Thread.sleep(3000);
	 
	   String temp=ak.PassScreenShot();
	   
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	   RRPLog.EndTestCase("TC36");
	   
}


//ICR Generation
public static void TC37() throws IOException, InterruptedException {
	//ICR Generation
	
RRPLog.StartTestCase("TC37");

RRPActionKeywords ak=new RRPActionKeywords();
 ak.OPENBROWSER("Main_URL");
   ak.navigate("Main_URL");
   ak.input("Username", 2);
   ak.input( "Password", 3);
   ak.click("Login",null);
 
   Thread.sleep(3000);

   ak.input("Borrower_ID_Search_Rating", 4);
   Thread.sleep(2000);
   ak.click("Search_Button", null);
   Thread.sleep(4000);
   ak.click("Proceed_Button", null);
   
    ak.click("ICR_Button", null);
    ak.STOREWINDOWID();
    ak.SWITCHWINDOW();
    ak.click("Confirmation_OK", null);
    Thread.sleep(5000);
 //  Thread.sleep(3000);
   // ak.ExWait("Tab_Menu_Arrow");
   //ak.click("Tab_Menu_Arrow", null);
   ak.click("Related_Attachment_Tab", null);
   
    ak.ExWait("validation_close");
    ak.click("validation_close",null);
   Thread.sleep(3000);
   
   String temp=ak.PassScreenShot();
   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

   RRPLog.EndTestCase("TC37");
   
}

//FCR generation
public static void TC38() throws IOException, InterruptedException {
	//FCR generation
RRPLog.StartTestCase("TC38");

RRPActionKeywords ak=new RRPActionKeywords();
 ak.OPENBROWSER("Main_URL");
   ak.navigate("Main_URL");
   ak.input("Username", 2);
   ak.input( "Password", 3);
   ak.click("Login",null);
 
   Thread.sleep(3000);

   ak.input("Borrower_ID_Search_Rating", 4);
   Thread.sleep(2000);
   ak.click("Search_Button", null);
   Thread.sleep(4000);
   ak.click("Proceed_Button", null);
   
//   ak.click("Apporve_Rating_Button",null);
//   ak.click("Confirmation_OK", null);
//   ak.input("RA_rational",6);
//   ak.Select("Rating_Outlook",7);
//   ak.input("RA_Approval_Comment",8);
//   ak.click("Update_Comment", null);
//   Thread.sleep(5000);
//   ak.STOREWINDOWID();
//   ak.SWITCHWINDOW();
//   ak.click("Confirmation_OK", null);
//   Thread.sleep(3000);
//   ak.SWICHTOPARENTWIN();
//   Thread.sleep(5000);
//   ak.driver.navigate().refresh();
//   ak.ExWait("Final_Rating_Button");
//   ak.click("Final_Rating_Button",null);
//   Thread.sleep(5000);
//   ak.click("Confirmation_OK", null);
   Thread.sleep(4000);
   
   ak.click("FCR_Button", null);
   ak.STOREWINDOWID();
   ak.SWITCHWINDOW();
   ak.click("Confirmation_OK", null);
   Thread.sleep(5000);
  // ak.click("Confirmation_OK", null);
   ak.driver.navigate().refresh();
   ak.ExWait("validation_close");
   ak.click("validation_close",null);
   ak.ExWait("Tab_Menu_Arrow");
   ak.click("Tab_Menu_Arrow", null);
   ak.click("Related_Attachment_Tab", null);
   Thread.sleep(4000);
  
   
   String temp=ak.PassScreenShot();
   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

   RRPLog.EndTestCase("TC38");
   
}


}