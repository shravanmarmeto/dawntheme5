package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//iframe[@id='PreviewFrame']")
	private WebElement iframe;
	
	@FindBy(xpath = "//div[@class='header__heading-logo-wrapper']/img")
	private WebElement companyLogo;
	
	@FindBy(xpath = "(//header-menu//*[@class='icon icon-caret'])[1]")
	private WebElement bagsOptionArrow;
	
	@FindBy(xpath = "//a[.='Shop now']")
	private WebElement shopNowButton;
	
	@FindBy(xpath = "//summary[@id='HeaderMenu-shoes']/span")
	private WebElement shoesOption;
	
	@FindBy(id = "HeaderMenu-shoes-shop-all")
	private WebElement shoesShopAll;
	
	@FindBy(xpath = "//div[@class='header__icons']//summary[contains(@class,'search')]")
	private WebElement searchIcon;
	
	@FindBy(id = "Search-In-Modal")
	private WebElement searchInput;
	
	@FindBy(xpath = "//a[contains(@class,'cart')]")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//h2[contains(text(),'Obsessive Attention. Intelligent Effort.')]")
	private WebElement obsessiveAttentionIntelligentEffortHeading;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void switchToIframe() throws Exception
	{
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
	}
	
	public void verifyLogo() throws Exception
	{
		Assert.assertTrue(companyLogo.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void clickBags() throws Exception
	{
		bagsOptionArrow.click();
		Thread.sleep(2000);
	}
	
	public void clickShoesOption() throws Exception
	{
		shoesOption.click();
		Thread.sleep(2000);
	}
	
	public void hoverAndClickShopAll() throws Exception
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(shoesShopAll).click().build().perform();
	}
	
	public void clickShopNowButton() throws Exception
	{
		shopNowButton.click();
		Thread.sleep(2000);
	}
	
	public void clickCart() throws Exception
	{
		cartIcon.click();
		Thread.sleep(2000);
	}
	
	public void clickSearchIcon() throws Exception
	{
		searchIcon.click();
		Thread.sleep(2000);
	}
	
	public void enterInputIntoSearchField(String keyword) throws Exception
	{
		searchInput.click();
		searchInput.sendKeys(keyword);
		Thread.sleep(2000);
	}
}
