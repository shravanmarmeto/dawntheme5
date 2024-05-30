package com.ecommerce.dawnTheme;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import dawnObjectRepository.homePage;
import dawnObjectRepository.pdpPage;
import dawnObjectRepository.plpPage;
import genericUtility.BaseClass;
import genericUtility.propertyFileUtllity;
import genericUtility.webdriverUtility;

public class verifyPDPPage extends BaseClass {
	String productPrice = null;
	String productTitle = null;

	// NAVIGATE TO PDP
	@Test(priority = 1)
	public void naviagteToPDP() throws Exception {
		propertyFileUtllity pUtil = new propertyFileUtllity();
		String searchText = pUtil.toReadDataFromPropertyFile("search");
		productTitle = pUtil.toReadDataFromPropertyFile("productTitle");
		String color = pUtil.toReadDataFromPropertyFile("color");
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
		p.getColorDropdown().click();
		Thread.sleep(2000);
		List<WebElement> a = driver.findElements(By.xpath(
				"//ul[@class='facets-layout facets-layout-list facets-layout-list--swatch facets__list list-unstyled']"));
		Thread.sleep(1000);
		for (WebElement b : a) {
			if (b.getText().contains(color)) {
				b.click();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				break;
			}

		}

		Select s = new Select(p.getSortbyBdropdown());
		s.selectByValue(sortOption);
		Thread.sleep(2000);
		WebElement myProduct = driver
				.findElement(By.xpath("//h3[@class='card__heading h5']//a[contains(text(),'" + productTitle + "')]"));
		if (myProduct.isDisplayed()) {
			productPrice = driver.findElement(By.xpath("//a[contains(text(),'" + productTitle
					+ "')]/parent::h3[@class='card__heading h5']/following-sibling::div[@class='card-information']//span[@class='price-item price-item--regular']"))
					.getText();
			myProduct.click();
		}
	}

	// 1: Verify product title
	@Test(priority = 2, dependsOnMethods = "naviagteToPDP")
	public void productTitle() {
		pdpPage pdp = new pdpPage(driver);
		String actualTitle = pdp.getProductTitle().getText();
		Assert.assertEquals(actualTitle, productTitle);

	}

	// 2: Verify product price
	@Test(priority = 3)
	public void productPrice() {
		pdpPage pdp = new pdpPage(driver);
		String actaualPrice = pdp.getPriceText().getText();
		Assert.assertEquals(actaualPrice, productPrice);

	}

	// 3: Verify color options in PDP
	@Test(priority = 3)
	public void productColor() {
		pdpPage pdp = new pdpPage(driver);
		boolean colorOptions = pdp.getColorOptions().isDisplayed();
		Assert.assertTrue(colorOptions);
	}

	// 4: Verify size otpions in PDP
	@Test(priority = 4)
	public void productSize() {
		pdpPage pdp = new pdpPage(driver);
		boolean sizeOptions = pdp.getSizeOptions().isDisplayed();
		Assert.assertTrue(sizeOptions);
	}

	// 5: Verify quantity otpions in PDP
	@Test(priority = 5)
	public void productQuantity() {
		pdpPage pdp = new pdpPage(driver);
		boolean quantityOptions = pdp.getQuantityOptions().isDisplayed();
		Assert.assertTrue(quantityOptions);
	}

	// 6: Verify add to cart button
	@Test(priority = 6)
	public void addToCartButton() {
		pdpPage pdp = new pdpPage(driver);
		boolean addToCartButton = pdp.getAddToCartButton().isDisplayed();
		Assert.assertTrue(addToCartButton);
	}

	// 7: Verify Buy it now button
	@Test(priority = 7)
	public void buyItNowButton() {
		pdpPage pdp = new pdpPage(driver);
		boolean buyItNowButton = pdp.getBuyItNowButton().isDisplayed();
		Assert.assertTrue(buyItNowButton);
	}
	

	// 8: Verify Matreials dropdown functionality
	@Test(priority = 8)
	public void materialsDropdown() throws Exception {
		Robot r = new Robot();
		for (int i = 0; i < 60; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		pdpPage pdp = new pdpPage(driver);
		Thread.sleep(2000);
		pdp.getMaterialsDropdown().click();
		boolean materialsDropdown = pdp.getMaterialsDropdown().isDisplayed();
		Assert.assertTrue(materialsDropdown);

	}

	// 9: Verify shipping and returns dropdown functionality
	@Test(priority = 9)
	public void shippingAndReturnsDropdown() {
		pdpPage pdp = new pdpPage(driver);
		webdriverUtility wUtil = new webdriverUtility();
		wUtil.toScrollToParticluarWebelement(driver, pdp.getShippingAndReturnsDropdown());
		pdp.getShippingAndReturnsDropdown().click();
		boolean shippingAndReturnsDropdown = pdp.getShippingAndReturnsDropdown().isDisplayed();
		Assert.assertTrue(shippingAndReturnsDropdown);

	}

	// 10: Verify care instructions dropdown functionality
	@Test(priority = 10)
	public void careInstructionsDropdown() {
		pdpPage pdp = new pdpPage(driver);
		webdriverUtility wUtil = new webdriverUtility();
		wUtil.toScrollToParticluarWebelement(driver, pdp.getCareInstructionsDropdown());
		pdp.getCareInstructionsDropdown().click();
		boolean careInstructionsDropdown = pdp.getCareInstructionsDropdown().isDisplayed();
		Assert.assertTrue(careInstructionsDropdown);

	}

	// 11: Verify share button functionality
	@Test(priority = 11)
	public void shareButton() {
		pdpPage pdp = new pdpPage(driver);
		webdriverUtility wUtil = new webdriverUtility();
		wUtil.toScrollToParticluarWebelement(driver, pdp.getShareButton());
		boolean shareButton = pdp.getShareButton().isDisplayed();
		Assert.assertTrue(shareButton);

	}

	// 12: Verify you may also like section
	@Test(priority = 12)
	public void youMayAlsoLike() throws Exception {
		Robot r = new Robot();
		for (int i = 0; i < 65; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		pdpPage pdp = new pdpPage(driver);
		boolean youMayAlsoLikeSection = pdp.getYouMayAlsoLikeThisSection().isDisplayed();
		Assert.assertTrue(youMayAlsoLikeSection);

	}

}
