package com.application1.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MR 
{
	static WebDriver driver;
	 
    // ===============================================================================
   
    /* 
     *  Browser launch and application launch --- This is updated
     */
    public void browserFacebookLaunch() throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("http://www.facebook.com/");
        Thread.sleep(3000);
        //driver.close();
    }

    /*
     * Simple login process with xpath locator
     */
    public void loginFacebook() throws IOException, InterruptedException 
    {
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
       
        //WebElement uName = driver.findElement(By.name("userName"));
        email.sendKeys("parthadiscover@gmail.com");
        Thread.sleep(3000);
       
        WebElement pwd = driver.findElement(By.name("pass"));
        pwd.sendKeys("watchyoursteps");
        Thread.sleep(3000);
        
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

    }
    
    public void browserMercuryAppLaunch() throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("http://newtours.demoaut.com/");
        Thread.sleep(3000);
        //driver.close();
    }
   
    public void loginMercury() throws IOException, InterruptedException 
    {
        WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
       
        //WebElement uName = driver.findElement(By.name("userName"));
        uName.sendKeys("dasd");
        Thread.sleep(3000);
       
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys("dasd");
        Thread.sleep(3000);
       
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        
    }
 
    public void selectCity() throws InterruptedException, AWTException
    {
        WebElement departFrom = driver.findElement(By.name("fromPort"));
        WebElement Arrival = driver.findElement(By.xpath("//select[@name='toPort']"));
        WebElement onMonth = driver.findElement(By.name("fromMonth"));
        WebElement onDay = driver.findElement(By.name("fromDay"));
        WebElement Bclass = driver.findElement(By.xpath("//input[@value='Business']"));
        Select sel = new Select(departFrom);
        Select sel1 = new Select(Arrival);
        Select sel2 = new Select(onMonth);
        Select sel3 = new Select(onDay);
        Thread.sleep(4000);
        //sel.selectByVisibleText("Paris");
        //sel.selectByIndex(6);
        sel.selectByValue("New York");
        sel1.selectByIndex(7);
        sel2.selectByVisibleText("April");
        sel3.selectByIndex(5);
        Thread.sleep(4000);
        
        Actions builder = new Actions(driver);
        builder.moveToElement(Bclass).build().perform();
        builder.click(Bclass).build().perform();
        
        //Robot r1 = new Robot();
        //r1.keyPress(KeyEvent.VK_ENTER);
       
     }

    	public void loginRobot() throws AWTException, InterruptedException 
    {
        WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
        uName.sendKeys("dasd");
        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
        pwd.sendKeys("dasd");
        Thread.sleep(4000);
       
        Robot r1 = new Robot();
        r1.keyPress(KeyEvent.VK_ENTER);
    }
 
        public void loginAction() 
        {
            WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
            uName.sendKeys("dasd");
     
            WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
            pwd.sendKeys("dasd");
     
            WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
     
            Actions builder = new Actions(driver);
     
            builder.moveToElement(login).build().perform();
     
            builder.contextClick(login).build().perform();
            
            
        }
        
     // ================================================================================

        

        /*

         * Login with Sikuli [Image identification will take place instead of Object]

         */

        public void loginSikuli() throws FindFailed 
        {

        	//WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));

              //uName.sendKeys("dasd");

              //WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));

              //pwd.sendKeys("dasd");
              
              Screen screen = new Screen();
              Pattern Username = new Pattern("./Sikuli/Username1.PNG");
              Pattern Password = new Pattern("./Sikuli/Password.PNG");
              
              //Pattern btnLogin = new Pattern("./Sikuli/Login1.PNG");
              screen.type(Username, "dasd");
              screen.type(Password, "dasd");
              
              
              //screen.click(btnLogin);
              
              

        }
        public void scrollDown() throws InterruptedException
        {
        	   System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
               driver = new ChromeDriver();
               driver.manage().window().fullscreen();
               driver.get("http://toolsqa.com/iframe-practice-page/");
               Thread.sleep(3000);        
               JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("window.scrollBy(0, 6000)");
               Thread.sleep(3000);
               js.executeScript("window.scrollBy(0, -6000)");
               Thread.sleep(9000);                         
        }
        
        public void draganddrop() throws InterruptedException
        {
        	WebElement src = driver.findElement(By.xpath("//input[@name='userName']"));
        	
        	WebElement dest = driver.findElement(By.xpath("//input[@name='password']"));
        	
        	Actions builder4 = new Actions(driver);
        	builder4.dragAndDrop(src, dest).build().perform();
        	
        }
        
        public void ImplicitWaitLogin() throws InterruptedException
        {
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	WebElement Username = driver.findElement(By.xpath("//input[@name='userName']"));
        	Username.sendKeys("dasd");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	WebElement password = driver.findElement(By.name("password"));
        	password.sendKeys("dasd");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
            
            Actions builder = new Actions(driver);
     
            builder.moveToElement(login).build().perform();
     
            builder.doubleClick().build().perform();
        	
        	
        }
        
        public void ExplicitLogin() throws InterruptedException
        {
        	new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated
        			(By.xpath("//input[@name='userName']")));
        	WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
            uName.sendKeys("dasd");
           
            new WebDriverWait(driver, 10)
                      .until(ExpectedConditions.presenceOfElementLocated
                    		  (By.xpath("//input[@name='password']")));
  
            WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
            pwd.sendKeys("dasd");
  
            new WebDriverWait(driver, 10)
                      .until(ExpectedConditions.presenceOfElementLocated
                    		  (By.xpath("//input[@value='Login']")));
  
            WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
            login.click();

        	
        }
        
        public void autoITTest() throws InterruptedException, IOException 
        {

            System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://imge.to/");

            Thread.sleep(4000);

            WebElement startupload = driver.findElement(By.xpath("//a[@class='btn btn-big green']"));

            startupload.click();

            Thread.sleep(2000);

            Runtime.getRuntime().exec("./Autoitexe/Fileupload.exe");

            Thread.sleep(6000);

            WebElement checkbox = driver.findElement(By.xpath("//input[@value='1']"));

            //upload.click();

            
            
            Actions builder = new Actions(driver);
            builder.moveToElement(checkbox).build().perform();
            builder.click(checkbox).build().perform();
            
            Thread.sleep(5000);
            
            WebElement upload = driver.findElement(By.xpath("//button[@class='btn btn-big green']"));
            
            Actions builder1 = new Actions(driver);
            builder1.moveToElement(upload).build().perform();
            builder1.click(upload).build().perform();
            
            //upload.click();
 }
        
        public void frameHandling() throws InterruptedException 
        
        {
            
             System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
             driver = new ChromeDriver();
             driver.manage().window().fullscreen();
             driver.get("http://demo.guru99.com/test/guru99home/");
             Thread.sleep(6000);
             JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("window.scrollBy(0,2300)");
             Thread.sleep(6000); 
             driver.switchTo().frame("a077aa5e");
             Thread.sleep(4000);
             WebElement linkbtn = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
             linkbtn.click();
             driver.switchTo().defaultContent();
 
        /* Iframe Identification */
       
             int size = driver.findElements(By.tagName("iframe")).size();
             System.out.println(size);
             List<WebElement> ele = driver.findElements(By.tagName("iframe"));
             System.out.println("Number of frames in a page :" + ele.size());
             for(WebElement el : ele){
             System.out.println("Frame Id :" + el.getAttribute("id"));
             System.out.println("Frame name :" + el.getAttribute("name"));
          }
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
                            String passwordDataFromExcel = sh1.getCell(1, i).getContents();

                            Thread.sleep(2000);

                            WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
                            uName.sendKeys(userNameDataFromExcel);
                            Thread.sleep(2000);

                            WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
                            pwd.sendKeys(passwordDataFromExcel);
                            Thread.sleep(2000);

                            WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
                            login.click();
                            Thread.sleep(5000);

                            WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
                            home.click();
                            Thread.sleep(5000);

            }
        }


}


