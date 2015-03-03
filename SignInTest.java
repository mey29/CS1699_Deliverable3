/*
 * User Story 2:
 * 
 * As a user of Amazon I want to be able to sign in so that I can make purchases. 
 * 
 * Scenarios:
 * 
 * 	Given the Amazon sign-in page, when I enter the correct username and password, then I am signed into my account.
 * 	Given the Amazon sign-in page, when I enter the incorrect username and password, then I am not signed into my account and receive an error message.
 * 	Given the Amazon sign-in page, when I enter the incorrect username and correct password, then I am not signed into my account and receive an error message.
 *  Given the Amazon sign-in page, when I enter the correct username and incorrect password, then I am not signed into my account and receive an error message.
 */

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInTest {

	/*
	 * Given the Amazon sign-in page, when I enter the correct username and
	 * password, then I am signed into my account.
	 */
	@Test
	public void testCorrectInput() {

		// Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Travel to sign-in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.name("email")).sendKeys(
				"softwaretesting1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - signed in
		WebElement element = driver.findElement(By.id("nav-your-amazon"));
		assertEquals(element.getText(), "Software's Amazon.com");
		driver.quit();
	}

	/*
	 * Given the Amazon sign-in page, when I enter the incorrect username and
	 * password, then I am not signed into my account and receive an error
	 * message.
	 */
	@Test
	public void testIncorrectOutput() {

		// Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("test");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_warning"));
		assertNotNull(element);
		driver.quit();
	}

	/*
	 * Given the Amazon sign-in page, when I enter the incorrect username and
	 * correct password, then I am not signed into my account and receive an
	 * error message.
	 */
	@Test
	public void testWrongUsername() {

		// Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_warning"));
		assertNotNull(element);
		driver.quit();
	}

	/*
	 * Given the Amazon sign-in page, when I enter the correct username and
	 * incorrect password, then I am not signed into my account and receive an
	 * error message.
	 */
	@Test
	public void testWrongPassword() {

		// Create new driver with base URL at amazon.com
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Travel to sign in page
		driver.findElement(By.id("nav-your-account")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("1699@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("test");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Test Case - NOT signed in
		WebElement element = driver.findElement(By.id("message_warning"));
		assertNotNull(element);
		driver.quit();
	}
}
