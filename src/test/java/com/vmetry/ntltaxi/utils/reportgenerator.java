package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.initializer;

public class reportgenerator extends initializer {

	public static void archivefile() throws IOException{
		if(isarchive){
		SimpleDateFormat sf=new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		String date = sf.format(new Date());
				
		File src = new File("C:\\Workspace\\dddtest\\screenshot");
		File dest = new File("C:\\Workspace\\dddtest\\oldscreenshot\\"+date);
		FileUtils.copyDirectory(src, dest);
		FileUtils.cleanDirectory(src);
		isarchive = false;
		}
	}

}
