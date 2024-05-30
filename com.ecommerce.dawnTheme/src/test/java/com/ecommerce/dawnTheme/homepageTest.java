package com.ecommerce.dawnTheme;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dawnObjectRepository.homePage;
import genericUtility.BaseClass;
import genericUtility.iConstantUtility;
import genericUtility.webdriverUtility;

public class homepageTest extends BaseClass {

	webdriverUtility wUtil = new webdriverUtility();
	SoftAssert soft = new SoftAssert();

	// 1: Verify if user navigates to the Home page by entering valid URL
	@Test(priority = 1)
	public void homepageSuccess() {
		driver.get(iConstantUtility.dawn);
		String expectedUrl = iConstantUtility.dawn;
		String actualUrl = driver.getCurrentUrl();
		soft.assertEquals(expectedUrl, actualUrl, "Improper URL");
		System.out.println("Homepage Url: " + actualUrl);
	}

	// 2: Verify if the error message is displayed by entering inavlidURL
	@Test(priority = 2)
	public void homepageError() {
		driver.get("https://themes.shopify.com/themes/dawn/styles/default/previ");
		String expectedError = "The page you’re looking for could not be found";
		String actualError = driver.findElement(By.xpath("//h3[@class='block__heading heading--3']")).getText();
		soft.assertEquals(expectedError, actualError);
		System.out.println("Homepage Error Message: " + actualError);
	}

	// 3: Verify that the announcement banner is present in the home page
	@Test(priority = 3)
	public void announcementBar() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean announcementBanner = h.getAnnouncementBar().isDisplayed();
		soft.assertTrue(announcementBanner, "Announcement bar is missing");
		System.out.println("Announcement Bar text: " + h.getAnnouncementBar().getText());
	}

	// 4: Verify DAWN logo in the home page
	@Test(priority = 4)
	public void dawnLogo() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean logo = h.getDawnLogo().isDisplayed();
		soft.assertTrue(logo, "Logo not found");
		System.out.println("Logo is displayed: " + h.getDawnLogo().getText());
	}

	// 5: Verify the Bags drop down
	@Test(priority = 5)
	public void bagsDropdown() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean bagsDropdown = h.getBagsDropdown().isDisplayed();
		soft.assertTrue(bagsDropdown, "Bags dropdown is missing");
		System.out.println("Bags Megamenu dropdown is present");

	}

	// 6: Verify the user is able to select any options from the Bags dropdown
	@Test(priority = 6)
	public void bagsDropdownSelect() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getBagsDropdown().click();
		 String text = "Tote bags";
		driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-1']//a[contains(text(),'" + text + "')]")).click();
		String actualText = driver.findElement(By.xpath("//h1[@class='collection-hero__title']")).getText();
		soft.assertEquals(text, actualText);
