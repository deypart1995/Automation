package com.application1.test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM 
{
	static WebDriver driver;
	
	public void OrangeHRMlaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void OrangeHRMlogin() throws InterruptedException
	{
		WebElement Uname = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		Uname.sendKeys("Admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		password.sendKeys("admin123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//input[@name='Submit']"));
		login.click();
		
		//Robot r1 = new Robot();
		//r1.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void OrangeHRMactivities() throws InterruptedException, AWTException
	{
		WebElement Time = driver.findElement(By.xpath("//*[@id=\"menu_time_viewTimeModule\"]/b"));
		Time.click();
		
		WebElement Leave = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b"));
		Leave.click();
		
		WebElement SubUnit = driver.findElement(By.xpath("//select[@name='leaveList[cmbSubunit]']"));
		Select sel = new Select(SubUnit);
		sel.selectByIndex(1);
		
		WebElement LeaveStatus = driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_2']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(LeaveStatus).build().perform();
		builder.click(LeaveStatus).build().perform();
		
		WebElement fromdate = driver.findElement(By.xpath("//input[@id='calFromDate']"));
		fromdate.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fromdate.sendKeys("2019-08-04");
		
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);

		
		
		
		
	}
}
