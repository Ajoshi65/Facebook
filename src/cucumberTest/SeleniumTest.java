package cucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumTest 

{
	public static WebDriver driver=null;
	
	
	
	@Test(priority=0)
		@Given("^I have open the browser^")
		public void openBrowser()
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		
	@Test(priority=1)
		@When("^I open Facebook website^")
		public void openWebsite()
		{
			driver.navigate().to("https://www.facebook.com/");
		}
	@Test(priority=2)
		@Then("^Login button should exits^")
		public void login()
		{
			if(driver.findElement(By.id("u_0_v")).isEnabled()) 
				{ 
		         System.out.println("Test 1 Pass"); 
				} 
			else 
		     	{ 
		         System.out.println("Test 1 Fail"); 
		     	} 
		      driver.close(); 
		}
}
