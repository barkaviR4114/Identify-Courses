package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import PageObjects.WebDevelopment;
import TestBase.BaseClass;

public class TC001_IdentifyCourses extends BaseClass {
	
	
	@Test(priority=1)
	public void InputSearch() throws IOException
	{
		WebDevelopment wd = new WebDevelopment(driver);
		wd.inputBox();
		logger.info("-------Input is given in the InputBox-------");
		wd.searchButton();
		logger.info("-------The search button is clicked-------");
	}
	
	@Test(priority=2)
	public void Selection() throws IOException, InterruptedException
	{
		WebDevelopment wd = new WebDevelopment(driver);
		wd.clickBeginner();
		logger.info("-------Beginner is clicked-------");
		wd.clickEnglish();
		logger.info("-------English is clicked-------");
		wd.scrollToTop();
		logger.info("-------Current page scrolled to top-------");
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void PrintCourses1() throws IOException
	{
		WebDevelopment wd = new WebDevelopment(driver);
		wd.course1();
		logger.info("-------Course1 is clicked-------");
		wd.childPage();
		logger.info("-------Current page is directed to child page-------");
		wd.courseDetails1();
		logger.info("-------Print the course1 details-------");
		captureScreen("Details1");
		logger.info("-------The screenshot is captured-------");
		wd.parentPage();
		logger.info("-------Again redirect to parent page-------");
	}
	
	@Test(priority=4)
	public void PrintCourses2() throws IOException
	{
		WebDevelopment wd = new WebDevelopment(driver);
		wd.course2();
		logger.info("-------Course2 is clicked-------");
		wd.childPage();
		logger.info("-------Current page is directed to child page-------");
		wd.courseDetails2();
		logger.info("-------Print the course2 details-------");
		captureScreen("Details2");
		logger.info("-------The screenshot is captured-------");
		wd.parentPage();
		logger.info("-------Again redirect to parent page-------");
	}

}
