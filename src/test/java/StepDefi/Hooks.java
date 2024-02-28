package StepDefi;


import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Factory.BaseClass;
import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	 Properties p;
	 @Before
     public void setup() throws Exception {
	   	driver=BaseClass.initializeBrowswe();
	   	p = BaseClass.getProperties();
	   	driver.get(p.getProperty("appURL"));
	   	driver.manage().window().maximize();
	}
 
   @After
   public void tearDown(Scenario scenario) {
      driver.quit();
   }
   @AfterStep
   public void addScreenshot(Scenario scenario) {
 
       if(!scenario.isFailed()) {
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());
       }
   }
}
