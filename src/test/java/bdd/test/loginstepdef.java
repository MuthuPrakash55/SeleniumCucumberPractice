package bdd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.Driverfactory;
import io.cucumber.java.en.*;

public class loginstepdef extends Driverfactory {
	
	@Given("verify that user navigate to right applictaion")
	public void verifyThatUserNavigateToRightApplictaion() {		
	  //  driver= Driverfactory.getdriver();
	    String title=driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals("GTPL Bank Home Page", title);
	}
	@Given("user enter the userid as {string}")
	public void userEnterTheUseridAs(String uname) throws Exception {
	    driver.findElement(By.xpath(Driverfactory.getxpath("login"))).sendKeys(uname);
	}
	@Given("user enter the password as {string}")
	public void userEnterThePasswordAs(String pwd) throws Exception  {
	    driver.findElement(By.xpath(Driverfactory.getxpath("password"))).sendKeys(pwd);
		  
	}
	@Then("user clicks the login button")
	public void userClicksTheLoginButton() throws Exception  {
	   driver.findElement(By.xpath(Driverfactory.getxpath("loginbtn"))).click();

	}
	@Then("verify that user landed in right page")
	public void verifyThatUserLandedInRightPage() {
	   String title= driver.getTitle();
	   Assert.assertEquals("GTPL Bank Manager HomePage" , title);
	}
	@Given("user enter the invalid userid as {string}")
	public void userEnterTheInvalidUseridAs(String invaliduname) throws Exception {
		driver.findElement(By.xpath(super.getxpath("invaliduser"))).sendKeys(invaliduname);
		
	}
	@Then("verify that user get a alert message and accept and return to loginpage")
	public void verifyThatUserGetAErrorMessage() throws InterruptedException {
	 String error=driver.switchTo().alert().getText();
	 System.out.println(error);
	 Assert.assertEquals(error, "User is not valid");
	driver.switchTo().alert().accept();
}
	@Given("user get the error userid must not be blank")
	public void userGetTheErrorUseridMustNotBeBlank() throws Exception {
	   String error=driver.findElement(By.xpath(super.getxpath("useridblank"))).getText();
	   Assert.assertEquals(error, "User-ID must not be blank");
	}
	@Given("user get the error password must not be blank")
	public void userGetTheErrorPasswordMustNotBeBlank() throws Exception {
		String error=driver.findElement(By.xpath(super.getxpath("pwdblank"))).getText();
		   Assert.assertEquals(error, "Password must not be blank");
	}
}