package Utility;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

import Config.RRPActionKeywords;

import ExecutionScript.RRPDriverScript;

public class RRPLog {
	
	

	private static org.apache.log4j.Logger Log=LogManager.getLogger(RRPLog.class.getName());
	 
	 public static void StartTestCase(String TestCaseID) {
		 RRPDriverScript.ExtentTest=RRPDriverScript.extent.createTest(RRPDriverScript.TestCaseIDName+" "+RRPDriverScript.TestCaseDes+" "+RRPDriverScript.TypeofBorrower);
			
		 Log.info("****************************Start of " +TestCaseID+"*********************************");
		 
	 }
	 
	 public static void EndTestCase(String TestCaseID) {
		 RRPActionKeywords ak= new RRPActionKeywords();
		 Log.info("****************************End of" +TestCaseID+"*********************************");
		
		 RRPDriverScript.extent.flush();
		 
		 ak.driver.quit();
	 }
	 public static void info(String message) {
			
	
			Log.info(RRPDriverScript.TestCaseIDName+" "+message);
		 
			//RDriverScript.ExtentTest.log(Status.PASS,message);
		
			
		}
	
	public static void Error(String message) {
		
		Log.error(RRPDriverScript.TestCaseIDName+" "+message);
		RRPDriverScript.ExtentTest.log(Status.FAIL,message );
	
		
		
	}
}
