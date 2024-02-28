package PageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtils;

public class ForEnterprise extends BasePage{
	
	public ForEnterprise(WebDriver driver) 
	{
		super(driver);
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;

	
	@FindBy(xpath="//img[@alt='Coursera']")
	public
	WebElement home;
	
	@FindBy(xpath = "//p[text() ='Coursera']")
	public
	WebElement scroll1;
	
	@FindBy(xpath = "//a[text()='For Enterprise']")
	public
	WebElement enterprise;
	
	@FindBy(xpath = "//a[text()='Solutions']")
	public
	WebElement solutions;
	
	@FindBy(xpath = "//p[text()='Coursera for Campus']")
	public
	WebElement campus;
	
	@FindBy(xpath = "//h2[text()='Here’s how innovative universities are using Coursera for Campus']")
	public
	WebElement scroll2;
	
    //First Name
	@FindBy(name = "FirstName")
	public
	WebElement fName;

    //Last Name
	@FindBy(name = "LastName")
	public
	WebElement lName;
  
    //Work Email Address
	@FindBy(name = "Email")
	public
	WebElement email;

    //Phone Number
	@FindBy(name = "Phone")
	public
	WebElement phone;
    
    //Institution Type
	@FindBy(name = "Institution_Type__c")
	public
	WebElement iType;

    //Institution Name
	@FindBy(name = "Company")
	public
	WebElement iName;
    
    //Job Role
	@FindBy(name = "Title")
	public
	WebElement job;

    //Department
	@FindBy(name = "Department")
	public
	WebElement dept;
    
    //Describes your needs
	@FindBy(name ="What_the_lead_asked_for_on_the_website__c")
	public
	WebElement needs;
    
    //Country
	@FindBy(name = "Country")
	public
	WebElement countries;
	
	// Terms and condition
	@FindBy(name="Express_Consent__c")
	public
	WebElement box;
    
    //Submit Button
	@FindBy(xpath ="//button[text()='Submit']")
	public
	WebElement submit;
	
	//Error Message
	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	WebElement Error;
	
	public void homePage()
	{
		home.click();
	}

	public void scrollToCoursera() 
	{
		js.executeScript("arguments[0].scrollIntoView();",scroll1);
	}
	
	public void enterpriseClick()
	{
		enterprise.click();
	}
	
	public void solutionsClick()
	{
		solutions.click();
	}
	
	public void campusClick()
	{
		campus.click();
	}
	
	public void scrollToForm()
	{
		js.executeScript("arguments[0].scrollIntoView();",scroll2);
	}
	
	public void firstName () throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		fName.sendKeys(inputData[2]);
	}
	
	public void lastName () throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		lName.sendKeys(inputData[3]);
	}
	
	public void emailAddress () throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		email.sendKeys(inputData[4]);
	}
	
	public void phoneNumber () throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		phone.sendKeys(inputData[5]);
	}
    
	public void institutionType() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		Select institutionType = new Select(iType);
		institutionType.selectByValue(inputData[6]);
	}
	
	public void institutionName() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		iName.sendKeys(inputData[7]);
	}
	
	public void jobRole() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		Select jobRole = new Select(job);
		jobRole.selectByValue(inputData[8]);
	}
	
	public void department() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		Select department = new Select(dept);
		department.selectByValue(inputData[9]);
	}
	
	public void selectNeeds() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		Select selectNeeds = new Select(needs);
		selectNeeds.selectByValue(inputData[10]);
	}
	
	public void country() throws IOException 
	{
		String[] inputData = ExcelUtils.readExcelData("sheet1", 0);
		Select country = new Select(countries);
		country.selectByValue(inputData[11]);
	}
	
	public void checkBox()
	{
		box.click();
	}
	
	public void submitButton() 
	{
		//submit.click();
		js.executeScript("arguments[0].click();", submit);
	 
	}
	
	public void captureMessage() throws Exception
	{
		String Message = Error.getText();
		System.out.println(Message);
		ExcelUtils.writeData("Sheet2", 0, 3, Message);
	}
	
	



}
