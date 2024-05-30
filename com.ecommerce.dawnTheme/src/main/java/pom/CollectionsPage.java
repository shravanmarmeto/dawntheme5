package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class CollectionsPage {
	WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'product-card')]")
	private List<WebElement> products;
	
	@FindBy(xpath = "//h1[@class='collection-hero__title']")
	private WebElement collectionPageHeading;
	
	public CollectionsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void verifyCollectionsPage() throws Exception
	{
		Assert.assertTrue(collectionPageHeading.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void clickOnAnyProduct() throws Exception
	{
		Faker faker = new Faker();
		int random = faker.number().numberBetween(0, products.size());
		
		products.get(random).click();
		Thread.sleep(2000);
	}
}