package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class myhooks {
		WebDriver driver;
	@Before
	public void browser() {
		
	    Driverfactory.intializeBrowser("chrome");
		driver=Driverfactory.getdriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.guru99.com/V1/index.php");
}
	@After
	public  void screenshot(Scenario scenario) {		
		byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		//System.out.println(scenario.getName());		
	}
}
