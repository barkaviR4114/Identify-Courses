package TestBase;


import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public  static Properties p;
	
	@BeforeTest
	@Parameters({"os","browser"})
	public WebDriver setUp (String os, String br) throws IOException{

		//Loading property file
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		//loading log4j file
		logger= LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os.....");
			}
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");
						break;
			case "edge":cap.setBrowserName("MicrosoftEdge");
						break;
			default:System.out.println("No matching browser....");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		else if(p.getProperty("execution_env").equals("local")) {
			switch(br) 
			{
			case "chrome": driver=new ChromeDriver();
			                break;
			case "edge": driver=new EdgeDriver();
			                 break;
			case "firefox":driver=new FirefoxDriver();
			                 break;
			}
		}
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;

	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


}
