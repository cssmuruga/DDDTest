package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vmetry.ntltaxi.initializer.initializer;

public class homepage extends initializer {

	public static void enterName(String username){
		getWebelementbyxpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(username);
	}
public static void enterMobilenumber(String mobnum){
	getWebelementbyxpath("HOMEPAGE_TYPE_MOBILENUMBER_XPATH").sendKeys(mobnum);
	}
public static void enterPickuplocation(String pickup){
	getWebelementbyxpath("HOMEPAGE_TYPE_PICKUPLOCATION_XPATH").sendKeys(pickup);
}
public static void enterDropofflocation(String dropoff){
	getWebelementbyxpath("HOMEPAGE_TYPE_DROPOFFLOCATION_XPATH").sendKeys(dropoff);
}
public static void enterCartype(String cartype){
	WebElement dropdown = getWebelementbyxpath("HOMEPAGE_TYPE_CARTYPE_XPATH");
	Select s = new Select(dropdown);
	s.selectByVisibleText(cartype);
}
	
}
