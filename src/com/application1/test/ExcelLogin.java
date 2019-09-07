package com.application1.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelLogin 
{
	static WebDriver driver;
	
	public void browserFacebookLaunch() throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("http://www.facebook.com/");
        Thread.sleep(3000);
        
    }
	
	public void loginDataDrivenExcelSheet() throws BiffException, IOException, InterruptedException 
    {
        File src = new File("./TestData/ExcelData.xls");
        Workbook wb = Workbook.getWorkbook(src);
        Sheet sh1 = wb.getSheet("Sheet1");

        int rows = sh1.getRows();

        for (int i = 1; i < rows; i++) 
        {
                        String userNameDataFromExcel = sh1.getCell(0, i).getContents();
                        WebElement uName = driver.findElement(By.xpath("//input[@name='email']")); 
                        uName.sendKeys(userNameDataFromExcel);
                        Thread.sleep(2000);

                        String passwordDataFromExcel = sh1.getCell(1, i).getContents();
                        WebElement pwd = driver.findElement(By.xpath("//input[@name='pass']"));
                        pwd.sendKeys(passwordDataFromExcel);
                        Thread.sleep(2000);

                        WebElement login = driver.findElement(By.xpath("//label[@id='loginbutton']"));;
                        login.click();
                        Thread.sleep(5000);
                        
                        
                        if(uName.equals(userNameDataFromExcel))
                        {
                        	WebElement login1 = driver.findElement(By.xpath("//button[@id='loginbutton']"));
                        	login1.click();
                        }
                        else
                        {
                        	driver.navigate().back();
                        	WebElement uName1 = driver.findElement(By.xpath("//input[@name='email']"));
                        	uName1.clear();
                        }
                        
                        
                        
                        /*WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]"));
                        dropdown.click();
                        
                        Select sel = new Select(dropdown);
                        sel.selectByIndex(5);*/
                        
        }
    }
}
                               
                        
                        
                        
                        
                        
                        


                        
