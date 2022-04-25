package TestCase;

import java.io.IOException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


import Config.RRPActionKeywords;
import Config.RRPConstants;
import ExecutionScript.RRPDriverScript;
import Utility.RRPExcelUtility;
import Utility.RRPLog;

public class RRPExecutionTest2 {

	public static RRPExcelUtility ex;
	

	//Financial Upload to borrower
		@SuppressWarnings("static-access")
		public static void TC07() throws IOException, InterruptedException {
			RRPLog.StartTestCase("TC07");	
			RRPActionKeywords ak=new RRPActionKeywords();
			
			
			
			   ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			   ak.navigate("Borrower_Homepage");
			 //  ex.setcelldata(ak.DS.BorrowerID,4);
			//  ex.SetExcelFile(RRPConstants.Path_Excel);
			   Thread.sleep(3000);
			   
			   ak.input("Borrower_ID_Search", 4);
			   
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(2000);
			   ak.click("Proceed_Button", null);
			  
			   //Financial file upload
			   ak.RatingFinancialpath();
			   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
			 
			   ak.WriteBorrowerID(ak.DS.BorrowerID);
			  
			   //Financial upload
			   ak.click("Finacial_upload_tab", null);
			   ak.click("Upload_Data", null);
			   ak.STOREWINDOWID();
			   ak.SWITCHWINDOW();
			   Thread.sleep(5000);
			   ak.click("File_Financial_Upload", null);
			   ak.FILEUPLOADROBO("File_Financial_Upload", ak.RatingFinancialpath() );
			   Thread.sleep(8000);
			   ak.Select("Select_year","2021");
			   Thread.sleep(2000);
			   ak.click("Import_Button", null);
			
			   Thread.sleep(8000);
			   ak.SWICHTOPARENTWIN();
			   ak.driver.navigate().refresh();
			   Thread.sleep(5000);
			   ak.click("Finacial_upload_tab", null);
			   
			   if(ak.IsDisplyed("No_Data")==true) {
				   ak.akFlag=false;
			   }
			 
			   String temp=ak.PassScreenShot();
			   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
			   RRPLog.EndTestCase("TC07");	
		
			
		}
			
	
	
	
public static void TC08() throws IOException, InterruptedException {
	
	//Document Upload
	RRPLog.StartTestCase("TC08");
			
			RRPActionKeywords ak=new RRPActionKeywords();
			
			   ak.OPENBROWSER("Main_URL");
			   ak.navigate("Main_URL");
			   ak.input("Username", 2);
			   ak.input( "Password", 3);
			   ak.click("Login",null);
			   ak.navigate("Borrower_Homepage");
			   //ex.setcelldata(ak.DS.BorrowerID,4);
			   Thread.sleep(3000);
			   ak.ExWait("Borrower_ID_Search");
			   ak.input("Borrower_ID_Search", 4);
			   Thread.sleep(2000);
			   ak.click("Search_Button", null);
			   Thread.sleep(2000);
			   ak.click("Proceed_Button", null);
			   
			 //Document Upload
			   ak.click("Documents_Tab", null);
			   ak.click("Attach_New_Document", null);
			   ak.STOREWINDOWID();
			   ak.SWITCHWINDOW();
			
			   Thread.sleep(3000);
			   ak.ExWait("Attachment_Icon");
			   ak.click("Attachment_Icon", null);
			   ak.FILEUPLOADROBO("Attachment_Icon", RRPConstants.DocFilePath);
			   Thread.sleep(3000);
			   ak.inputwithdata("Description", "Test");
			   Thread.sleep(3000);
			   ak.click("Save_Button", null);
			    ak.SWICHTOPARENTWIN();
			  Thread.sleep(3000);
			
			   ak.SWICHTOPARENTWIN();
			   ak.driver.navigate().refresh();
			   ak.click("Documents_Tab", null);
			
			   if(ak.IsDisplyed("No_Data")==true) {
				   ak.akFlag=false;
			   }
			   String temp=ak.PassScreenShot();
			   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
			   RRPLog.EndTestCase("TC08");	   
			   		   
}
	
//Send for approval
public static void TC09() throws IOException, InterruptedException {
	
	//Send for approval
	RRPLog.StartTestCase("TC09");	
	
	RRPActionKeywords ak=new RRPActionKeywords();
	
	
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");

	   //ex.setcelldata(ak.DS.BorrowerID,4);
	   Thread.sleep(3000);
	   
	   ak.input("Borrower_ID_Search", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   Thread.sleep(3000);
	   ak.click("Proceed_Button", null);
	   Thread.sleep(2000);
	   ak.click("Send_for_Approval_Button", null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   Thread.sleep(2000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(2000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(2000);
	   
	   ak.ExWait("Confirmation_OK");
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(2000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(2000);
	  
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC09");	
	   
	  	   
}

//Need more info
public static void TC10() throws IOException, InterruptedException {
	
	RRPLog.StartTestCase("TC10");	
	
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
	  // ak.Select("Company_Type",8);
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
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(14);
	  
	   Thread.sleep(2000);
	   ak.click("RBI_Code1", null);
	   Thread.sleep(2000);
	   ak.input("Grid_Search_Box",16);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(16);
	   Thread.sleep(2000);
	   ak.click("RRP_Industry1", null);
	   ak.input("Grid_Search_Box", 17);
	   ak.ENTER("Grid_Search_Box");
	   //ak.click("Grid_Search_Box_Button", null);
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(17);
	   
	   ak.click("Save_Proceed", null);
	   Thread.sleep(4000);
	   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
	   ex.setcelldata(ak.DS.BorrowerID,18);
	 
	   ak.click("Send_for_Approval_Button", null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   ak.SWICHTOPARENTWIN();
	
	   Thread.sleep(2000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(2000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(2000);
	   ak.close();
	
	   //login with helpdesk user
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 20);
	   ak.input( "Password", 21);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.input("Borrower_ID_Search", 18);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	   ak.click("Self_Assign_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.click("NeedMoreInfo_Button",null);
	   Thread.sleep(5000);
	   ak.input("NeedMoreInfo_Comment",22);
	   Thread.sleep(3000);
	  // ak.click("Feedback_Reason", null);
	  // ak.click("Double_Click",null);
	   ak.Select("Feedback_Reason", 23);
	   ak.click("Update_Comment",null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC10");	
	   
}


//information provided
public static void TC11() throws IOException, InterruptedException {
	
	//information provided
	RRPLog.StartTestCase("TC11");
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
	  // ak.Select("Company_Type",8);
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
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(14);
	  
	   Thread.sleep(2000);
	   ak.click("RBI_Code1", null);
	   Thread.sleep(2000);
	   ak.input("Grid_Search_Box",16);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(16);
	   Thread.sleep(2000);
	   ak.click("RRP_Industry1", null);
	   ak.input("Grid_Search_Box", 17);
	   ak.ENTER("Grid_Search_Box");
	   //ak.click("Grid_Search_Box_Button", null);
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(17);
	   
	   ak.click("Save_Proceed", null);
	   Thread.sleep(4000);
	   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
	   ex.setcelldata(ak.DS.BorrowerID,18);
	 
	   ak.click("Send_for_Approval_Button", null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(2000);
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(2000);
	   ak.SWICHTOPARENTWIN();
	   Thread.sleep(3000);
	   ak.close();
	
	
	   //login with helpdesk user
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 20);
	   ak.input( "Password", 21);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.input("Borrower_ID_Search", 18);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	   ak.click("Self_Assign_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.click("NeedMoreInfo_Button",null);
	   Thread.sleep(5000);
	   ak.input("NeedMoreInfo_Comment",22);
	   Thread.sleep(3000);
	  // ak.click("Feedback_Reason", null);
	  // ak.click("Double_Click",null);
	   ak.Select("Feedback_Reason", 23);
	   ak.click("Update_Comment",null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.close();
	  
	
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");

	   //ex.setcelldata(ak.DS.BorrowerID,4);
	   Thread.sleep(3000);
	   
	   ak.input("Borrower_ID_Search", 18);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	   ak.click("Edit_Button", null);
	   ak.click("Information_Provided",null);
	   ak.input("NeedMoreInfo_Comment",6);
	   ak.click("Save_Proceed",null);
	   
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC11");	
}

//Authorize
public static void TC12() throws IOException, InterruptedException {
	
	//Authorize the borrower
	RRPLog.StartTestCase("TC12");	
	RRPActionKeywords ak=new RRPActionKeywords();
	
		   
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   
	   
	   ak.input("Borrower_ID_Search", 4);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	
	   Thread.sleep(3000);
	  ak.click("Self_Assign_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   ak.click("Authorize_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	  // ak.ExWait("Authorize_Comment");
	   //ak.input("Authorize_Comment", 6);
	   Thread.sleep(3000);
	   ak.click("Confirmation_OK",null);
	   Thread.sleep(3000);
	   //ak.ExWait("Update_Comment");
	  // ak.click("Update_Comment", null);
	   //Thread.sleep(10000);
	  // ak.SWICHTOPARENTWIN();
	   
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();	
	   

//	   String StatusCode=ak.GetText("Status_Code_DetailsPage");
//	   if(!StatusCode.equalsIgnoreCase("Authorized")) {
//		   
//		   ak.akFlag=false;
//	   }
	
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC12");	
	
}

//Reject borrower
public static void TC13() throws IOException, InterruptedException {
	
	//Reject borrower
	RRPLog.StartTestCase("TC13");
	
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
	  // ak.Select("Company_Type",8);
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
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(14);
	  
	   Thread.sleep(2000);
	   ak.click("RBI_Code1", null);
	   Thread.sleep(2000);
	   ak.input("Grid_Search_Box",16);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(16);
	   Thread.sleep(2000);
	   ak.click("RRP_Industry1", null);
	   ak.input("Grid_Search_Box", 17);
	   ak.ENTER("Grid_Search_Box");
	   //ak.click("Grid_Search_Box_Button", null);
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(17);
	   
	   ak.click("Save_Proceed", null);
	   Thread.sleep(4000);
	   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
	   ex.setcelldata(ak.DS.BorrowerID,18);
	 
	   ak.click("Send_for_Approval_Button", null);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.ExWait("Confirmation_OK");
	   ak.click("Confirmation_OK", null);
	   ak.SWICHTOPARENTWIN();
	   ak.close();
	
	
	   //login with helpdesk user
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 20);
	   ak.input( "Password", 21);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.input("Borrower_ID_Search", 18);
	   Thread.sleep(2000);
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	
	   ak.click("Self_Assign_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(5000);
	   ak.SWICHTOPARENTWIN();
	   ak.ExWait("Reject_Borrower_Button");
	   ak.click("Reject_Borrower_Button", null);
	   Thread.sleep(3000);
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.ExWait("Reject_Comment");
	   ak.input("Reject_Comment", 22);
	   Thread.sleep(3000);
	   ak.ExWait("Update_Comment");
	   ak.click("Update_Comment", null);
	   Thread.sleep(5000);
	   
	   ak.SWICHTOPARENTWIN();
	   
	   ak.STOREWINDOWID();
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   
	   
	   
	   String StatusCode=ak.GetText("Rejected_Status_Code_DetailsPage");
	   if(!StatusCode.equalsIgnoreCase("Rejected")) {
		   
		   ak.akFlag=false;
	   }
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC13");	
}


//RM-Reassignment
public static void TC14() throws IOException, InterruptedException {
	
	//RM-Reassignment
	RRPLog.StartTestCase("TC14");
	
	RRPActionKeywords ak=new RRPActionKeywords();
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   
	   ak.navigate("Borrower_Homepage");
	   ak.input("Borrower_ID_Search",19);
		   Thread.sleep(2000);
	   ak.click("Search_Button",null);
	   ak.click("Proceed_Button",null);
	   ak.click("Child_Borrower_tab",null);
	   ak.click("Child_New_Borrower_link", null);
	   
	   
	   ak.input("Borrower_Name", 6);
	   ak.input("Date_of_Commencement", 7);
	 //  ak.Select("Company_Type",8);
	   ak.input("Asset_Class",9);
	   ak.PickerSelect("Asset_Class",9);
	   ak.input("Lending_Type", 10);
	   ak.PickerSelect("Lending_Type",10);
	   
	   ak.input("Business_Type", 11);
	   ak.PickerSelect("Business_Type",11);
	  
	   Thread.sleep(2000);
	   ak.click("RBI_Code1", null);
	   Thread.sleep(2000);
	   ak.input("Grid_Search_Box",16);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(16);
	   Thread.sleep(2000);
	   ak.click("RRP_Industry1", null);
	   ak.input("Grid_Search_Box", 17);
	   ak.ENTER("Grid_Search_Box");
	   //ak.click("Grid_Search_Box_Button", null);
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(17);
	   
	   ak.click("Save_Proceed", null);
	   Thread.sleep(4000);
	   ak.DS.BorrowerID=ak.EXTRCT("Borrower_ID");
	   ex.setcelldata(ak.DS.BorrowerID,18);
	   
	   ak.STOREWINDOWID();
	   ak.click("Helpdesk_Reassignment",null);
	   ak.click("RM_Search_icon", null);
	   ak.input("Grid_Search_Box", 20);
	   ak.ENTER("Grid_Search_Box");
	   Thread.sleep(2000);
	   ak.CLICKNEXTTEXTPATH1(20);
	   ak.click("Update_Comment", null);
	   Thread.sleep(3000);
	  
	   ak.SWITCHWINDOW();
	   ak.click("Confirmation_OK", null);
	   Thread.sleep(3000);
	   ak.SWICHTOPARENTWIN();
	   
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	
	   RRPLog.EndTestCase("TC14");	
}


}
