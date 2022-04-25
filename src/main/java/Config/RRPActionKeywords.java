package Config;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ExecutionScript.RRPDriverScript;
import Utility.RRPExcelUtility;
import Utility.RRPLog;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class RRPActionKeywords {


public static WebDriver driver;
public static WebElement element;
public static RRPDriverScript DS;
public static RRPConstants RRPConst;
public static String parentwindow;
public static boolean akFlag = true;
public static String resultFlag;
public static JavascriptExecutor je;


public static String ResultFlag() throws Exception {

	// System.out.println("FLAGE - "+akFlag);
	// System.out.println("Rflage - "+resultFlag);
try {
	if (akFlag == true) {
		
		resultFlag = RRPConstants.KEYWORD_PASS;
		 System.out.println("KEYWORD_PASS - "+akFlag);
			

		} else {
		
			 resultFlag = RRPConstants.KEYWORD_FAIL;
			 System.out.println("KEYWORD_FAIL - "+akFlag);
		}

	
	return resultFlag;
}catch (Exception e) {
	return "";
}

}

	public static void OPENBROWSER(String object) throws IOException, InterruptedException
	{
	
		try {
			
			DesiredCapabilities ch=DesiredCapabilities.chrome();
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions c=new ChromeOptions();
			c.merge(ch);
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\HDFC_RRP_NEW_MODELS\\RRP_Auto_BorrowerCreation_00\\chromedriver.exe");
			driver=new ChromeDriver(c);
			driver.manage().window().maximize();
			RRPLog.info("Opening Browser"+object);
			DS.ExtentTest.log(Status.PASS, "Browser Opened");
		
			akFlag = true;
			
		} catch (Exception e) 
		{
			
			RRPLog.Error("Browser is not opened "+object+e.getMessage() );
			
		
			ScreenShot(object);
			akFlag = false;
		}	
	}
	public void close() {
		driver.close();
	}
	
	public static void input(String object ,int ColNum) throws IOException, InterruptedException
	{
	try {
		ExWait(object);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	BorderHighlight(object);
		driver.findElement(By.xpath(RRPDriverScript.OR.getProperty(object))).sendKeys(RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum, DS.SheetName));
	
	RRPLog.info("Entering input into "+ object);
	DS.ExtentTest.log(Status.PASS, "Data entered sucessfully in "+object);
	
	akFlag = true;	
	} catch (Exception e)
	{
		RRPLog.Error("Not able enter text in "+object + e);
		
		ScreenShot(object);
	}
		 
		
	}
	
	public static void inputwithdata(String object ,String data) throws IOException, InterruptedException
	{
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	BorderHighlight(object);
		driver.findElement(By.xpath(RRPDriverScript.OR.getProperty(object))).sendKeys(data);
	RRPLog.info("Entering input into "+ object);
	DS.ExtentTest.log(Status.PASS, "Data entered sucessfully in "+object);
	akFlag = true;
	} catch (Exception e)
	{
		RRPLog.Error("Not able enter text in "+object + e);
		ScreenShot(object);
		akFlag = false;
	}
		 
		
	}
	
	
	
	
	

	public static void  click(String  object, String data ) throws IOException, InterruptedException
	{
		 je = (JavascriptExecutor) driver;
	try {
		ExWait(object);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element=driver.findElement(By.xpath(DS.OR.getProperty(object)));
		
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	    element.click();
	    RRPLog.info( object+ " Clicked Successfully");
		DS.ExtentTest.log(Status.PASS, "Clicked sucessfully on "+object);
	    akFlag = true;
	}
	catch(Exception e) {
		RRPLog.Error("Not able to click on "+object+e.getMessage());
		RRPLog.Error(object+ " not able to click due to "+ e);
		ScreenShot(object);
		akFlag = false;
	}
		
		
		
	}
	
	public static void navigate(String object) throws IOException, InterruptedException 
	{
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(RRPDriverScript.OR.getProperty(object));
			DS.ExtentTest.log(Status.PASS, "Sucessfully navigated to "+object);
			akFlag = true;
		}catch(Exception e) {
			RRPLog.Error("Not able to open " +object+" "+e.getMessage());
			ScreenShot(object);
			akFlag = false;
		}
		
	}

	public static void ScreenShot(String object) throws IOException, InterruptedException
	{
		try {
			
		
		String SD = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		String ScreenShotPath=DS.FailedScreenShotFolder+"\\"+" "+DS.TestCaseDes+" "+DS.TypeofBorrower+SD+".jpeg";
		//String ScreenShotPath="./target/Failscreenshots/"+DS.TestCaseDes+DS.FailedScreenShot+".jpeg";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		DS.ExtentTest.log(Status.FAIL, DS.TestCaseIDName+" "+" "+DS.TestCaseDes+"   ",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotPath).build());
		}catch(Exception e){
			
			RRPLog.Error("Not able to take screenshot due to "+e.getMessage());
		}
		
	}
	
	public static String PassScreenShot() throws IOException, InterruptedException
	{
		
		/*TakesScreenshot scrShot=((TakesScreenshot)driver);
		File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, new File("./target/Failscreenshots/"+object+".jpeg"));*/
		String ScreenShotPath=DS.ScreenShotFolder+"\\"+" "+DS.TestCaseDes+" "+DS.TypeofBorrower+".jpeg";
		
		//String ScreenShotPath="./target/Passcreenshots/"+DS.TestCaseDes+DS.PassScreenShot+".jpeg";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		
		/*byte[] imagebyte=IOUtils.toByteArray(new FileInputStream(ScreenShotPath));
		return Base64.getEncoder().encodeToString(imagebyte);*/
		return ScreenShotPath;
		
	}
	public static String FailScreenShot() throws IOException, InterruptedException
	{
		
		/*TakesScreenshot scrShot=((TakesScreenshot)driver);
		File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, new File("./target/Failscreenshots/"+object+".jpeg"));*/
		
		String ScreenShotPath=DS.FailedScreenShotFolder+"\\"+" "+DS.TestCaseDes+" "+DS.TypeofBorrower+".jpeg";
		//String ScreenShotPath="./target/Failscreenshots/"+DS.TestCaseDes+DS.FailedScreenShot+".jpeg";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		
		/*byte[] imagebyte=IOUtils.toByteArray(new FileInputStream(ScreenShotPath));
		return Base64.getEncoder().encodeToString(imagebyte);*/
		return ScreenShotPath;
	}
	
	public static void BorderHighlight(String object)
	{
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		JavascriptExecutor js= (JavascriptExecutor)augmentedDriver;
		js.executeScript("arguments[0].setAttribute('style','border: solid 3px red');", DS.OR.getProperty(object));
	}
	
	
	public static void Tab(String object) 
	{
		try{
			ExWait(object);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	
		driver.findElement(By.xpath(DS.OR.getProperty(object))).sendKeys(Keys.TAB);
		}catch(Exception e) {
			
			RRPLog.Error("Unable to tab " +object+" "+ e.getMessage());
		}
	}
	public static String GetText(String object) 
	{
		try{
			ExWait(object);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		je = (JavascriptExecutor) driver;
		element=driver.findElement(By.xpath(DS.OR.getProperty(object)));

		je.executeScript("arguments[0].scrollIntoView(true);", element);
		
		String Objecttext=element.getText();
	
		RRPLog.info("Text extracted from "+object);
		DS.ExtentTest.log(Status.PASS, "Sucessfully Extracted text from "+object);
		return Objecttext;
		}catch(Exception e) {
		
			RRPLog.Error("Not able to get text from "+object);
			return "";
		}
		
	
	}
	public static boolean IsDisplyed(String object)
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	try {
		element=driver.findElement(By.xpath(DS.OR.getProperty(object)));
		return element.isDisplayed();
	}catch(Exception e) {
		
		return false;
	}
	
	}
	public static void Clear(String object) 
	{
		try{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(DS.OR.getProperty(object))).clear();
		}catch(Exception e){
			RRPLog.Error("Not able to clear due to "+e.getMessage());
		}
		
	}
	
	public static void ENTER(String object) 
	{
		try {
			ExWait(object);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath(DS.OR.getProperty(object))).sendKeys(Keys.ENTER);
		}catch(Exception e) {
			
		}
	}
	
	
	public static void AlertHandle(String action) {
		try {
			
			if(action.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
				RRPLog.info("Alert accepted succesfully");
				DS.ExtentTest.log(Status.PASS, "Alert accepted succesfully");
			}else if(action.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();
				RRPLog.Error("Alert dismissed succesfully");
			}
			akFlag = true;
		}catch(Exception e){
			RRPLog.info("Not able to clicked on alert due to "+e.getMessage());
			
			akFlag = false;
		}
		
		
	}
	
    public static void Select(String object,int ColNum) throws IOException, InterruptedException
    {
            
            try {
            	ExWait(object);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RRPDriverScript.OR.getProperty(object))));
            
        element = driver.findElement(By.xpath(RRPDriverScript.OR.getProperty(object)));
        String data=RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum, DS.SheetName);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        Select sel=new Select(element);
            sel.selectByVisibleText(data);
            RRPLog.info("Sucessfully selected value "+data+"in"+object);
            akFlag = true;
            }catch(Exception e){
            
            RRPLog.info("Not Able to select data in "+ object +e.getMessage());        
            ScreenShot(object);        
            akFlag = false;
            }
    }	
	public static void PickerSelect(String object,int ColNum) throws IOException, InterruptedException 
	{
		
		String data=RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum, DS.SheetName);
		try{
			ExWait(object);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			element = driver.findElement(By.xpath("//td[contains(text(),'"+data+"')]"));
		Thread.sleep(4000);
		element.click();
		RRPLog.info("Selected "+data);
		DS.ExtentTest.log(Status.PASS, "Sucessfully selected value "+data+" in "+object);
		akFlag = true;
		}
		catch(Exception e) {
			ScreenShot(object);
			RRPLog.Error("Not able to select "+data+e.getMessage());
			akFlag = false;
		}
	}
	
