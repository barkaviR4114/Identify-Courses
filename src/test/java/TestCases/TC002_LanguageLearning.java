package TestCases;

import org.testng.annotations.Test;
import PageObjects.LanguageLearning;
import TestBase.BaseClass;

public class TC002_LanguageLearning extends BaseClass{
	
	@Test(priority=1)
	public void ClearInput() throws Exception
	{
		LanguageLearning lan = new LanguageLearning(driver);
		lan.clickInput();
		logger.info("-------Click the input box-------");
		lan.keyActions();
		logger.info("-------Clear the input box-------");
	}
	
	@Test(priority=2)
	public void NewInputSearch() throws Exception
	{
		LanguageLearning lan = new LanguageLearning(driver);
		lan.input();
		logger.info("-------Another input is given to the inputbox-------");
	}
	
	@Test(priority=3)
	public void PrintLanguages() throws Exception
	{
		LanguageLearning lan = new LanguageLearning(driver);
		lan.clickShowMore();
		logger.info("-------Click on show more-------");
		lan.clickenglish();
		logger.info("-------Deselect english-------");
		lan.getLanguages();
		logger.info("-------Get all the Languages present-------");
	}
	
	@Test(priority=4)
	public void CloseButton() throws InterruptedException
	{
		LanguageLearning lan = new LanguageLearning(driver);
		lan.clickCloseButton();
		logger.info("-------Click the close button-------");
		Thread.sleep(2000);
	}
	
	@Test(priority=5)
	public void PrintLevel() throws Exception
	{
		LanguageLearning lan = new LanguageLearning(driver);
		lan.scroll1();
		logger.info("-------Scroll down the page-------");
		lan.getLevel();
		logger.info("-------Get all the levels present-------");
	}

}
