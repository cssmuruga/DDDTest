package com.vmetry.ntltaxi.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.initializer;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.homepage;
import com.vmetry.ntltaxi.utils.screenshotgenerator;

public class HomePageTest extends initializer {
	
	@BeforeTest
	public void browseropen() throws IOException{
	initialize();
	}
	@Test(dataProvider="Homepagetest") //data provider name should be class name
	public void testHomePage(String data, String name, String mobnum, String pickup, String dropoff, String cartype) throws IOException{
		//initialize();
		log = exreport.startTest(data);
		wd.get(envProp.getProperty("URL"));
		/*WebElement name = wd.findElement(By.xpath(".//*[@id='nameid']"));
		name.sendKeys(envProp.getProperty("name"));
		WebElement mobnum = wd.findElement(By.xpath(".//*[@id='mobid']"));
		mobnum.sendKeys(envProp.getProperty("mobnumber"));
		WebElement pickid = wd.findElement(By.xpath(".//*[@id='pickid']"));
		pickid.sendKeys(envProp.getProperty("pickup"));
		WebElement dropid = wd.findElement(By.xpath(".//*[@id='dropid']"));
		dropid.sendKeys(envProp.getProperty("dropoff"));
		WebElement cartype = wd.findElement(By.xpath(".//*[@id='vehid']"));
		cartype.sendKeys(envProp.getProperty("cartype"));*/
		homepage.enterName(name);
		homepage.enterMobilenumber(mobnum);
		homepage.enterPickuplocation(pickup);
		homepage.enterDropofflocation(dropoff);
		homepage.enterCartype(cartype);
	}

	@DataProvider(name ="Homepagetest")
	
	public static Object[][] getdata1() throws Exception
	{
		if(inputReader.RunModeVerification("HomePageTest")){
			Object[][] data = inputReader.selectSingleDataOrMulitiData("HomePageTest");
			
	/*	Object[][] data1 = new Object[2][5];
		data1[0][0]="mark";
		data1[0][1]="12345";
		data1[0][2]="ADYAR";
		data1[0][3]="ADYAR";
		data1[0][4]="Basic";

		data1[1][0]="mani";
		data1[1][1]="67890";
		data1[1][2]="ADYAR";
		data1[1][3]="AGARAM";
		data1[1][4]="Sedan"; */
		return data;  
	}
		return null;}
	
@AfterMethod
public void teardown(ITestResult r) throws IOException{
	if(r.isSuccess()){
		screenshotgenerator.getScreenshot(r);
		
	}else{  screenshotgenerator.getScreenshot(r);
		
	}
}
}
