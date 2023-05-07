package com.nopcommerce.utilities;
//Listeners class used to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest logger;
	 
	 public void onStart(ITestContext textContext)
	 {
		 String timestamp =new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());//timestamp
		 String repName="Test_Report-"+timestamp+".html";
		 
		 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
		 htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		 
		 extent= new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 
		 htmlReporter.config().setDocumentTitle("NOP commerce project");
		 htmlReporter.config().setReportName("Functional Test Automation Report");
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		 htmlReporter.config().setTheme(Theme.DARK);//dark theme is set
		 
			 
	 }
	 public void onTestSuccess(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());//create new entry in the report
		 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//sned the passed info
	 }
	 
	 public void onTestFailure(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());//create new entry in the report
		 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));//sned the failed info
		 String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		 File f=new File(screenshotPath);
		 if (f.exists())
		 {
			 try {
			 logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		 }
		 
		 catch(IOException e)
			 {e.printStackTrace();
		 }
		 
		 }
	 }
	 public void onTestSkipped(ITestResult tr)
	 {
		 
		 logger=extent.createTest(tr.getName());//create new entry in report
		 logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		 }
	 
	 public void onFinish(ITestResult testContext)
	 
	 {
		 extent.flush();
		 
	 }
	

}
