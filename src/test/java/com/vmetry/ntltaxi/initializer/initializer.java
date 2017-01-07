package com.vmetry.ntltaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntltaxi.utils.reportgenerator;

public class initializer {
	public static FileInputStream envFis = null;
	public static Properties envProp = null;
	public static WebDriver wd = null;
	public static FileInputStream locFis = null;
	public static Properties locProp = null;
	public static ExtentReports exreport;
	public static ExtentTest log;
	public static Boolean isarchive = true;

	public static void initialize() throws IOException {
		reportgenerator.archivefile();
		exreport = new ExtentReports("C:\\Workspace\\dddtest\\reports\\ddd.html");
		envFis = new FileInputStream(
				new File(System.getProperty("user.dir") + File.separator
						+ "/src" + File.separator + "test" + File.separator
						+ "java" + File.separator + "com" + File.separator
						+ "vmetry" + File.separator + "ntltaxi"
						+ File.separator + "config" + File.separator
						+ "env.properties"));
		envProp = new Properties();
		envProp.load(envFis);

		locFis = new FileInputStream(new File(System.getProperty("user.dir")
				+ File.separator + "/src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "com"
				+ File.separator + "vmetry" + File.separator + "ntltaxi"
				+ File.separator + "config" + File.separator
				+ "locator.properties"));
		locProp = new Properties();
		locProp.load(locFis);

		if (wd == null) {

			if (envProp.getProperty("BROWSER").equals("FIREFOX")) {
				wd = new FirefoxDriver();
				wd.manage().window().maximize();

			}
		}
	}

	public static WebElement getWebelementbyxpath(String xpath) {
		return wd.findElement(By.xpath(locProp.getProperty(xpath)));

	}

}
