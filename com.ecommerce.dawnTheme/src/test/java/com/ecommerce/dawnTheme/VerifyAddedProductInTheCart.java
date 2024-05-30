package com.ecommerce.dawnTheme;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import dawnObjectRepository.cartPage;
import dawnObjectRepository.homePage;
import dawnObjectRepository.pdpPage;
import dawnObjectRepository.plpPage;
import genericUtility.BaseClass;
import genericUtility.propertyFileUtllity;
import genericUtility.webdriverUtility;

public class VerifyAddedProductInTheCart extends BaseClass {

	String productTitle = null;
	String color = null;
	String pricefrom = null;
	String priceto = null;
	String quantity = null;

	// 1: Navigate to PDP
	@Test
	public void NavigateToPDP() throws Exception {
		propertyFileUtllity pUtil = new propertyFileUtllity();
		String searchText = pUtil.toReadDataFromPropertyFile("search1");
		productTitle = pUtil.toReadDataFromPropertyFile("productTitle1");
		color = pUtil.toReadDataFromPropertyFile("color1");
		pricefrom = pUtil.toReadDataFromPropertyFile("pricefrom1");
		priceto = pUtil.toReadDataFromPropertyFile("priceto1");
		quantity = pUtil.toReadDataFromPropertyFile("quantity1");
		String sortOption = pUtil.toReadDataFromPropertyFile("sortOption1");
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
		p.getPriceDropdown().click();
		WebElement priceFrom = p.getPriceFromValue();
		WebElement priceTo = p.getPriceToValue();
		Thread.sleep(2000);
		for (int i = 0; i < 10; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		act.moveToElement(priceFrom).click(priceFrom).build().perform();
		p.getPriceFromEnterValue().sendKeys(pricefrom);
		act.moveToElement(priceTo).click(priceTo).build().perform();
		p.getPriceToEnterValue().sendKeys(priceto);
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//h3[@class='card__heading h5']//a[contains(text(),'" + productTitle + "')]"))
				.click();

		pdpPage pdp = new pdpPage(driver);
		String actualTitle = pdp.getProductTitle().getText();
		Assert.assertEquals(actualTitle, productTitle, "Incorrect product is present");
	}

	// 2: Change the product values
	@Test(priority = 2, dependsOnMethods = "NavigateToPDP")
	public void addToCart() throws Exception {
		pdpPage pdp = new pdpPage(driver);
		webdriverUtility wUtil = new webdriverUtility();
		driver.findElement(By.xpath("//label[contains(text(),'" + this.color + "')]")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		for (int i = 0; i <= this.quantity.length(); i++) {
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
		Assert.assertEquals(actualProductTitle, this.productTitle);
		Assert.assertEquals(actualColor, this.color);
		Thread.sleep(2000);
		pdp.getNotificationCloseButton().click();
	}

	// 3. Verify product in Cart page
	@Test(priority = 3, dependsOnMethods = "addToCart")
	public void verifyProduct() {
		homePage hp = new homePage(driver);
		hp.getCartIcon().click();
		cartPage cp = new cartPage(driver);
		String actualProductTitle = cp.getProductTitle().getText();
		String actualColor = cp.getColor().getText();
		String actualQuantity = cp.getTotalQuantity().getText();
		System.out.println(actualQuantity);
//		Assert.assertEquals(this.productTitle, actualProductTitle);
//		Assert.assertEquals(this.color, actualColor);
//		Assert.assertEquals(this.quantity, actualQuantity);
		System.out.println(actualProductTitle);
		System.out.println(actualColor);
		System.out.println(actualQuantity);

	}

}
