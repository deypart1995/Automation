package com.application1.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFile 
{
	static WebDriver driver;
	
	public void loginwithpropertyfile() throws IOException, InterruptedException , AWTException
	{
		System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.gmail.com/");
        Thread.sleep(3000);
        File file = new File("./TestData/testdata.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        Thread.sleep(3000);
        
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(prop.getProperty("Username1"));
        Thread.sleep(3000);
        Robot r1 = new Robot();
        r1.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pwd.sendKeys(prop.getProperty("Password1"));
        Thread.sleep(3000);
        r1.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        
        //WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        //login.click();
        
        WebElement compose = driver.findElement(By.xpath("//div[@role='button']"));
        compose.click();
        
        /*String expTitle = "Gmail";
        String actTitle = driver.getTitle();
        
        System.out.println("System returns the page title: "+ actTitle);
        
        if(actTitle.equals(expTitle))
        {
        	System.out.println("Test case passed");
        }
        else
        {
            System.out.println("Test case failed");

        }*/
       
        
    }
	
	
	
}
