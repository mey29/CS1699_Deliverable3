/*
 * User Story 3:
 * 
 * As a searcher I want to find products so that I can purchase them.
 * 
 * Scenarios: 
 * 
 * 1. testSearchBar
 * 		Given the Amazon home page, when I enter a product's name in the search bar and press enter, then the product shows up in the results.
 * 2. testDepartment
 * 		Given the Amazon home page, when I click through the correct departments, the product shows up.
 * 3. testSearchGoogle
 * 		Given the Google home page, when I click the search bar and enter a specific product and the word "amazon" and press enter, then a link to the product's page on amazon shows up in the results.
 * 
*/

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearcherTest
{
	//WebDriver driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
			
	@Test
	public void testSearchBar(){
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Mockingjay)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mockingjay");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_2")).click();
		
		//assertTextPresent "Mockingjay"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
		
	@Test
	public void testDepartment(){
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click Department
		driver.findElement(By.cssSelector("span.nav-button-title.nav-button-line2")).click();
		
		//Click Movies & TV
		driver.findElement(By.linkText("Movies & TV")).click();
		
		//Click on Mockinjay in Bestsellers?
		
		//assertTextPresent "Mockingjay"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
	
	@Test
	public void testSearchGoogle(){
		try {
			driver.get("https://google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			fail();
		}
		
		//Click on Google search bar and enter "Amazon and product" (Mockingjay)
		driver.findElement(By.id("lst-ib")).sendKeys("Amazon Mockingjay Bluray");
		
		//Click submit button
		driver.findElement(By.name("btnG")).click();
		
		//Click on first result
		driver.findElement(By.linkText("http://www.amazon.com/The-Hunger-Games-Mockingjay-Blu-ray/dp/B00PYLT4YI")).click();
		
		//assertTextPresent "Mockingjay"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
}