/* 
 * Josh Fisher
 * CS1699 Software Testing
 * Deliverable 3
 * Web Site Testing - Amazon
 * Due: March 3, 2015
*/

/*
 * User Story 2:
 * 
 * As a shopper I want to manage my cart so that I choose the correct purchases.
 * 
 * Scenarios: 
 * 
 * 1. testAddItem
 * 		Given a products page on Amazon, when I click "Add to Cart", then the item shows up in My Cart.
 * 2. testRemoveItem
 * 		Given My Cart on Amazon, when I click "Delete" on an item, then that item is no longer in My Cart.
 * 3. testChangeItemQuantity
 * 		Given My Cart on Amazon, when I change the quantity on an item, then My Cart is updated with the updated quantity.
 * 4. testItemInCart
 * 		Given the Amazon home page, when I click My Cart, the contents of My Cart show up.
 * 5. testShippingOption
 * 		Given My Cart on Amazon, when I enter a zip code, the shipping details are updated.
 * 
*/

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ShopperTest
{
	//WebDriver driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("https://amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
				
	@Test
	public void testAddItem() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart
		driver.findElement(By.id("nav-cart")).click();
		
		//assertTextPresent "Moby Dick"
		WebElement element = driver.findElement(By.id("activeCartViewForm"));
		assertEquals(element.getText(), "Moby Dick");
		driver.quit();
	}
	
	@Test
	public void testRemoveItem() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//
		driver.findElement(By.id("nav-cart-count")).click();
		
		//Click "Remove" to remove item
		driver.findElement(By.name("submit.delete.C24K1WI0ZUJWF")).click();
		
		//Click on Cart
		driver.findElement(By.cssSelector("span.nav-action-inner")).click();
		
		//assertTextNotPresent "Moby Dick"
		try {
			WebElement element = driver.findElement(By.id("activeCartViewForm"));
			assertNotEquals(element.getText(), "Moby Dick");
		} catch (NoSuchElementException ex) {
			fail();
		}
		driver.quit();
	}
	
	@Test
	public void testChangeItemQuantity() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//
		driver.findElement(By.cssSelector("span.nav-cart-button.nav-sprite")).click();
		
		//assertTextPresent "updated to 2"
		WebElement element = driver.findElement(By.cssSelector("p.a-spacing-none.a-spacing-top-mini"));
		assertEquals(element.getText(), "Please note that the quantity of Moby Dick has been updated to 2.");
		driver.quit();
	}
	
	@Test
	public void testItemInCart() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Go to amazon.com
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		
		//Click on cart
		driver.findElement(By.id("nav-cart")).click();
		
		//assertTextPresent "Moby Dick"
		WebElement element = driver.findElement(By.id("activeCartViewForm"));
		assertEquals(element.getText(), "Moby Dick");
		driver.quit();
	}
	
	@Test
	public void testShippingOption() {
		try {
			setUp();
		} catch (Exception e) {
			fail();
		}
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		driver.findElement(By.id("result_O")).click();
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart
		driver.findElement(By.id("nav-cart")).click();
		
		//Find where to enter zip code
		driver.findElement(By.cssSelector("span.a-expander-prompt")).click();
		
		//Enter zip code 15213
		driver.findElement(By.name("zipcode")).sendKeys("15213");
		
		//Submit zip code
		driver.findElement(By.id("a-autoid-0-announce")).click();
		
		//assertTextPresent "PITTSBURGH, PENNSYLVANIA"
		WebElement element = driver.findElement(By.linkText("PITTSBURGH,PENNSYLVANIA,15213"));
		assertEquals(element.getText(), "PITTSBURGH,PENNSYLVANIA,15213");
		driver.quit();
	}
}