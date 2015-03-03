/*
 * User Story 1:
 * 
 * As a student I want to be able to search for textbooks so that I can purchase them.
 * 
 * Scenarios: 
 * 
 * 1. testSearchISBN
 * 		Given the Amazon home page, when I enter the textbook's ISBN number, then the correct textbook shows up in the results.
 * 2. testSearchWrongISBN
 * 		Given the Amazon home page, when I enter an incorrect ISBN number, then the correct textbook does not show up in the results.
 * 3. testSearchAuthor
 * 		Given the Amazon home page, when I enter the textbook's author's name, then the correct textbook shows up in the results.
 * 4. testSearchWrongAuthor
 * 		Given the Amazon home page, when I enter the textbook's author's name incorrectly, then the correct textbook does not show up in the results.
 * 5. testSearchName
 * 		Given the Amazon home page, when I enter the textbook's name, then the correct textbook shows up in the results.
 * 6. testSearchPublisher
 * 		Given the Amazon home page, when I enter the textbook's publisher's name, then the correct textbook shows up in the results.
 * 
*/

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StudentTest
{
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
			
	@Test
	public void testSearchISBN() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on text box for search and enter product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("978-0672327988");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextPresent "Software Testing"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
	
	@Test
	public void testSearchWrongISBN() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on text box for search and enter product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("978-0321385178");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextNotPresent "Software Testing"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertNotEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
	
	@Test
	public void testSearchAuthor() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on text box for search and enter product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ron Patton");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextPresent "Software Testing"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
	
	@Test
	public void testSearchWrongAuthor() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on text box for search and enter product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ron Paten");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextNotPresent "Software Testing"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertNotEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
	
	@Test
	public void testSearchName() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Software Testing 2nd Edition");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextPresent "Software Testing" (2nd result)
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
	
	@Test
	public void testSearchPublisher() {
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on text box for search and enter product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Sams Publishing Software Testing");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
	
		//assertTextPresent "Software Testing"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "Software Testing (2nd Edition)");
		driver.quit();
	}
}