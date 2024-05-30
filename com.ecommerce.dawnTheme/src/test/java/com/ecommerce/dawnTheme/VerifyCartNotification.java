package com.ecommerce.dawnTheme;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import dawnObjectRepository.homePage;
import dawnObjectRepository.pdpPage;
import dawnObjectRepository.plpPage;
import genericUtility.BaseClass;
import genericUtility.propertyFileUtllity;
import genericUtility.webdriverUtility;

public class VerifyCartNotification extends BaseClass {
	String productTitle = null;
	String color = null;
	String size = null;
	String quantity = null;

	// 1: Navigate to PDP
	@Test
	public void buyProdcut() throws Exception {
		propertyFileUtllity pUtil = new propertyFileUtllity();
		String searchText = pUtil.toReadDataFromPropertyFile("search");
		productTitle = pUtil.toReadDataFromPropertyFile("productTitle");
		color = pUtil.toReadDataFromPropertyFile("color");
		size = pUtil.toReadDataFromPropertyFile("size");
		quantity = pUtil.toReadDataFromPropertyFile("quantity");
		String sortOption = pUtil.toReadDataFromPropertyFile("sortOption");
		driver.get(
				"https://themes.shopify.com/themes/dawn/styles/default/preview?surface_detail=free-themes&surface_inter_position=1&surface_intra_position=6&surface_type=collection");
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getSearchIcon().click();
		h.getSearchTextfield().sendKeys(searchText);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		plpPage p = new plpPage(driver);
		p.getAvailabilityDropdown().click();
		WebElement instock = p.getInStockCheckbox();
		Actions act = new Actions(driver);
		act.moveToElement(instock).click(instock).build().perform();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

		Select s = new Select(p.getSortbyBdropdown());
		s.selectByValue(sortOption);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[@class='card__heading h5']//a[contains(text(),'" + productTitle + "')]"))
				.click();

		pdpPage pdp = new pdpPage(driver);
		String actualTitle = pdp.getProductTitle().getText();
		Assert.assertEquals(actualTitle, productTitle, "Incorrect product is present");
	}

	// 2: Change the product values
	@Test(priority = 2, dependsOnMethods = "buyProdcut")
	public void addToCart() throws Exception {
		pdpPage pdp = new pdpPage(driver);
		webdriverUtility wUtil = new webdriverUtility();
		driver.findElement(By.xpath("//label[contains(text(),'" + this.color + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'" + this.size + "')]")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		for (int i = 0; i < this.quantity.length(); i++) {
			pdp.getQuantityButton().click();
			Actions act = new Actions(driver);
			act.click().perform();
		}
		for (int i = 0; i < 55; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);

		pdp.getAddToCartButton().click();
		Thread.sleep(2000);
		String actualProductTitle = pdp.getNotificationProductTitle().getText();
		String actualColor = pdp.getNotificationProductColor().getText();
		String actualSize = pdp.getNotificationsProductSize().getText();
		Assert.assertEquals(actualProductTitle, this.productTitle);
		Assert.assertEquals(actualColor, this.color);
		Assert.assertEquals(actualSize, this.size);
	}

	// 3: Verify view cart button functionaity
	@Test(priority = 3, dependsOnMethods = "addToCart")
	public void cartPage() {
		pdpPage pdp = new pdpPage(driver);
		pdp.getViewCartButton().click();
		dawnObjectRepository.cartPage cp = new dawnObjectRepository.cartPage(driver);
		boolean actualPage = cp.getCartTitle().isDisplayed();
		Assert.assertTrue(actualPage);
	}

}
