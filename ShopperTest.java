/*
 * User Story 2:
 * 
 * As a shopper I want to manage my cart so that I choose the correct purchases.
 * 
 * Scenarios: 
 * 
 * 		Given a products page on Amazon, when I click "Add to Cart", then the item shows up in My Cart.
 * 		Given My Cart on Amazon, when I click "Delete" on an item, then that item is no longer in My Cart.
 * 		Given My Cart on Amazon, when I change the quantity on an item, then My Cart is updated with the updated quantity.
 * 		Given the Amazon home page, when I click My Cart, the contents of My Cart show up.
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
	WebDriver driver = new FirefoxDriver();

	public void setUp() throws Exception {
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//Given a products page on Amazon, when I click "Add to Cart", then the item shows up in My Cart.
	@Test
	public void testAddItem() {
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart
		driver.findElement(By.id("nav-cart")).click();
		
		//assertTextPresent "Moby Dick"
		WebElement element = driver.findElement(By.id("activeCartViewForm"));
		assertTrue(element.getText().contains("Moby Dick"));
		driver.quit();
	}
	
	//Given My Cart on Amazon, when I click "Delete" on an item, then that item is no longer in My Cart.
	@Test
	public void testRemoveItem() {
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click add to cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart
		driver.findElement(By.id("nav-cart-count")).click();
		
		//Click "Remove" to remove item
		driver.findElement(By.name("submit.delete.C24K1WI0ZUJWF")).click();
		
		//Go to Amazon homepage
		driver.findElement(By.cssSelector("span.nav-logo-base.nav-sprite")).click();
				
		//Click on cart button
		driver.findElement(By.id("nav-cart")).click();
		
		//assertTextNotPresent "Moby Dick"
		try {
			WebElement element = driver.findElement(By.id("activeCartViewForm"));
			assertFalse(element.getText().contains("Moby Dick"));
		} catch (NoSuchElementException ex) {
			fail();
		}
		driver.quit();
	}
	
	//Given My Cart on Amazon, when I change the quantity on an item, then My Cart is updated with the updated quantity.
	@Test
	public void testChangeItemQuantity() {
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click on add to cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on text box for search and enter product (Moby Dick)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Moby Dick");
		
		//Click submit button
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click on add to cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart button
		driver.findElement(By.cssSelector("span.nav-cart-button.nav-sprite")).click();
		
		//assertTextPresent "updated to 2"
		WebElement element = driver.findElement(By.cssSelector("p.a-spacing-none.a-spacing-top-mini"));
		assertTrue(element.getText().contains("updated to 2"));
		driver.quit();
	}
	
	//Given the Amazon home page, when I click My Cart, the contents of My Cart show up.
	@Test
	public void testItemInCart() {
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Go to amazon.com
		driver.findElement(By.cssSelector("span.nav-logo-base.nav-sprite")).click();
		
		//Click on cart
		driver.findElement(By.id("nav-cart")).click();
		
		//assertTextPresent "Moby Dick"
		WebElement element = driver.findElement(By.id("activeCartViewForm"));
		assertTrue(element.getText().contains("Moby Dick"));
		driver.quit();
	}
	
	//Given My Cart on Amazon, when I enter a zip code, the shipping details are updated.
	@Test
	public void testShippingOption() {
		
		//Start at Amazon Homepage
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
		try {
			driver.findElement(By.xpath("//a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
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