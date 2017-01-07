package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initializer.initializer;

public class reporttest {
	public static WebDriver wd;
	public static ExtentReports exreport;
	public static ExtentTest log;  //log the test case activity
	
	@Test(priority=1)
	public static void googletest(){
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		exreport = new ExtentReports("C:\\Workspace\\dddtest\\reports\\ddd.html");
		log = exreport.startTest("googletest");
		wd.get("https://www.google.co.in/");
	}
	
	@Test(priority=2)
	public static void yahootest(){
		log = exreport.startTest("yahootest");
		wd.get("https://in.yahoo.com/");
	}
	
	@Test(priority=3)
	public static void gmailtest(){
		log = exreport.startTest("gmailtest");
		wd.get("https://accounts.google.com");
	}
	
	@AfterMethod
	public void teardown(ITestResult R) throws IOException{
		 
		if(R.isSuccess()){
			String path = takescreen(R.getName());
			log.log(LogStatus.PASS, R.getName(), log.addScreenCapture(path));
			
		}else{
			String path = takescreen(R.getName());
			log.log(LogStatus.FAIL, R.getName(), log.addScreenCapture(path));
			
		}
		exreport.endTest(log);
		exreport.flush();
	}
	public String takescreen(String name) throws IOException{

		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);  
		File dst = new File("C:\\Workspace\\dddtest\\screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();  // convert file to string
	}

}
