package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initializer.initializer;

public class screenshotgenerator extends initializer {
	
	public static void getScreenshot(ITestResult R) throws IOException{
		Object[] data = R.getParameters();
		if(R.isSuccess()){
			String path = takescreen(data[0].toString());
			log.log(LogStatus.PASS, data[0].toString(), log.addScreenCapture(path));
			
		}else{
			String path = takescreen(data[0].toString());
			log.log(LogStatus.FAIL, data[0].toString(), log.addScreenCapture(path));
			
		}
		exreport.endTest(log);
		exreport.flush();
		
	}
	
	public static String takescreen(String name) throws IOException{

		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);  
		File dst = new File("C:\\Workspace\\dddtest\\screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();  // convert file to string
	}


}
