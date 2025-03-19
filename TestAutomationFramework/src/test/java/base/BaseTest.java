package base;

import org.testng.annotations.AfterMethod;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fReader;
	public static FileReader locReader;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver==null) {
			FileReader fReader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
			prop.load(fReader);
			FileReader locReader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
			loc.load(locReader);
			
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.zoho.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		} 
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}

}
