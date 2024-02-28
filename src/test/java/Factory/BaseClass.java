package Factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	static ChromeOptions options = new ChromeOptions();
	
	public static WebDriver initializeBrowswe() throws Exception {
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				driver=new ChromeDriver();
				break;
				
			case "firefox":
				driver=new FirefoxDriver();
				break;
				
			default:
				driver = new EdgeDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Properties getProperties() throws IOException 
	{
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static void ScreenShots(String fileName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\screenshot\\" + fileName);
		FileUtils.copyFile(src, trg);

	}


}




