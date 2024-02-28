package StepDefi;

import java.io.IOException;
import PageObjects.WebDevelopment;
import Factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class courseStep {
	WebDevelopment  w;
	
	@Given("Navigate to the coursera home page")
	public void navigate_to_the_coursera_home_page()
	{
		w = new WebDevelopment(BaseClass.getDriver());
	}

	@When("the user clicks on the inputBox")
	public void the_user_clicks_on_the_input_box() throws IOException
	{
		w.inputBox();
		w.searchButton();
	}

	@And("the user selects the checkBox")
	public void the_user_selects_the_check_box()
	{
		w.clickBeginner();
		w.clickEnglish();
		w.scrollToTop();
	}

	@Then("verify the details of the first course")
	public void verify_the_details_of_the_first_course() throws IOException
	{
		w.course1();
		w.childPage();
		w.courseDetails1();
		w.parentPage();

	}

	@And("verify the details of the second course")
	public void verify_the_details_of_the_second_course() throws IOException
	{
		w.course2();
		w.childPage();
		w.courseDetails2();
		w.parentPage();
	}

}
