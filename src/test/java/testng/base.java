package testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.pageobject.loginpage;

public class base {

	public WebDriver driver;
	
	
	public  WebDriver intializebrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			break;
		}
		return driver;
	}
public String capturescreen(WebDriver driver) throws Exception  {
		
		Date date=new Date();
		String FileName = date.toString().replace(":", "").replace(" ", "");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		File des=new File("./screenshot/"+FileName+".png");
		String destination=des.getAbsolutePath();
		FileUtils.copyFile(src, des);
		return destination;
	}
public static String getproperties(String keyname) throws IOException {
	File file=new File("C:\\Users\\praka\\eclipse-workspace\\SeleniumCucumberPractice\\src\\test\\resources\\testng.properties");
	FileInputStream stream=new FileInputStream(file);
	Properties pro=new Properties();
	pro.load(stream);
	return (String) pro.get(keyname);
	
}
}
