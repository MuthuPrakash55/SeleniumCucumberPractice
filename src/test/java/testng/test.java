package testng;


import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test {
			static  ExtentReports report;
			static ExtentTest test;
			public WebDriver driver;
	
	@BeforeClass	
	public void before() {
		report=new ExtentReports(
				"./src/test/resources/testng/extentreport.html");
	}
	@Test(dataProvider = "loginData",dataProviderClass = excelDataSupllier.class)
	public void login(String username,String password) throws Exception {
		test=report.startTest("login", "user can able to login");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");		
		
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
	
	@AfterClass
	public void teardown() {		
		report.flush();
	}
	
	public String capturescreen(WebDriver driver) throws Exception  {
		
		Date date=new Date();
		String FileName = date.toString().replace(":", "").replace(" ", "") + ".png";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		File des=new File("./screenshot/"+FileName+".png");
		String destination=des.getAbsolutePath();
		FileUtils.copyFile(src, des);
		return destination;
	}
	
	
}
