package com.client.NM_HospitalManage.ListenerUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.client.NM_HospitalManage.BaseClassUtility.BaseClass;
import com.client.NM_HospitalManage.BaseClassUtility.UtilityClassObject;

public class ListenerImpClass implements ISuiteListener, ITestListener {
	ExtentReports report;
	String testName;
	ExtentTest test;
	String timeStamp = new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/" + timeStamp + "report.html");
		spark.config().setDocumentTitle("HMS Report");
		spark.config().setReportName("Medical Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", BaseClass.browser);
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + " test script got started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, testName + " test script got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, testName + " test script got failed" + result.getThrowable());

		TakesScreenshot tks = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath + timeStamp);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, testName + " test script got skipped");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
}
