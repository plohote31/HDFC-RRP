package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Config.RRPActionKeywords;
import ExecutionScript.RRPDriverScript;
import Utility.RRPExcelUtility;
import Utility.RRPLog;

public class RRPExecutionTest3 {

	public static RRPExcelUtility ex;
	
	
	//Small Service Model
	public static void TC15() throws IOException, InterruptedException {
		//Small Service Model
		RRPLog.StartTestCase("TC15");
	    RRPActionKeywords ak=new RRPActionKeywords();
		   
		   ak.OPENBROWSER("Main_URL");
		   ak.navigate("Main_URL");
		   ak.input("Username", 2);
		   ak.input( "Password", 3);
		   ak.click("Login",null);
		   ak.navigate("Borrower_Homepage");
		   ak.ExWait("Borrower_ID_Search");
		   ak.input("Borrower_ID_Search", 4);  
		   Thread.sleep(3000);		   
		   ak.click("Search_Button", null);
		   Thread.sleep(3000);	
		   ak.click("Proceed_Button", null);
		   
		   ak.click("Rating_Initiation_Button", null);
			 Thread.sleep(3000);
			 ak.click("Click_Here_to_Fetch", null);
			 Thread.sleep(3000);
			 ak.click("Select_Year", null);
			 Thread.sleep(3000);
			 ak.click("Next_button", null);
			 Thread.sleep(3000);
			 
			 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
			   ak.ExWait("Select_Recommended_Model");
			   ak.click("smallservicesmodel", null);// Select Model
			   Thread.sleep(3000);
			   ak.click("Next", null);
			   Thread.sleep(3000);
		   
			   ak.ExWait("Financial_Risk");
			   ak.click("Financial_Risk", null);
			  // ak.click("Unsecured loans are subordinated to bank debt");
			   ak.ExWait("Unsecured_loans");
			   Thread.sleep(2000);
			  
			   ak.Select("Unsecured_loans",6);
			   Thread.sleep(2000);
			   ak.ExWait("Unsecured_loans_subordinated1");
			   ak.Clear("Unsecured_loans_subordinated1");
			   ak.input("Unsecured_loans_subordinated1", 7);
			  
			   ak.click("collapse_icon",null);
			   Thread.sleep(2000);
	 	   ak.click("collapse_icon",null);
	       Thread.sleep(2000);
	    ak.click("Ability_to_raise_funds",null);
		    Thread.sleep(2000);
		    ak.CLICKNEXTTEXTPATH(8);
		    ak.Select("Is_Foreign_Exchange_risk",9);	
		    ak.Clear("LL_EBID%");
		    ak.input("LL_EBID%",10);
		    ak.click("Business_Risk_Tab1",null);   
		    ak.click("Customer_Diversification",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(11);
		    ak.click("Product_Diversification",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(12);
		    ak.click("Distribution_network",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(13); 
		    ak.click("Brand_Equity",null);
		    Thread.sleep(3000);
		    //ak.CLICKNEXTTEXTPATH1(14);
		    ak.click("Brand_Equity1",null);
//		    Thread.sleep(3000);
		    
		    //ak.CLICKNEXTTEXTPATH1(14);
		    ak.click("Position_in_the_industry",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(15); 
		    ak.click("Management_Risk",null);
		    Thread.sleep(2000);
		    ak.click("Legal_Structure",null);
		    Thread.sleep(3000);
		    //ak.click("Legal_Structure1");
		    ak.CLICKNEXTTEXTPATH1(16);
		    ak.click("Track_Record",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(17);
		    ak.Clear("No_of_years_the_company_has_been_in_existence");
		    ak.input("No_of_years_the_company_has_been_in_existence",18);
		    ak.click("Management_Style",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(19);
		    ak.click("Corporate_governance",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(20);
		    ak.input("existence_for_Management_experience",21);
		    Thread.sleep(2000);
		    ak.click("Projections",null);
		    Thread.sleep(2000);
		    ak.Select("Projection_Applicable", 22);
		    Thread.sleep(2000);
		    ak.Clear("Projected_Revenue");
		    ak.input("Projected_Revenue",23);
		    Thread.sleep(2000);
		    ak.input("Projected_EBIDTA",24);
		    Thread.sleep(2000);
		    ak.input("Projected_TOL_TNW",25);
		    Thread.sleep(2000);
		    //ak.BorderHighlight("Save_Proceed");
		    ak.click("Save_Proceed",null);
		    Thread.sleep(2000);
		    //ak.STOREWINDOWID();
		    //ak.SWITCHWINDOW();
		    ak.ExWait("validation_close");
		    ak.click("validation_close",null);
		    ak.ExWait("summary_Downarrow");
		    ak.click("summary_Downarrow",null);
		   
		   Thread.sleep(3000);
	       ak.ExWait("Rating_Id");
		   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
		   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
		   ex.setcelldata(ak.DS.BorrowerID,26);
		   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
		   System.out.println("Status Code is"+ ak.DS.BorrowerID);
		   ex.setcelldata(ak.DS.BorrowerID,27); 

	    String temp=ak.PassScreenShot();
	    RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    RRPLog.EndTestCase("TC15");

		
		
	}

//Rating initiation on NBFC Model
public static void TC16() throws IOException, InterruptedException 
{
	//Rating initiation on NBFC Model
	
	   RRPLog.StartTestCase("TC16");
	   RRPActionKeywords ak=new RRPActionKeywords();

	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.ExWait("Borrower_ID_Search");
	   ak.input("Borrower_ID_Search", 4);  
	   Thread.sleep(3000);
	   
	   ak.click("Search_Button", null);
	   ak.click("Proceed_Button", null);
	   
	   ak.click("Rating_Initiation_Button", null);
		 Thread.sleep(3000);
		 ak.click("Click_Here_to_Fetch", null);
		 Thread.sleep(3000);
		 ak.click("Select_Year", null);
		 Thread.sleep(3000);
		 ak.click("Next_button", null);
		 Thread.sleep(3000);
		 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
		   ak.ExWait("Select_Recommended_Model");
		   ak.click("NBFC_NEW_model", null);// Select Model
		   Thread.sleep(3000);
		   ak.click("Next", null);
		   Thread.sleep(3000);
	    
		   ak.ExWait("Financial_Risk");
		   ak.click("Financial_Risk", null);
		   Thread.sleep(2000);
		   ak.click("Date_of_reference_data", null);
		   ak.input("Source",6);
		   Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.input("YTD_Equity_Infusion",7);
		  ak.input("Current_Year_Disbursements",8);
		  ak.input("YTD_Disbursements",9);
		  ak.input("YTD_Collections",10);
		  ak.input("Current_Year_Collections",11);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("YTD_Date_for_Borrowing_Current_Year", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.ExWait("YTD_Date_for_Borrowing_YTD");
		  ak.click("YTD_Date_for_Borrowing_YTD", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.input("Auto_Other_auto",12);
		  Thread.sleep(2000);
		  
		//Non Financial Risk 
			 
		  ak.ExWait("Non_Financial_Risk_Tab");
		  ak.click("Non_Financial_Risk_Tab", null);
		  Thread.sleep(2000);
		  ak.input("Experience_in_Lending_Business",13);
		  ak.click("Management_Competence", null);
		  ak.CLICKNEXTTEXTPATH1(14);
		  Thread.sleep(2000);
		
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("Credit_Underwriting", null);
		  ak.CLICKNEXTTEXTPATH1(15);
		  Thread.sleep(2000);
		 
		  
		  ak.click("Ownership", null);
		  ak.CLICKNEXTTEXTPATH1(16);
		  Thread.sleep(2000);
		  
		  
		  ak.click("Diversity_of_funding_profile", null);
		  ak.CLICKNEXTTEXTPATH1(17);
		  Thread.sleep(2000);
		  
		  
		  ak.click("Market_Position", null);
		  ak.CLICKNEXTTEXTPATH1(18);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  ak.click("collapse_icon", null);
		  Thread.sleep(2000);
		  
		  ak.click("AUM_Mix", null);
		  ak.CLICKNEXTTEXTPATH1(19);
		  Thread.sleep(2000);
		  
		  ak.click("Average_LTV", null);
		  ak.CLICKNEXTTEXTPATH1(20);
		  Thread.sleep(2000);
		  ak.click("Save_Proceed", null);       //Click on Save And Proceed
		  Thread.sleep(5000);
		  ak.ExWait("validation_close");
		  ak.click("validation_close", null);
		
       ak.ExWait("Rating_Id");
	   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
	   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,21);
	   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
	   System.out.println("Status Code is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,22); 
	   
	   Thread.sleep(2000);
	   String temp=ak.PassScreenShot();
	   RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	   RRPLog.EndTestCase("TC16");

}


//Rating initiation on Trader Model
public static void TC17() throws IOException, InterruptedException 
{
//Rating initiation on Trader Model
	   RRPLog.StartTestCase("TC33");
       RRPActionKeywords ak=new RRPActionKeywords();
	   
       ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.ExWait("Borrower_ID_Search");
	   ak.input("Borrower_ID_Search", 4);  
	   Thread.sleep(3000);		   
	   ak.click("Search_Button", null);
	   Thread.sleep(3000);	
	   ak.click("Proceed_Button", null);
	   
	   ak.click("Rating_Initiation_Button", null);
		 Thread.sleep(3000);
		 ak.click("Click_Here_to_Fetch", null);
		 Thread.sleep(3000);
		 ak.click("Select_Year", null);
		 Thread.sleep(3000);
		 ak.click("Next_button", null);
		 Thread.sleep(3000);
		 
		 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
		   ak.ExWait("Select_Recommended_Model");
		   ak.click("Trader_New_Model", null);// Select Model
		   Thread.sleep(3000);
		   ak.click("Next", null);
		   Thread.sleep(3000);
	   
		   ak.ExWait("Financial_Risk");
		   ak.click("Financial_Risk", null);
		  // ak.click("Unsecured loans are subordinated to bank debt");
		   ak.ExWait("Unsecured_loans");
		   Thread.sleep(2000);
		  
		   ak.Select("Unsecured_loans",6);
		   Thread.sleep(2000);
		   ak.ExWait("Unsecured_loans_subordinated1");
		   ak.Clear("Unsecured_loans_subordinated1");
		   ak.input("Unsecured_loans_subordinated1", 7);
		  
		   ak.click("collapse_icon",null);
		   Thread.sleep(2000);
 	   ak.click("collapse_icon",null);
       Thread.sleep(2000);
    ak.click("Ability_to_raise_funds",null);
	    Thread.sleep(2000);
	    ak.CLICKNEXTTEXTPATH(8);
	    ak.Select("Is_Foreign_Exchange_risk",9);	
	    ak.Clear("LL_EBID%");
	    ak.input("LL_EBID%",10);
	    ak.click("Business_Risk_Tab1",null);   
	    ak.click("Customer_Diversification",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(11);
	    ak.click("Product_Diversification",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(12);
	    ak.click("Position_in_the_industry_Trader",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(15); 
	    ak.click("Distribution_network",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(13); 
	    
	    ak.click("Brand_Equity",null);
	    Thread.sleep(3000);
	    //ak.CLICKNEXTTEXTPATH1(14);
	    ak.click("Brand_Equity1",null);
//	    Thread.sleep(3000);
//	    ak.PickerSelect("Brand_Equity",14);
	    
	    //ak.CLICKNEXTTEXTPATH1(14);
	   
	    ak.click("Management_Risk",null);
	    Thread.sleep(2000);
	    ak.click("Legal_Structure",null);
	    Thread.sleep(3000);
	    //ak.click("Legal_Structure1");
	    ak.CLICKNEXTTEXTPATH1(16);
	    Thread.sleep(2000);
	    ak.input("existence_for_Management_experience",21);
	    Thread.sleep(2000);
	    
	    ak.click("Track_Record",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(17);
	    ak.click("Composition_of_Management",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(26);
	    Thread.sleep(2000);
	    ak.input("No_of_years_the_company_has_been_in_existence",18);
	    
	    
	    ak.click("Management_Style",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(19);
	    ak.click("Corporate_governance",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(20);
	    ak.click("Projections_Trader",null);
	    Thread.sleep(2000);
	    ak.Select("Projection_Applicable", 22);
	    Thread.sleep(2000);
	    ak.Clear("Projected_Revenue");
	    ak.input("Projected_Revenue",23);
	    Thread.sleep(2000);
	    ak.input("Projected_Net_Profit_Trader",24);
	    Thread.sleep(2000);
	    //ak.input("Projected_EBIDTA",24);
	  //  Thread.sleep(2000);
	    ak.input("Projected_TOL_TNW",25);
	    Thread.sleep(2000);
	    //ak.BorderHighlight("Save_Proceed");
	    ak.click("Save_Proceed",null);
	    Thread.sleep(2000);
	    //ak.STOREWINDOWID();
	    //ak.SWITCHWINDOW();
	    ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	    
	    
	   Thread.sleep(3000);
       ak.ExWait("Rating_Id");
	   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
	   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,27);
	   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
	   System.out.println("Status Code is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,28); 

       String temp=ak.PassScreenShot();
       RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
       RRPLog.EndTestCase("TC17");
	   
}


//Small Manufacturing Model
public static void TC18() throws IOException, InterruptedException {
	//Small Service Model
	RRPLog.StartTestCase("TC18");
    RRPActionKeywords ak=new RRPActionKeywords();
	   
	   ak.OPENBROWSER("Main_URL");
	   ak.navigate("Main_URL");
	   ak.input("Username", 2);
	   ak.input( "Password", 3);
	   ak.click("Login",null);
	   ak.navigate("Borrower_Homepage");
	   ak.ExWait("Borrower_ID_Search");
	   ak.input("Borrower_ID_Search", 4);  
	   Thread.sleep(3000);		   
	   ak.click("Search_Button", null);
	   Thread.sleep(3000);	
	   ak.click("Proceed_Button", null);
	   
	   ak.click("Rating_Initiation_Button", null);
		 Thread.sleep(3000);
		 ak.click("Click_Here_to_Fetch", null);
		 Thread.sleep(3000);
		 ak.click("Select_Year", null);
		 Thread.sleep(3000);
		 ak.click("Next_button", null);
		 Thread.sleep(3000);
		 
		 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
		   ak.ExWait("Select_Recommended_Model");
		   ak.click("SmallManufacturing_Model", null);// Select Model
		   Thread.sleep(3000);
		   ak.click("Next", null);
		   Thread.sleep(3000);
	   
		   ak.ExWait("Financial_Risk");
		   ak.click("Financial_Risk", null);
		  // ak.click("Unsecured loans are subordinated to bank debt");
		   ak.ExWait("Unsecured_loans");
		   Thread.sleep(2000);
		  
		   ak.Select("Unsecured_loans",6);
		   Thread.sleep(2000);
		   ak.ExWait("Unsecured_loans_subordinated1");
		   ak.Clear("Unsecured_loans_subordinated1");
		   ak.input("Unsecured_loans_subordinated1", 7);
		  
		   ak.click("collapse_icon",null);
		   Thread.sleep(2000);
 	   ak.click("collapse_icon",null);
       Thread.sleep(2000);
    ak.click("Ability_to_raise_funds",null);
	    Thread.sleep(2000);
	    ak.CLICKNEXTTEXTPATH(8);
	    ak.Select("Is_Foreign_Exchange_risk",9);	
	    ak.Clear("LL_EBID%");
	    ak.input("LL_EBID%",10);
	    ak.click("Business_Risk_Tab1",null);   
	    ak.click("Customer_Diversification",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(11);
	    ak.click("Product_Diversification",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(12);
	    ak.click("Distribution_network",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(13); 
	    ak.click("Brand_Equity",null);
	    Thread.sleep(3000);
	    //ak.CLICKNEXTTEXTPATH1(14);
	    ak.click("Brand_Equity1",null);
//	    Thread.sleep(3000);
	    
	    //ak.CLICKNEXTTEXTPATH1(14);
	    ak.click("Position_in_the_industry",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(15); 
	    ak.click("Management_Risk",null);
	    Thread.sleep(2000);
	    ak.click("Legal_Structure",null);
	    Thread.sleep(3000);
	    //ak.click("Legal_Structure1");
	    ak.CLICKNEXTTEXTPATH1(16);
	    ak.click("Track_Record",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(17);
	    ak.Clear("No_of_years_the_company_has_been_in_existence");
	    ak.input("No_of_years_the_company_has_been_in_existence",18);
	    ak.click("Management_Style",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(19);
	    ak.click("Corporate_governance",null);
	    Thread.sleep(3000);
	    ak.CLICKNEXTTEXTPATH1(20);
	    ak.input("existence_for_Management_experience",21);
	    Thread.sleep(2000);
	    ak.click("Projections",null);
	    Thread.sleep(2000);
	    ak.Select("Projection_Applicable", 22);
	    Thread.sleep(2000);
	    ak.Clear("Projected_Revenue");
	    ak.input("Projected_Revenue",23);
	    Thread.sleep(2000);
	    ak.input("Projected_EBIDTA",24);
	    Thread.sleep(2000);
	    ak.input("Projected_TOL_TNW",25);
	    Thread.sleep(2000);
	    //ak.BorderHighlight("Save_Proceed");
	    ak.click("Save_Proceed",null);
	    Thread.sleep(2000);
	    //ak.STOREWINDOWID();
	    //ak.SWITCHWINDOW();
	    ak.ExWait("validation_close");
	    ak.click("validation_close",null);
	    
	    
	   Thread.sleep(3000);
       ak.ExWait("Rating_Id");
	   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
	   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,26);
	   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
	   System.out.println("Status Code is"+ ak.DS.BorrowerID);
	   ex.setcelldata(ak.DS.BorrowerID,27); 

    String temp=ak.PassScreenShot();
    RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
    RRPLog.EndTestCase("TC18");

	
	
}

	//Large Manufacturing Model
	public static void TC19() throws IOException, InterruptedException {
		//Large Manufacturing Model
		RRPLog.StartTestCase("TC19");
	    RRPActionKeywords ak=new RRPActionKeywords();
		   
		   ak.OPENBROWSER("Main_URL");
		   ak.navigate("Main_URL");
		   ak.input("Username", 2);
		   ak.input( "Password", 3);
		   ak.click("Login",null);
		   ak.navigate("Borrower_Homepage");
		   ak.ExWait("Borrower_ID_Search");
		   ak.input("Borrower_ID_Search", 4);  
		   Thread.sleep(3000);		   
		   ak.click("Search_Button", null);
		   Thread.sleep(3000);	
		   ak.click("Proceed_Button", null);
		   
		   ak.click("Rating_Initiation_Button", null);
			 Thread.sleep(3000);
			 ak.click("Click_Here_to_Fetch", null);
			 Thread.sleep(3000);
			 ak.click("Select_Year", null);
			 Thread.sleep(3000);
			 ak.click("Next_button", null);
			 Thread.sleep(3000);
			 
			 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
			 Thread.sleep(2000);
			 ak.Select("model_change", "Yes");
			 Thread.sleep(2000);
			 ak.inputwithdata("Reason_for_Alt_Model", "Model change is required");
			 Thread.sleep(2000);
			 ak.click("Select_Available_Models", null);
			 
			   ak.ExWait("Large_Manufacturing_Model");
			   ak.click("Large_Manufacturing_Model", null);// Select Model
			   Thread.sleep(3000);
			   ak.click("Next", null);
			   Thread.sleep(3000);
		   
			   ak.ExWait("Financial_Risk");
			   ak.click("Financial_Risk", null);
			  // ak.click("Unsecured loans are subordinated to bank debt");
			   ak.ExWait("Unsecured_loans");
			   Thread.sleep(2000);
			  
			   ak.Select("Unsecured_loans",6);
			   Thread.sleep(2000);
			   ak.ExWait("Unsecured_loans_subordinated1");
			   ak.Clear("Unsecured_loans_subordinated1");
			   ak.input("Unsecured_loans_subordinated1", 7);
			  
			   ak.click("collapse_icon",null);
			   Thread.sleep(2000);
	 	   ak.click("collapse_icon",null);
	       Thread.sleep(2000);
	    ak.click("Ability_to_raise_funds",null);
		    Thread.sleep(2000);
		    ak.CLICKNEXTTEXTPATH(8);
		    ak.Select("Is_Foreign_Exchange_risk",9);	
		    ak.Clear("LL_EBID%");
		    ak.input("LL_EBID%",10);
		    ak.click("Business_Risk_Tab1",null);   
		    ak.click("Customer_Diversification",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(11);
		    ak.click("Product_Diversification",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(12);
		    ak.click("Distribution_network",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(13); 
		    ak.click("Brand_Equity",null);
		    Thread.sleep(3000);
		    //ak.CLICKNEXTTEXTPATH1(14);
		    ak.click("Brand_Equity1",null);
	        Thread.sleep(3000);
		    
		    //ak.CLICKNEXTTEXTPATH1(14);
		    ak.click("Position_in_the_industry_LM",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(15);
		    ak.click("Supply_chain_management",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(28);
		    ak.click("Management_Risk",null);
		    Thread.sleep(2000);
		    ak.click("Legal_Structure",null);
		    Thread.sleep(3000);
		    //ak.click("Legal_Structure1");
		    ak.CLICKNEXTTEXTPATH1(16);
		    ak.click("Track_Record",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(17);
		    ak.click("Composition_of_Management", null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(29);
		    ak.Clear("No_of_years_the_company_has_been_in_existence");
		    ak.input("No_of_years_the_company_has_been_in_existence",18);
		    ak.click("Management_Style",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(19);
		    ak.click("Corporate_governance",null);
		    Thread.sleep(3000);
		    ak.CLICKNEXTTEXTPATH1(20);
		    ak.input("existence_for_Management_experience",21);
		    Thread.sleep(2000);
		    ak.click("Projections",null);
		    Thread.sleep(2000);
		    ak.Select("Projection_Applicable", 22);
		    Thread.sleep(2000);
		    ak.Clear("Projected_Revenue");
		    ak.input("Projected_Revenue",23);
		    Thread.sleep(2000);
		    ak.input("Projected_EBIDTA",24);
		    Thread.sleep(2000);
		    ak.input("Projected_TOL_TNW",25);
		    Thread.sleep(2000);
		    //ak.BorderHighlight("Save_Proceed");
		    ak.click("Save_Proceed",null);
		    Thread.sleep(2000);
		    //ak.STOREWINDOWID();
		    //ak.SWITCHWINDOW();
		    ak.ExWait("validation_close");
		    ak.click("validation_close",null);
		    ak.ExWait("summary_Downarrow");
		    ak.click("summary_Downarrow", null);
		    			   
		   Thread.sleep(3000);
	       ak.ExWait("Rating_Id");
		   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
		   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
		   ex.setcelldata(ak.DS.BorrowerID,26);
		   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
		   System.out.println("Status Code is"+ ak.DS.BorrowerID);
		   ex.setcelldata(ak.DS.BorrowerID,27); 

	    String temp=ak.PassScreenShot();
	    RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    RRPLog.EndTestCase("TC19");
	}
	
	//Large Service Model
			public static void TC20() throws IOException, InterruptedException {
				//Large service Model
				RRPLog.StartTestCase("TC20");
			    RRPActionKeywords ak=new RRPActionKeywords();
				   
				   ak.OPENBROWSER("Main_URL");
				   ak.navigate("Main_URL");
				   ak.input("Username", 2);
				   ak.input( "Password", 3);
				   ak.click("Login",null);
				   ak.navigate("Borrower_Homepage");
				   ak.ExWait("Borrower_ID_Search");
				   ak.input("Borrower_ID_Search", 4);  
				   Thread.sleep(3000);		   
				   ak.click("Search_Button", null);
				   Thread.sleep(3000);	
				   ak.click("Proceed_Button", null);
				   
				   ak.click("Rating_Initiation_Button", null);
					 Thread.sleep(3000);
					 ak.click("Click_Here_to_Fetch", null);
					 Thread.sleep(3000);
					 ak.click("Select_Year", null);
					 Thread.sleep(3000);
					 ak.click("Next_button", null);
					 Thread.sleep(3000);
					 
					 ak.click("Recommended_Models", null);    // Click hear to fetch presenter on screen 2
					 Thread.sleep(2000);
					 ak.Select("model_change", "Yes");
					 Thread.sleep(2000);
					 ak.inputwithdata("Reason_for_Alt_Model", "Model change is required");
					 Thread.sleep(2000);
					 ak.click("Select_Available_Models", null);
					 
					   ak.ExWait("Large_Manufacturing_Model");
					   ak.click("Large_Manufacturing_Model", null);// Select Model
					   Thread.sleep(3000);
					   ak.click("Next", null);
					   Thread.sleep(3000);
				   
					   ak.ExWait("Financial_Risk");
					   ak.click("Financial_Risk", null);
					  // ak.click("Unsecured loans are subordinated to bank debt");
					   ak.ExWait("Unsecured_loans");
					   Thread.sleep(2000);
					  
					   ak.Select("Unsecured_loans",6);
					   Thread.sleep(2000);
					   ak.ExWait("Unsecured_loans_subordinated1");
					   ak.Clear("Unsecured_loans_subordinated1");
					   ak.input("Unsecured_loans_subordinated1", 7);
					  
					   ak.click("collapse_icon",null);
					   Thread.sleep(2000);
			 	   ak.click("collapse_icon",null);
			       Thread.sleep(2000);
			    ak.click("Ability_to_raise_funds",null);
				    Thread.sleep(2000);
				    ak.CLICKNEXTTEXTPATH(8);
				    ak.Select("Is_Foreign_Exchange_risk",9);	
				    ak.Clear("LL_EBID%");
				    ak.input("LL_EBID%",10);
				    ak.click("Business_Risk_Tab1",null);   
				    ak.click("Customer_Diversification",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(11);
				    ak.click("Product_Diversification",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(12);
				    ak.click("Distribution_network",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(13); 
				    ak.click("Brand_Equity",null);
				    Thread.sleep(3000);
				    //ak.CLICKNEXTTEXTPATH1(14);
				    ak.click("Brand_Equity1",null);
			        Thread.sleep(3000);
				    
				    //ak.CLICKNEXTTEXTPATH1(14);
				    ak.click("Position_in_the_industry_LM",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(15);
				    ak.click("Supply_chain_management",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(28);
				    ak.click("Management_Risk",null);
				    Thread.sleep(2000);
				    ak.click("Legal_Structure",null);
				    Thread.sleep(3000);
				    //ak.click("Legal_Structure1");
				    ak.CLICKNEXTTEXTPATH1(16);
				    ak.click("Track_Record",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(17);
				    ak.click("Composition_of_Management", null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(29);
				    ak.Clear("No_of_years_the_company_has_been_in_existence");
				    ak.input("No_of_years_the_company_has_been_in_existence",18);
				    ak.click("Management_Style",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(19);
				    ak.click("Corporate_governance",null);
				    Thread.sleep(3000);
				    ak.CLICKNEXTTEXTPATH1(20);
				    ak.input("existence_for_Management_experience",21);
				    Thread.sleep(2000);
				    ak.click("Projections",null);
				    Thread.sleep(2000);
				    ak.Select("Projection_Applicable", 22);
				    Thread.sleep(2000);
				    ak.Clear("Projected_Revenue");
				    ak.input("Projected_Revenue",23);
				    Thread.sleep(2000);
				    ak.input("Projected_EBIDTA",24);
				    Thread.sleep(2000);
				    ak.input("Projected_TOL_TNW",25);
				    Thread.sleep(2000);
				    //ak.BorderHighlight("Save_Proceed");
				    ak.click("Save_Proceed",null);
				    Thread.sleep(2000);
				    //ak.STOREWINDOWID();
				    //ak.SWITCHWINDOW();
				    ak.ExWait("validation_close");
				    ak.click("validation_close",null);
				    ak.ExWait("summary_Downarrow");
				    ak.click("summary_Downarrow", null);
				    			   
				   Thread.sleep(3000);
			       ak.ExWait("Rating_Id");
				   ak.DS.BorrowerID=ak.EXTRCT("Rating_Id");
				   System.out.println("Rating ID is"+ ak.DS.BorrowerID);
				   ex.setcelldata(ak.DS.BorrowerID,26);
				   ak.DS.BorrowerID=ak.EXTRCT("Status_Code");
				   System.out.println("Status Code is"+ ak.DS.BorrowerID);
				   ex.setcelldata(ak.DS.BorrowerID,27); 

			    String temp=ak.PassScreenShot();
			    RRPDriverScript.ExtentTest.log(Status.PASS, RRPDriverScript.TestCaseIDName+" "+" "+RRPDriverScript.TestCaseDes+" is passed successfully  ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			    RRPLog.EndTestCase("TC20");
			}

}

