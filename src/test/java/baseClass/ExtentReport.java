package baseClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	DateFormat df;
	String dir = "D:\\BankMantap\\AutomatedReport\\";
	
	@BeforeSuite
	public void reportSetup() {
		df = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		htmlReporter = new ExtentHtmlReporter(dir + "Automation_Report_" + df.format(new Date()) + ".html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterSuite
	public void reportTearDown() {
		extent.flush();
	}
}
