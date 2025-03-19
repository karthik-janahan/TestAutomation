package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		WebDriverManager.chromedriver().setup(); // base
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.zoho.com/");
		driver.findElement(By.xpath("(//a[normalize-space()='Sign In'])[1]")).click();
// Enter Email
		WebElement emailField = driver.findElement(By.id("login_id"));
		emailField.sendKeys("karthikjanahan@gmail.com");

// Click Next button
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();

// Wait for Password field
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Better to use WebDriverWait instead of Thread.sleep

// Enter Password
		WebElement passwordField = driver.findElement(By.name("PASSWORD"));
		passwordField.sendKeys("Appleking@1");

// Click Next button
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();

// Wait for Login to complete
		Thread.sleep(5000); // Adjust according to network speed

// Verify login (Check if inbox is loaded)
		if (driver.getCurrentUrl().contains("zoho.com")) {
			System.out.println("Login Successful!");
			driver.close();
		} else {
			System.out.println("Login Failed!");
			driver.close();
		}

	}

}
