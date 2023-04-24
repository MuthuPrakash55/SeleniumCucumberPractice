package bdd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.*;
public class newcustomerdef extends Driverfactory{
	
	@Given("user clicks new customer field")
	public void userClicksNewCustomerField() throws Exception {
		//driver= Driverfactory.getdriver();
		driver.findElement(By.xpath(Driverfactory.getxpath("newcustomer"))).click();
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.findElement(By.xpath(Driverfactory.getxpath("ad"))).click();		
	}
	
	@Then("verify that user can able to fill customer name")
	public void verifyThatUserCanAbleToFillCustomerNameAs() throws Exception {
	    driver.findElement(By.xpath(Driverfactory.getxpath("firstname"))).sendKeys(Driverfactory.getdata("firstname"));
	}
	
	@Then("user click the gender radio button")
	public void userClickTheGenderRadioButton() throws Exception {
	    driver.findElement(By.xpath(Driverfactory.getxpath("radio"))).click();
	}
	
	@Then("verify that user can fill the date of birth")
	public void verifyThatUserCanFillTheDateOfBirth() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("dob"))).sendKeys(Driverfactory.getdata("dob"));
	}
	
	@Then("user fill the address field")
	public void userFillTheAddressField() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("address"))).sendKeys(Driverfactory.getdata("address"));	    
	}
	
	@Then("user fill the city and state")
	public void userFillTheCityAsAndStateAs() throws Exception {
	   driver.findElement(By.xpath(Driverfactory.getxpath("city"))).sendKeys(Driverfactory.getdata("city"));
	   driver.findElement(By.xpath(Driverfactory.getxpath("state"))).sendKeys(Driverfactory.getdata("state"));
	}
	
	@Then("user fill the pin number")
	public void userFillThePinAs() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("pinno"))).sendKeys(Driverfactory.getdata("pinno"));
	}
	
	@Then("user fill the telephone number")
	public void userFillTheTelephoneNumber() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("teleno"))).sendKeys(Driverfactory.getdata("teleno"));	    
	}
	
	@Then("user the fill the email address")
	public void userTheFillTheEmailAddress() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("email"))).sendKeys(Driverfactory.getdata("email"));	    
	}
	
	@Then("user finally clicks the submit button")
	public void userFinallyClicksTheSubmitButton() throws Exception {
		driver.findElement(By.xpath(Driverfactory.getxpath("submit"))).click();
	}	
}