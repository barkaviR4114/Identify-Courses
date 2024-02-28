package StepDefi;

import PageObjects.LanguageLearning;
import Factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class countStep {
	LanguageLearning l;
	
	@Given("navigate to the coursera home page")
	public void navigate_to_the_coursera_home_page() {
		l = new LanguageLearning(BaseClass.getDriver());

	}

	@When("the user clicks on show more")
	public void the_user_clicks_on_show_more() throws InterruptedException, Exception {
		l.clickInput();
		//l.keyActions();;
		l.input();
		l.clickShowMore();

	}

	@Then("get the languages and their count")
	public void get_the_languages_and_their_count() throws Exception
	{
		l.clickenglish();
		l.getLanguages();
		l.clickCloseButton();

	}

	@And("get the levels and their count")
	public void get_the_levels_and_their_count() throws Exception 
	{
		l.scroll1();
		l.getLevel();

	}

}
