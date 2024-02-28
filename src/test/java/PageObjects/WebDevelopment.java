package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class WebDevelopment extends BasePage {
	
	Set<String> windowIds;
	List<String> win;
	String parent,child;
	String courseName1,courseName2;
	
	public WebDevelopment(WebDriver driver)
	{
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions ac = new Actions(driver);
	
	@FindBy(xpath = "//input[@class='react-autosuggest__input']")
	public
	WebElement inputBox;
	
	@FindBy(xpath= "(//div[@class='magnifier-wrapper'])[2]")
	public
	WebElement searchButton;
	
	@FindBy(xpath= "//span[text()='Beginner']")
	public
	WebElement beginner;
	
	@FindBy(xpath= "//span[text()='English']")
	public
	WebElement english;
	
	@FindBy(xpath="(//h3[starts-with(@class,'cds-CommonCard')])[1]")
	public
	WebElement course1;
	
	@FindBy(xpath="(//div[starts-with(@class,'cds-119 cds-Typography-base css-h')])[6]")
	public
	WebElement rating1;

	@FindBy(xpath="(//div[starts-with(@class,'cds-119 cds-Typography-base css-h')])[8]")
	public
	WebElement duration1;
	
	@FindBy(xpath="(//h3[starts-with(@class,'cds-CommonCard')])[2]")
	public
	WebElement course2;
		
	@FindBy(xpath="(//div[starts-with(@class,'cds-119 cds-Typography-base css-h')])[1]")
	public
	WebElement rating2;

	@FindBy(xpath="//div[starts-with(@class,'cds-119 css-1h')]")
	public
	WebElement duration2;
	
	public void inputBox() throws IOException
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		inputBox.sendKeys(inputData[0]);
	}
	
	public void searchButton()
	{
		searchButton.click();
	}
	
	public void clickEnglish()
	{
		ac.moveToElement(english).click().perform();
	}
	
	public void clickBeginner()
	{
		beginner.click();
	}
	
	public void scrollToTop()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public void course1() throws IOException
	{
		courseName1=course1.getText();
		ac.moveToElement(course1).click().perform();
		System.out.println("Course Name:"+courseName1);
		ExcelUtils.writeData("Sheet2", 0, 0, courseName1);
	}
	
	public void childPage()
	{
		windowIds =driver.getWindowHandles();
		win = new ArrayList<String>(windowIds);
		parent =win.get(0);
		child = win.get(1);
		driver.switchTo().window(child);
	}
	
	public void courseDetails1() throws IOException
	{
		String courseRating = rating1.getText();
		System.out.println("Rating:"+courseRating);
		ExcelUtils.writeData("Sheet2", 0, 1, courseRating);
		String courseDuration = duration1.getText();
		System.out.println("Duration:"+courseDuration);
		ExcelUtils.writeData("Sheet2", 0, 2, courseDuration);
	}
	
	public void course2() throws IOException
	{
		courseName2=course2.getText();
		ac.moveToElement(course2).click().perform();
		System.out.println("Course Name:"+courseName2);
		ExcelUtils.writeData("Sheet2", 1, 0, courseName2);
	}

	public void courseDetails2() throws IOException
	{
		String courseRating = rating2.getText();
		System.out.println("Rating:"+courseRating);
		ExcelUtils.writeData("Sheet2", 1, 1, courseRating);
		String courseDuration = duration2.getText();
		System.out.println("Duration:"+courseDuration);
		ExcelUtils.writeData("Sheet2", 1, 2, courseDuration);
	}
	
	public void parentPage()
	{
		driver.close();
		driver.switchTo().window(parent);
	}

}