public static void CLICKNEXTTEXTPATH1(int ColNum) throws InterruptedException {
	
	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String data=RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum, DS.SheetName);
		try {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		
		
			element = driver.findElement(By.xpath(".//*[contains(@title,'" + data + "')]"));
			//je.executeScript("arguments[0].scrollIntoView(true);", element);
		
			ExWait(element);
			
			
		    element.click();
			RRPLog.info("Element Clicked Sucessfully "+data);
			DS.ExtentTest.log(Status.PASS, "Element Clicked Sucessfully "+data);
			akFlag = true;
		} catch (Exception e) {
			
			 
		            
			RRPLog.Error("Element is not clicked, "+ e.getMessage());
			akFlag = false;
		}
		
		
	}
	
public static void CLICKNEXTTEXTPATH(int ColNum) throws InterruptedException {
	
	
	JavascriptExecutor je = (JavascriptExecutor) driver;

	String data=RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum, DS.SheetName);
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		element = driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
	    //WebDriverWait wait = new WebDriverWait(driver,60);
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RRPDriverScript.OR.getProperty(data))));
	    element.click();
	    RRPLog.info("Element Clicked Sucessfully "+data);
		DS.ExtentTest.log(Status.PASS, "Element Clicked Sucessfully "+data);
		akFlag = true;
	} catch (Exception e) {
		
		
		RRPLog.Error("Element is not clicked "+ e.getMessage());
		akFlag = false;
	}
	
	
}




