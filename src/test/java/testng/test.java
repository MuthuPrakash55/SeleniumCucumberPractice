package testng;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import bdd.test.newcustomerdef;
import testng.pageobject.loginpage;

public class test extends base {
			static  ExtentReports report;
			static ExtentTest test;
			loginpage login;
	
	@BeforeClass	
	public void before() {
		report=new ExtentReports(
				"./src/test/resources/testng/extentreport.html");
	}
	@BeforeMethod
	public void setup() throws IOException {
		String browser=base.getproperties("browser");
		String url=base.getproperties("url");
		intializebrowser(browser);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test(dataProvider = "loginData",dataProviderClass = excelDataSupllier.class)
	public void login(String username,String password) throws Exception {
		test=report.startTest("login", "user can able to login");
//		String browser=base.getproperties("browser");
//		String url=base.getproperties("url");
//		intializebrowser(browser);
//		driver.manage().window().maximize();
//		driver.get(url);		
		
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);		
		test.log(LogStatus.INFO,"user is able to enter name",test.addScreenCapture(capturescreen(driver)));
				
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);		
		test.log(LogStatus.INFO,"user is able to enter password",test.addScreenCapture(capturescreen(driver)));
				
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
		
		if(driver.getTitle().equals("Logged In Successfully | Practice Test Automation")) {
		test.log(LogStatus.PASS, "user is login with valid credentials",test.addScreenCapture(capturescreen(driver)));
		}
		//driver.findElement(By.id("error")).isDisplayed();
		else {
			boolean error=driver.findElement(By.id("error")).isDisplayed();
			test.log(LogStatus.PASS, "user is can't login with invalid credentials",test.addScreenCapture(capturescreen(driver)));
			System.out.println(error);
		}
		report.endTest(test);
		
		}	
	@AfterMethod
	public void teardown() {		
		report.flush();
		driver.quit();
	}	
	

}
