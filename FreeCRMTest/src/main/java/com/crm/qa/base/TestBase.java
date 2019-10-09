package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase() 
	{
		try 
		{
		 prop = new Properties();
		FileInputStream fip = new FileInputStream("C:\\Users\\aruna\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fip);
	    }
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\aruna\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\aruna\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		
		driver.get(prop.getProperty("url"));
		
		}

}
