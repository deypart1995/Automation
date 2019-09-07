package com.application1.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class RedBus 
{
	static WebDriver driver;
	
	public void browserMMTLaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
	}
	
	public void loginSikuli() throws FindFailed 
	{
		Screen screen = new Screen();
        Pattern btnLogin = new Pattern("./Sikuli/Login2.PNG");
        screen.click(btnLogin);
    }
	
	public void loginMMT() throws InterruptedException
	{
		WebElement uName = driver.findElement(By.xpath("//input[@id='username']"));
		uName.sendKeys("parthadiscover@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("being@1234");
		
		driver.switchTo().alert().dismiss();
		
		WebElement lgn = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/form/div[4]/button"));
		lgn.click();
		//Robot r1 = new Robot();
		//r1.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	
}
