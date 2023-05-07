package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getURL();
	public static  WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		logger=Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("edge"))
		{

			System.setProperty("Webdriver.Edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("Webdriver.gecko.driver",readconfig.getEdgePath());
			driver = new FirefoxDriver();


		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