//		List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@id='HeaderMenu-MenuList-1']"));
//		for (int i = 1; i < dropdown.size(); i++) {
//			if (driver.findElement(By.xpath(
//					"(//a[@class='header__menu-item list-menu__item link link--text focus-inset caption-large'])[" + i
//							+ "]"))
//					.isDisplayed())
//				driver.findElement(By.xpath(
//						("(//a[@class='header__menu-item list-menu__item link link--text focus-inset caption-large'])[1]")))
//						.click();
//			driver.navigate().back();
//		}

	}

	// 7: Verify the shoes drop down
	@Test(priority = 7)
	public void shoesDropdown() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean shoesDropdown = h.getShoesDropdown().isDisplayed();
		soft.assertTrue(shoesDropdown, "Bags dropdown is missing");

	}

	// 8: Verify the user is able to select any options from the Bags dropdown
	@Test(priority = 8)
	public void shoesDropdownSelect() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getShoesDropdown().click();
		String text = "Shop all";
		driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-2']//a[contains(text(),'" + text + "')]")).click();
		String actualText = driver.findElement(By.xpath("//h1[@class='collection-hero__title']")).getText();
		soft.assertEquals(text, actualText);
	}

	// 9: Verify the look book link in the home page
	@Test(priority = 9)
	public void lookBook() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean lookBook = h.getLookBookLink().isDisplayed();
		soft.assertTrue(lookBook, "LookBook link is missing");
	}

	// 10: Verify the search icon in the header section
	@Test(priority = 10)
	public void searchIcon() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean searchIcon = h.getSearchIcon().isDisplayed();
		soft.assertTrue(searchIcon, "Search icon is missing");
	}

	// 11: Verify profile icon in the header section
	@Test(priority = 11)
	public void profileIcon() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean profileIcon = h.getProfileIcon().isDisplayed();
		soft.assertTrue(profileIcon, "Search icon is missing");
	}

	// 12: Verify cart icon in the header section
	@Test(priority = 12)
	public void cartIcon() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean cartIcon = h.getCartIcon().isDisplayed();
		soft.assertTrue(cartIcon, "Search icon is missing");
	}

	// 13: Verify Shop now button in the Hero banner (product - landing page)
	@Test(priority = 13)
	public void shopNowButton() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getShopnowButton());
		h.getShopnowButton().click();
		String expectedPage = "Products";
		String actualPage = driver.findElement(By.xpath("//h1[@class='collection-hero__title']")).getText();
		soft.assertEquals(expectedPage, actualPage, "Invalid page displayed");
	}

	// 14: Verify back in stock section
	@Test(priority = 14)
	public void backInStock() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		boolean backInStock = h.getBackInStockSection().isDisplayed();
		soft.assertTrue(backInStock);
	}

	// 15:Verify Bags link in the footer section
	@Test(priority = 15)
	public void bagsLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getBagsLink());
		boolean bagsLink = h.getBagsLink().isDisplayed();
		soft.assertTrue(bagsLink);
	}

	// 16:Verify clicking on Bags link is redirected toBags page
	@Test(priority = 16, dependsOnMethods = "bagsLinkFooter")
	public void bagsPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getBagsLink().click();
		String expectedPage = "Bags";
		String actualPage = driver.findElement(By.xpath("//h1[@class='collection-hero__title']")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 17:Verify Shoes link in the footer section
	@Test(priority = 17)
	public void shoesLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getShoesLink());
		boolean shoesLink = h.getShoesLink().isDisplayed();
		soft.assertTrue(shoesLink);
	}

	// 18:Verify clicking on Shoes link is redirected to Shoes page
	@Test(priority = 18, dependsOnMethods = "shoesLinkFooter")
	public void shoesPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getShoesLink().click();
		String expectedPage = "Shoes";
		String actualPage = driver.findElement(By.xpath("//h1[@class='collection-hero__title']")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 19:Verify Look book link in the footer section
	@Test(priority = 19)
	public void lookBookLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getLookbookLink());
		boolean lookBookLink = h.getLookbookLink().isDisplayed();
		soft.assertTrue(lookBookLink);
	}

	// 20:Verify clicking on Look Book link is redirected to Shoes page
	@Test(priority = 20, dependsOnMethods = "lookBookLinkFooter")
	public void lookBookLinkPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getLookbookLink().click();
		String expectedPage = "Summer inspiration";
		String actualPage = driver
				.findElement(By.xpath(
						"//h2[@class='collage-wrapper-title inline-richtext h1 scroll-trigger animate--slide-in']"))
				.getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 21:Verify About link in the footer section
	@Test(priority = 21)
	public void aboutLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getAboutLink());
		boolean aboutLink = h.getAboutLink().isDisplayed();
		soft.assertTrue(aboutLink);
	}

	// 22:Verify clicking on About link is redirected to About page
	@Test(priority = 22, dependsOnMethods = "aboutLinkFooter")
	public void aboutPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getAboutLink().click();
		String expectedPage = "About";
		String actualPage = driver.findElement(By.xpath("//h1[contains(text(),'" + expectedPage + "')]")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 23:Verify Contact us link in the footer section
	@Test(priority = 23)
	public void contactUsLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getConatctUsLink());
		boolean contactUsLink = h.getConatctUsLink().isDisplayed();
		soft.assertTrue(contactUsLink);
	}

	// 24:Verify clicking on Contact link is redirected to Contact Us page
	@Test(priority = 24, dependsOnMethods = "contactUsLinkFooter")
	public void contactUsPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getConatctUsLink().click();
		String expectedPage = "Contact us";
		String actualPage = driver.findElement(By.xpath("//h1[contains(text(),'" + expectedPage + "')]")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 25:Verify shipping policy link in the footer section
	@Test(priority = 25)
	public void shippingPolicyLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getShippingPolicyLInk());
		boolean shippingPolicyLink = h.getShippingPolicyLInk().isDisplayed();
		soft.assertTrue(shippingPolicyLink);
	}

	// 26:Verify clicking on shipping policy link is redirected to Shipping page
	@Test(priority = 26, dependsOnMethods = "shippingPolicyLinkFooter")
	public void shippingPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getShippingPolicyLInk().click();
		String expectedPage = "Shipping";
		String actualPage = driver.findElement(By.xpath("//h1[contains(text(),'" + expectedPage + "')]")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 27:Verify blog link in the footer section
	@Test(priority = 27)
	public void blogLinkFooter() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getBlogLink());
		boolean blogLink = h.getBlogLink().isDisplayed();
		soft.assertTrue(blogLink);
	}

	// 28:Verify clicking on blog link is redirected to news page
	@Test(priority = 28, dependsOnMethods = "blogLinkFooter")
	public void newsPage() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getBlogLink().click();
		String expectedPage = "News";
		String actualPage = driver.findElement(By.xpath("//h1[contains(text(),'" + expectedPage + "')]")).getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 29: Verify that user is able to enter valid email id and subscribe
	@Test(priority = 29)
	public void newsletter() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		String email = "thomas0@gmail.com";
		h.getEmailTextField().sendKeys(email);
		Actions act = new Actions(driver);
		WebElement a = driver
				.findElement(By.xpath("//button[@type='submit']//*[name()='svg'  and @class='icon icon-arrow']"));
		act.moveToElement(a).click(a).build().perform();
		// Captcha is displayed so we cannot continue
		// String expectedMessage = "Thanks for subscribing";
		// String actualMessage =
		// driver.findElement(By.id("ContactFooter-success")).getText();
		// soft.assertEquals(expectedMessage, actualMessage, "Invalid data");
	}

	// 30: Verify the country dropdown in the footer
	@Test(priority = 30)
	public void country() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getCountryDropdown().click();
		String country = "Italy";
		driver.findElement(By.xpath(
				"//div[@class='footer__column footer__localization isolate']//input[@aria-controls='country-results']"))
				.sendKeys(country);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		;
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		String actualText = h.getCountryDropdown().getText();
		soft.assertEquals(country, actualText, "Country name not updated");
	}

	// 31: Verify the facebook Link in the homepage
	@Test(priority = 31)
	public void facebookLink() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getFacebookLink());
		boolean facebookLink = h.getFacebookLink().isDisplayed();
		soft.assertTrue(facebookLink);

	}

	// 32: Verify the Instagram Link in the homepage
	@Test(priority = 32)
	public void instagramLink() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getInstagramLink());
		boolean instagramLink = h.getInstagramLink().isDisplayed();
		soft.assertTrue(instagramLink);

	}

	// 33: Verify the Youtube Link in the homepage
	@Test(priority = 33)
	public void youtubeLink() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getYoutubeLink());
		boolean youtubeLink = h.getYoutubeLink().isDisplayed();
		soft.assertTrue(youtubeLink);

	}

	// 34: Verify the ticktok Link in the homepage
	@Test(priority = 34)
	public void ticktokLink() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getTiktokLink());
		boolean tictokLink = h.getTiktokLink().isDisplayed();
		soft.assertTrue(tictokLink);

	}

	// 35: Verify the twitter Link in the homepage
	@Test(priority = 35)
	public void twiterLink() throws Exception {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		wUtil.toScrollToParticluarWebelement(driver, h.getTwitterLink());
		boolean twitterLink = h.getTwitterLink().isDisplayed();
		soft.assertTrue(twitterLink);

	}
}
