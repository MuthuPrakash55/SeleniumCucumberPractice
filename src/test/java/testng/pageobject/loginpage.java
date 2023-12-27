package testng.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage  {
	WebDriver driver;
		public loginpage(WebDriver rdriver) {
			driver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id = "username")
		WebElement username;
		
		@FindBy(id = "password")
		WebElement password;
		
		@FindBy(id = "submit")
		WebElement button;
		
		public void uname(String name) {
			username.sendKeys(name);
		}
		public void pword(String word) {
			password.sendKeys(word);
		}
		public void submit() {
			button.click();
		}
}
