package com.application1.test;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;

import jxl.read.biff.BiffException;

public class Driver 
{

	public static void main(String[] args) throws InterruptedException, IOException, AWTException, FindFailed, BiffException
	{
		//MR mr1 = new MR();
		//mr1.browserMercuryAppLaunch();
		WebTable wb = new WebTable();
		wb.webTableHandling();
		//PropertyFile PF = new PropertyFile();
		//PF.loginwithpropertyfile();
		//mr1.loginDataDrivenExcelSheet();
		
		/*OrangeHRM ohrm = new OrangeHRM();
		ohrm.OrangeHRMlaunch();
		ohrm.OrangeHRMlogin();
		ohrm.OrangeHRMactivities();*/
		
		/*ExcelLogin exclogin = new ExcelLogin();
		exclogin.browserFacebookLaunch();
		exclogin.loginDataDrivenExcelSheet();*/
		
		/*RedBus rb = new RedBus();
		rb.browserMMTLaunch();
		rb.loginSikuli();
		rb.loginMMT();*/
	}
	
}
