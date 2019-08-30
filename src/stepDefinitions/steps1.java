package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps1 

{
	@Given("^I have open the browser$")
	public void i_have_open_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("I have open the browser");
	   
	}

	@When("^I open Facebook website$")
	public void i_open_Facebook_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I open Facebook website");
	  
	}

	@Then("^Login button should exist$")
	public void login_button_should_exist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login button should exist");
	   
	
}
}
