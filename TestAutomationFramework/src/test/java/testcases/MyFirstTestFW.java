package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLdata;

public class MyFirstTestFW extends BaseTest{
	
	
	@Test(dataProviderClass = ReadXLdata.class,dataProvider = "DataDrivenTest")
	public static void Login(String username,String password) throws InterruptedException
	{
		
		System.out.println("Url Loaded successfully");
		driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
		// Enter Email
				WebElement emailField = driver.findElement(By.id(loc.getProperty("email_field")));
				//emailField.sendKeys(prop.getProperty("userid"));
				emailField.sendKeys(username);
		// Click Next button
				driver.findElement(By.xpath(loc.getProperty("next_button"))).click();

		// Wait for Password field
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Better to use WebDriverWait instead of Thread.sleep

		// Enter Password
				WebElement passwordField = driver.findElement(By.name(loc.getProperty("pwd_field")));
				//passwordField.sendKeys(prop.getProperty("password"));
				passwordField.sendKeys(password);

		// Click Next button
				driver.findElement(By.xpath(loc.getProperty("next_button"))).click();

		// Wait for Login to complete
				Thread.sleep(5000); // Adjust according to network speed

		// Verify login (Check if inbox is loaded)
				if (driver.getCurrentUrl().contains("zoho")) {
					System.out.println("Login Successful!");
					driver.close();
				} else {
					System.out.println("Login Failed!");
					driver.close();
				}		
		
		
	}
	
/*	@DataProvider ()
	public Object[][] tdata() 
	{
	    return new Object [][] {
	    	{"karthikjanahan@gmail.com","Appleking@2" },
	    	{"karthik@gmail.com","Appleking@1" },
	    	{"karthikjanahan@gmail.com","Appleking@1" }
	    };*/
	    		
	    		
	}


