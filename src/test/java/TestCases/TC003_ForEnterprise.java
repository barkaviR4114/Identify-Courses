package TestCases;

import org.testng.annotations.Test;
import PageObjects.ForEnterprise;
import TestBase.BaseClass;

public class TC003_ForEnterprise extends BaseClass {
	
	@Test(priority=1)
	public void BackToHomePage() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.homePage();
		logger.info("-------Click on homepage-------");
	}
	
	@Test(priority=2)
	public void ClickEnterprise() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.scrollToCoursera();
		logger.info("-------Scroll down to Coursera-------");
		form.enterpriseClick();
		logger.info("-------Click on Enterprise-------");
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void ClickSolutions() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.solutionsClick();
		logger.info("-------Click on Solutions-------");
	}
	
	@Test(priority=4)
	public void ClickCampus()
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.campusClick();
		logger.info("-------Click on Coursera for Campus-------");
		form.scrollToForm();
		logger.info("-------Scroll down to forms-------");
	}
	
	@Test(priority=5)
	public void FillingForm() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.firstName();
		logger.info("-------Enter the first name-------");
		form.lastName();
		logger.info("-------Enter the last name-------");
		form.emailAddress();
		logger.info("-------Enter the Email address-------");
		form.phoneNumber();
		logger.info("-------Enter the phone number-------");
		form.institutionType();
		logger.info("-------Select the institution type-------");
		form.institutionName();
		logger.info("-------Enter the institution Name-------");
		form.jobRole();
		logger.info("-------Select the job role-------");
		form.department();
		logger.info("-------Select the department-------");
		form.selectNeeds();
		logger.info("-------Select the needs -------");
		form.country();
		logger.info("-------Select the country-------");
		form.checkBox();
		logger.info("-------Click on the checkbox-------");
		Thread.sleep(2000);	
	}
	
	@Test(priority=5)
	public void SubmitButton() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.submitButton();
		logger.info("-------Click on submit button-------");
	}
		
	@Test(priority=6)
	public void ErrorMessage() throws Exception 
	{
		ForEnterprise form= new ForEnterprise(driver);
		form.captureMessage();
		logger.info("-------Capture the error message-------");
	}

}
