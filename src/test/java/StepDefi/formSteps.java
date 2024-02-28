package StepDefi;

import java.io.IOException;
import PageObjects.ForEnterprise;
import Factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class formSteps {
	ForEnterprise f;
	
	@Given("navigate to the Coursera home page")
	public void navigate_to_the_coursera_home_page()
	{
		f = new ForEnterprise(BaseClass.getDriver());
	}

	@When("the user clicks on For Enterprises")
	public void the_user_clicks_on_for_enterprises() {
		f.homePage();
		f.scrollToCoursera();
		f.enterpriseClick();
	}

	@And("the user clicks on Coursera for campus")
	public void the_user_clicks_on_coursera_for_campus() {
		f.solutionsClick();
		f.campusClick();
	}

	@And("scroll to the form")
	public void scroll_to_the_form() throws Exception {
		f.scrollToForm();
	}
	
	@Then("enter the details in the form")
	public void enter_the_details_in_the_form() throws IOException
	{
		f.firstName();
		f.lastName();
		f.emailAddress();
		f.phoneNumber();
		f.institutionType();
		f.institutionName();
		f.jobRole();
		f.department();
		f.selectNeeds();
		f.country();
		f.checkBox();
		f.submitButton();
	}
	
	@And("verify the error message")
	public void verify_the_error_message() throws Exception {
		f.captureMessage();
	}


}
