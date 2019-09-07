package com.application1.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable 
{
	static WebDriver driver;
	
	
	public void webTableHandling() {

        System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe");

         driver = new ChromeDriver();

         driver.get("http://demo.guru99.com/test/web-table-element.php");

         driver.manage().window().maximize();

        

       //No.of Columns

       List<WebElement>  col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));

       System.out.println("No of cols are : " +col.size());

      

       //No.of rows

       List<WebElement>  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));

       System.out.println("No of rows are : " + rows.size());

      

       // Dynamic data searching and printing

       for(int i=1; i<rows.size(); i++)

       {

            if(driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[1]")).getText().equals("Kajaria Ceramics"))

       {

            if(driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[1]")).getText()!=null)

              {

            System.out.println(driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText());

              }

              else

              {

                   System.out.println("Required data not found");

              }

              break;

       }

       }
	}
}
