package com.ecommerce.dawnTheme;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

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

public class checkout extends BaseClass {

	// 1: Verify the product in the pdp
	@Test
	public void buyProdcut() throws Exception {
		propertyFileUtllity pUtil = new propertyFileUtllity();
		String searchText = pUtil.toReadDataFromPropertyFile("search");
		String shoeTitle = pUtil.toReadDataFromPropertyFile("shoeTitle");
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
		driver.findElement(By.xpath("//h3[@class='card__heading h5']//a[contains(text(),'" + shoeTitle + "')]"))
				.click();

		pdpPage pdp = new pdpPage(driver);
		String actualTitle = pdp.getProductTitle().getText();
		Assert.assertEquals(actualTitle, shoeTitle, "Incorrect product is present");
	}

	// 2: Verify add to cart functionality
	@Test(priority = 2, dependsOnMethods = "buyProdcut")
	public void addToCart() throws Exception {
		pdpPage pdp = new pdpPage(driver);
		if (pdp.getAddToCart().isDisplayed()) {
			webdriverUtility wUtil = new webdriverUtility();
			// wUtil.toScrollToParticluarWebelement(driver, pdp.getAddToCart());
			//wUtil.toScroll(driver, 0, 3000);
//			Actions act=new Actions(driver);
//			act.moveToElement(pdp.getAddToCart()).click(pdp.getAddToCart()).build().perform();
			Robot r=new Robot();
			for(int i=0; i<=55; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			//pdp.getAddToCart().click();
			driver.findElement(By.xpath("//button[@name='add']")).click();
		} else {
			Reporter.log("Product is not available", true);
		}

	}
}