public String EXTRCT(String object) {
	try {
		ExWait(object);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		element=driver.findElement(By.xpath(DS.OR.getProperty(object)));
		
		String Result=element.getText();
		RRPLog.info("Sucessfully extracted value ");
		DS.ExtentTest.log(Status.PASS, "Sucessfully extracted value "+object);
		akFlag = true;
		return Result;
		
	}catch(Exception e) {
		RRPLog.info("Not able to extract value "+e.getMessage());
		akFlag = false;
		return "";
	}
	
}
	
public static void STOREWINDOWID() {
	
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		parentwindow=driver.getWindowHandle();
		RRPLog.info("Parent window is stored as "+parentwindow);
		
		
	}catch(Exception e) {
		RRPLog.Error("Not able to store parent window "+e.getMessage());
	}
	
}
	
public static void SWITCHWINDOW() {
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(String winhandle:driver.getWindowHandles()) {
			driver.switchTo().window(winhandle);
			RRPLog.info("Swiched to window name"+driver.getTitle()+" with id "+winhandle );
			
		}
		
	}catch(Exception e) {
		RRPLog.Error("Not able switch window "+e.getMessage());
	}
		
}


public static void SWICHTOPARENTWIN() {
	
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().window(parentwindow);
		RRPLog.info("Swiched to parent window "+driver.getTitle()+" with ID "+parentwindow);
		
	}catch(Exception e) {
		RRPLog.Error("Not able to switch to parent window "+e.getMessage());
	}

}


	public static void FILEUPLOADROBO(String object,String filepath) {
	
	try{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Robot robo=new Robot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*element=driver.findElement(By.xpath(object));
		robo.setAutoDelay(3000);
		element.click();*/

		robo.setAutoDelay(3000);
		StringSelection StringSel= new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSel, null);
		
		robo.setAutoDelay(3000);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		
		RRPLog.info("File uploaded succesfully");
		DS.ExtentTest.log(Status.PASS, "File uploaded succesfully");
		akFlag = true;
	}catch(Exception e) {
		RRPLog.Error("File not uploaded "+e.getMessage());
		akFlag = false;
	}	
}


	public static void WriteBorrowerID(String Result) throws IOException {
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("value to be write is "+Result);
	String	BorrowerType=DS.ex.GetCellData(DS.initialTestCase, RRPConstants.BorrowerTypeCol, DS.SheetName);

	System.out.println("Borrower Type is = "+BorrowerType);
	if(BorrowerType.equalsIgnoreCase("Services")) {
	
		/*DS.ex.SetExcelFile(Constants.ServiceFilePath);
		System.out.println("Setfilepath " +Constants.ServiceFilePath);
		System.out.println(ExcelUtility.workbook.getSheet(Constants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, Constants.BorrowerFinancialRowNum, Constants.BorrowerFinancialColNum, Constants.FianncialSheetName,Constants.ServiceFilePath);
		DS.ex.CloseExcel();*/
		
		DS.ex.SetExcelFile(RRPConstants.ServiceFilePath);
		System.out.println("Setfilepath " +RRPConstants.ServiceFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		System.out.println("value to be write is "+Result);
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.ServiceFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
	

	}else if(BorrowerType.equalsIgnoreCase("NBFC")) {
		//brokercode
		
		DS.ex.SetExcelFile(RRPConstants.NBFCFilePath);
		System.out.println("Setfilepath " +RRPConstants.NBFCFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.NBFCFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
		
	}else if(BorrowerType.equalsIgnoreCase("Manufacturing")) {
		//brokercode
		
		DS.ex.SetExcelFile(RRPConstants.SmallManufacturingFilePath);
		System.out.println("Setfilepath " +RRPConstants.SmallManufacturingFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.SmallManufacturingFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
		
	}else if(BorrowerType.equalsIgnoreCase("Large Manufacturing")) {
		//brokercode
		
		DS.ex.SetExcelFile(RRPConstants.LargeManufacturingFilePath);
		System.out.println("Setfilepath " +RRPConstants.LargeManufacturingFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.LargeManufacturingFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
		
	}else if(BorrowerType.equalsIgnoreCase("Large Services")) {
		//brokercode
		
		DS.ex.SetExcelFile(RRPConstants.LargeServiceFilePath);
		System.out.println("Setfilepath " +RRPConstants.LargeServiceFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.LargeServiceFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
		
	}else if(BorrowerType.equalsIgnoreCase("Trader")) {
	
		
		DS.ex.SetExcelFile(RRPConstants.TraderFilePath);
		System.out.println("Setfilepath " +RRPConstants.TraderFilePath);
		System.out.println(RRPExcelUtility.workbook.getSheet(RRPConstants.FianncialSheetName));
		DS.ex.setcelldatawithrow(Result, RRPConstants.BorrowerFinancialRowNum, RRPConstants.BorrowerFinancialColNum, RRPConstants.FianncialSheetName,RRPConstants.TraderFilePath);
		DS.ex.CloseExcel();
		DS.ex.SetExcelFile(RRPConstants.Path_Excel);
	}
	
	
	
	
	}

	
public static String RatingFinancialpath() {
		
		String	BorrowerType=RRPDriverScript.ex.GetCellData(RRPDriverScript.initialTestCase, RRPConstants.BorrowerTypeCol, RRPDriverScript.SheetName);
		if(BorrowerType.equalsIgnoreCase("Services")){
			RRPConstants.FinancialSpreadFilePath=RRPConstants.ServiceFilePath;
			return RRPConstants.FinancialSpreadFilePath;
			
		}if(BorrowerType.equalsIgnoreCase("Manufacturing")){
			RRPConstants.FinancialSpreadFilePath=RRPConstants.SmallManufacturingFilePath;
			return RRPConstants.FinancialSpreadFilePath;
			
		}if(BorrowerType.equalsIgnoreCase("Large Manufacturing")){
			RRPConstants.FinancialSpreadFilePath=RRPConstants.LargeManufacturingFilePath;
			return RRPConstants.FinancialSpreadFilePath;
			
		}if(BorrowerType.equalsIgnoreCase("Large Services")){
			RRPConstants.FinancialSpreadFilePath=RRPConstants.LargeServiceFilePath;
			return RRPConstants.FinancialSpreadFilePath;
			
		}
		else if (BorrowerType.equalsIgnoreCase("NBFC")) {
			RRPConstants.FinancialSpreadFilePath=RRPConstants.NBFCFilePath;
			return RRPConstants.FinancialSpreadFilePath;
	
		}else if (BorrowerType.equalsIgnoreCase("Trader")){
			RRPConstants.FinancialSpreadFilePath=RRPConstants.TraderFilePath;
			return RRPConstants.FinancialSpreadFilePath;
		}
		return "";
	
}

  public static void ValidateString(String actual,String expected) 
{
try {
	boolean fg=actual.equalsIgnoreCase(expected);
	//akFlag = true;
	if(fg==false) {
		
		System.out.println("String not matched Actual "+actual+ " and Expected "+expected);
		akFlag = false;
	
		RRPLog.Error("String not matching :"+actual);
		
	
	   }
	
}catch(Exception e) {
	
	RRPLog.info("String matched sucessfully :"+actual);
	DS.ExtentTest.log(Status.PASS, "String matched sucessfully :"+actual);
}
	
}


  public static void ExWait(String object) throws IOException, InterruptedException
  {
  try {        
          WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RRPDriverScript.OR.getProperty(object))));
      akFlag = true;
      }
  catch(Exception e){
          RRPLog.info("Not able to wait for "+object+e.getMessage());
          ScreenShot(object);
          akFlag = false;
  }
  } 
  public static void ExWait(WebElement element) throws IOException, InterruptedException
  {
  try {        
          WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.elementToBeClickable(element));
      akFlag = true;
      }
  catch(Exception e){
          RRPLog.info("Not able to wait for "+element+e.getMessage());
        
          akFlag = false;
  }
          
  }

  public static void FinacialSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	
	  RRPDriverScript.finsheetrow= RRPDriverScript.finsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.finsheetrow;k<= RRPDriverScript.finsheetrow;k++) {
	
	  DS.ex.setcelldatawithrow("TC07",k,0,RRPConstants.FinancialUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.FinancialUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.FinancialUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.FinancialUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.FinancialUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.FinancialUpload,RRPConstants.Path_Excel); 
	  
	  
	  }
  }
  
  
  public static void DocSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.docsheetrow= RRPDriverScript.docsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.docsheetrow;k<= RRPDriverScript.docsheetrow;k++) {
		  
	  
	  DS.ex.setcelldatawithrow("TC08",k,0,RRPConstants.DocUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.DocUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.DocUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.DocUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.DocUpload,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.DocUpload,RRPConstants.Path_Excel); 
	  }
  }
  
  public static void SentSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.sentsheetrow= RRPDriverScript.sentsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.sentsheetrow;k<= RRPDriverScript.sentsheetrow;k++) {
		  
	  
	  DS.ex.setcelldatawithrow("TC09",k,0,RRPConstants.SentForAppoval,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.SentForAppoval,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.SentForAppoval,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.SentForAppoval,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.SentForAppoval,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.SentForAppoval,RRPConstants.Path_Excel); 
	  
	  }
  }
  
  public static void AuthorizeSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.authorizesheetrow= RRPDriverScript.authorizesheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.authorizesheetrow;k<= RRPDriverScript.authorizesheetrow;k++) {
		  
	  
	  DS.ex.setcelldatawithrow("TC12",k,0,RRPConstants.Authorize,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("Helpdesk1",k,1,RRPConstants.Authorize,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("ADFC12313",k,2,RRPConstants.Authorize,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.Authorize,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.Authorize,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.Authorize,RRPConstants.Path_Excel); 
	  DS.ex.setcelldatawithrow("Authorized Successfully",k,6,RRPConstants.Authorize,RRPConstants.Path_Excel); 
	  
	  }
  }
  
  public static void WarningSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.warningsheetrow= RRPDriverScript.warningsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.warningsheetrow;k<= RRPDriverScript.warningsheetrow;k++) {
		  
	  
	  DS.ex.setcelldatawithrow("TC21",k,0,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel); 
	  
	  }
  }
 
  public static void RASubmitSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.submitsheetrow= RRPDriverScript.submitsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.submitsheetrow;k<= RRPDriverScript.submitsheetrow;k++) {
		  
	  DS.ex.setcelldatawithrow("TC22",k,0,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.RASubmitsheet,RRPConstants.Path_Excel); 
	  
	  }
  }
  
  public static void NBFCRASubmitSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.NBFCsubmitsheetrow= RRPDriverScript.NBFCsubmitsheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.NBFCsubmitsheetrow;k<= RRPDriverScript.NBFCsubmitsheetrow;k++) {
		  
	  DS.ex.setcelldatawithrow("TC23",k,0,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RM1",k,1,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("R6106",k,2,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.NBFCRASubmitsheet,RRPConstants.Path_Excel); 
	  
	  }
  }
  public static void QualityChecklistSheetUpdate(String BorrowerID,String BorrowerType) throws IOException {
	    
	  RRPDriverScript.QualityChecklistSheetrow= RRPDriverScript.QualityChecklistSheetrow+1;
	  
	  
	  for (int k= RRPDriverScript.QualityChecklistSheetrow;k<= RRPDriverScript.QualityChecklistSheetrow;k++) {
		  
	  DS.ex.setcelldatawithrow("TC24",k,0,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("RA1",k,1,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("A28430",k,2,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow("acid_qa",k,3,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerType,k,5,RRPConstants.Quality_Checklist,RRPConstants.Path_Excel); 
	  
	  }
  }
  public static void AllSheetUpdate(String BorrowerID) throws IOException {
	    
	  RRPDriverScript.AllSheetUpdate= RRPDriverScript.AllSheetUpdate+1;
	  
	  
	  for (int k= RRPDriverScript.AllSheetUpdate;k<= RRPDriverScript.AllSheetUpdate;k++) {
		  
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.PendDissagreeSheet,RRPConstants.Path_Excel);		  
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.WarningSignalsheet,RRPConstants.Path_Excel);	 
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.PendDissagreeSentBackSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.RAreverseSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.RArejectSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.ReviewProvidedSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.ReviewSentBackSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.OverrideApproveSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.OverrideSentBackSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.OverrideSpecialSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.WithdrawSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.ICRSheet,RRPConstants.Path_Excel);
	  DS.ex.setcelldatawithrow(BorrowerID,k,4,RRPConstants.FCRSheet,RRPConstants.Path_Excel);
	  }
  }
  public static void Mousehover(String object) throws IOException, InterruptedException
  {
   try{
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBtn = driver.findElement(By.xpath(RRPDriverScript.OR.getProperty(object)));
        Actions action = new Actions(driver);
        action.moveToElement(searchBtn).click().build().perform();;
        //action.click().build().perform();
        akFlag = true;
     }
   catch(Exception e){
            RRPLog.info("Not able to Mousehover on "+object+e.getMessage());
            ScreenShot(object);
            akFlag = false;
  		           }
  }

  public static void CHECKBOX(String object) throws IOException, InterruptedException
  {
   try{
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        element = driver.findElement(By.cssSelector(RRPDriverScript.OR.getProperty(object)));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
	    element.click();
	    RRPLog.info("CHECKBOX selected for "+object);
        akFlag = true;
     }
   catch(Exception e){
            RRPLog.info(" CHECKBOX Not Selected "+object+e.getMessage());
            ScreenShot(object);
            akFlag = false;
  		           }
  }

public static void Select(String object, String data) throws IOException, InterruptedException
{
	  
        try {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RRPDriverScript.OR.getProperty(object))));
        
    element = driver.findElement(By.xpath(RRPDriverScript.OR.getProperty(object)));
    //String data="2021";
    JavascriptExecutor	je = (JavascriptExecutor) driver;
    je.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
    Select sel=new Select(element);
        sel.selectByVisibleText(data);
//        RRPLog.info("Sucessfully selected value "+data+"in"+object);
//        akFlag = true;
        }
        catch(Exception e){
        
//        RRPLog.info("Not Able to select data in "+ object +e.getMessage());        
        ScreenShot(object);        
//        akFlag = false;
        }
}	
 

 

  
}