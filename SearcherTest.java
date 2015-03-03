/*
 * User Story 3:
 * 
 * As a searcher I want to find products so that I can purchase them.
 * 
 * Scenarios: 
 *
 * 		Given the Amazon home page, when I enter a product's name in the search bar and press enter, then the product shows up in the results.
 * 		Given the Amazon home page, when I click through the correct departments and search within that department, the product shows up.
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
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	//Given the Amazon home page, when I enter a product's name in the search bar and press enter, then the product shows up in the results.
	@Test
	public void testSearchBar(){
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//li[3]/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertTextPresent "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
		
	//Given the Amazon home page, when I click through the correct departments and search within that department, the product shows up.
	@Test
	public void testDepartment(){
		
		//Start at Amazon Homepage
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click Department
		driver.findElement(By.cssSelector("span.nav-button-title.nav-button-line2")).click();
		
		//Click Movies & TV
		driver.findElement(By.linkText("Movies & TV")).click();
		
		//Click on text box for search and enter product (Mockingjay)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mockingjay blu ray");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertTextPresent "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
	
	//Given the Google home page, when I click the search bar and enter a specific product and the word "amazon" and press enter, then a link to the product's page on amazon shows up in the results.
	@Test
	public void testSearchGoogle(){
		
		//Start at Google Homepage
		try {
			driver.get("http://google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			fail();
		}
		
		//Click on Google search bar and enter "Amazon and product" (Mockingjay)
		driver.findElement(By.id("lst-ib")).sendKeys("Amazon Mockingjay Bluray");
		
		//Click submit button
		driver.findElement(By.name("btnG")).click();
		
		//Click on first result
		driver.findElement(By.xpath("//div/h3/a")).click();
		
		//assertTextPresent "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]"
		WebElement element = driver.findElement(By.id("productTitle"));
		assertEquals(element.getText(), "The Hunger Games: Mockingjay - Part 1 [Blu-ray + DVD + Digital HD]");
		driver.quit();
	}
}