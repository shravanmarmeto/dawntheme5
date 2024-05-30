package com.ecommerce.dawnTheme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dawnObjectRepository.createAccountPage;
import dawnObjectRepository.homePage;
import dawnObjectRepository.loginPage;
import genericUtility.BaseClass;
import genericUtility.iConstantUtility;
import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class createaccountTest extends BaseClass {

	webdriverUtility wUtil = new webdriverUtility();
	SoftAssert soft = new SoftAssert();
	javaUtility jUtil=new javaUtility();
	int num=jUtil.toGetRandomNumber();
	String email="Joelpinto1"+num+"@gmail.com";

	// 1: Verify if user navaigates to create account page on clicking create
	// account link
	@Test(priority = 1)
	public void createAccount() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		loginPage l = new loginPage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getProfileIcon().click();
		l.getCreateAccountLink().click();
		createAccountPage c = new createAccountPage(driver);
		String expectedPage = "Create account";
		String actualPage = c.getCreateAccountTitle().getText();
		soft.assertEquals(expectedPage, actualPage);

	}

	// 2: Verify that user is able register with valid credentials
	@Test(priority = 2, dependsOnMethods = "createAccount")
	public void validData() {
		createAccountPage c = new createAccountPage(driver);
		c.getFirstnameTextFiled().sendKeys("Joel");
		c.getLastnameTextField().sendKeys("Pinto");
		c.getEmailTextFIield().sendKeys("joelpinto@gmail.com");
		c.getPasswordTextField().sendKeys("joelpinto@1");
		c.getCreateButton().click();
		String expectedPage = "https://themes.shopify.com/themes/dawn/styles/default/preview";
		String actualPage = driver.getCurrentUrl();
		soft.assertEquals(expectedPage, actualPage);
	}

	// 3: Verify that error message is displayed without enetring any data and
	// clicking on create button
	@Test(priority = 3)
	public void blankField() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		loginPage l = new loginPage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getProfileIcon().click();
		l.getCreateAccountLink().click();
		createAccountPage c = new createAccountPage(driver);
		c.getFirstnameTextFiled().sendKeys("");
		c.getLastnameTextField().sendKeys("");
		c.getEmailTextFIield().sendKeys("");
		c.getPasswordTextField().sendKeys("");
		//c.getCreateButton().click();
		WebElement a= driver.findElement(By.xpath("//form[@action='/account']//button[contains(text(),'Create')]"));
		a.click();
		String expectedEmailError = "Email can't be blank.";
		String expectedPasswordError = "Password can't be blank.";
		String actualEmailError = c.getEmailError().getText();
		String actaulPasswordError = c.getPasswordError().getText();
		soft.assertEquals(expectedEmailError, actualEmailError);
		soft.assertEquals(expectedPasswordError, actaulPasswordError);
	}

	// 4: Verify that error message is displayed when entered invalid email
	@Test(priority = 4, dependsOnMethods = "blankField")
	public void invalidEmail() {
		driver.get(iConstantUtility.dawn);
		homePage h = new homePage(driver);
		loginPage l = new loginPage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getProfileIcon().click();
		l.getCreateAccountLink().click();
		createAccountPage c = new createAccountPage(driver);
		c.getFirstnameTextFiled().sendKeys("ravi");
		c.getLastnameTextField().sendKeys("roy");
		c.getEmailTextFIield().sendKeys("ravi@");
		c.getPasswordTextField().sendKeys("ravii@1");
		c.getCreateButton().click();
		String expectedEmailError = "Email is invalid.";
		String actualEmailError = c.getEmailError().getText();
		soft.assertEquals(expectedEmailError, actualEmailError);
	}

	// 5: Verify that error message is displayed when entered invalid email
	@Test(priority = 5, dependsOnMethods = "invalidEmail")
	public void invalidPassword() {
		createAccountPage c = new createAccountPage(driver);
		c.getFirstnameTextFiled().sendKeys("ravi");
		c.getLastnameTextField().sendKeys("roy");
		c.getEmailTextFIield().sendKeys("ravi1@gmail.com");
		c.getPasswordTextField().sendKeys("ravi");
		c.getCreateButton().click();
		String expectedPasswordError = "Password is too short (minimum is 5 characters).";
		if(c.getPasswordError().isDisplayed()) {
		String actualPasswordError = c.getPasswordError().getText();
		soft.assertEquals(expectedPasswordError, actualPasswordError);
		}
		else {
			boolean mainError=c.getErrorMain().isDisplayed();
			soft.assertTrue(mainError);
			soft.assertAll();
		}
	}

}
