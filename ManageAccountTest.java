/*
 * User Story 3:
 * 
 * As a user of Amazon I want to manage my account so that I can have up-to-date information and I am aware of account balances. 
 * 
 * Scenarios:
 * 
 *  Given a signed in Amazon account page, when I click "Return or replace items," then past ordered items may be replaced. * 	Given a signed in Amazon account page, when I click "Change Account Settings," then my name can be updated.
 * 	Given a signed in Amazon account page, when I click "Product Availability Alerts," then all alerts associated with the account will be listed.
 * 	Given a signed in Amazon account page, when I click "View Archived Orders," then I see a list of order history.
 * 	Given a signed in Amazon account page, when I click "View Gift Card Balance," then my current gift card balance is displayed.
 * 	Given a signed in Amazon account page, when I click "Manage Payment Options," then a list of payment methods for my account is displayed.
 * 	Given a signed in Amazon account page, when I click "View and Edit Your Browsing History," then all recently viewed items appear.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageAccountTest {

	// Create new WebDriver
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {

		// Base URL of WebDriver at amazon.com
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Travel to sign in page
		driver.findElement(By.id("nav-signin-text")).click();

		// DEPENDENT ON SIGNING IN CORRECTLY
		driver.findElement(By.id("ap_email")).sendKeys(
				"softwaretesting1699@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("testingcs");
		driver.findElement(By.id("signInSubmit-input")).click();
		driver.findElement(
				By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2"))
				.click();
	}

	// Given a signed in Amazon account page, when I click
	// "Return or replace items," then past ordered items may be replaced.
	@Test
	public void testReturnItems() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "Return or replace items"
		driver.findElement(By.linkText("Return or replace items")).click();

		// Test Case
		assertTrue(driver.getPageSource().contains("Returns Center"));
		driver.quit();
	}

	// Given a signed in Amazon account page, when I click
	// "Change Account Settings," then my name can be updated.
	@Test
	public void testAddAddress() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "Add New Address"
		driver.findElement(By.linkText("Add New Address")).click();

		// Add a new address
		driver.findElement(By.id("enterAddressFullName")).sendKeys("Software");
		driver.findElement(By.id("enterAddressAddressLine1")).sendKeys(
				"4200 Fifth Avenue");
		driver.findElement(By.id("enterAddressCity")).sendKeys("Pittsburgh");
		driver.findElement(By.id("enterAddressStateOrRegion")).sendKeys(
				"Pennsylvania");
		driver.findElement(By.id("enterAddressPostalCode")).sendKeys("15260");
		driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys(
				"4126244141");
		driver.findElement(By.id("myab_newAddressButton")).click();

		// Test Case
		WebElement element = driver.findElement(By.id("myab-alert-bar-title"));
		assertNotNull(element);
		driver.quit();
	}

	// Given a signed in Amazon account page, when I click
	// "Product Availability Alerts," then all alerts associated with the
	// account will be listed.
	@Test
	public void testAvailabilityAlerts() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "Product Availability Alerts"
		driver.findElement(By.linkText("Product Availability Alerts")).click();

		// Test Case
		assertTrue(driver.findElement(By.className("small")).getText()
				.matches("You do not have any alerts."));
		driver.quit();
	}

	// Given a signed in Amazon account page, when I click
	// "View Archived Orders," then I see a list of order history.
	@Test
	public void testViewOrders() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "View Archived Orders"
		driver.findElement(By.linkText("View Archived Orders")).click();

		// Test Case
		assertTrue(driver
				.findElement(By.id("ordersContainer"))
				.getText()
				.matches(
						"There are no archived orders in your account. View all orders"));
		driver.quit();
	}

	// Given a signed in Amazon account page, when I click
	// "View Gift Card Balance," then my current gift card balance is displayed.
	@Test
	public void testViewGiftCardBalance() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "View Gift Card Balance"
		driver.findElement(By.linkText("View Gift Card Balance")).click();

		// Test Case
		assertTrue(driver.getPageSource().contains("$0.00"));
		driver.quit();
	}

	// Given a signed in Amazon account page, when I click
	// "Manage Payment Options," then a list of payment methods for my account
	// is displayed.
	@Test
	public void testPaymentOptions() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		// Click on "Manage Payment Options"
		driver.findElement(By.linkText("Manage Payment Options")).click();

		// Test Case
		assertTrue(driver
				.findElement(By.id("subHeaderLeftCol"))
				.getText()
				.matches(
						"Here are the payment methods stored in your Amazon account."));
	}

	// Given a signed in Amazon account page, when I click
	// "View and Edit Your Browsing History," then all recently viewed items
	// appear.
	@Test
	public void testBrowsingHistory() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}

		// Click on "View and Edit Your Browsing History"
		driver.findElement(By.linkText("View and Edit Your Browsing History"))
				.click();

		// Test Case
		assertTrue(driver.getPageSource().contains(
				"You have no recently viewed items to display."));
		driver.quit();
	}
}
