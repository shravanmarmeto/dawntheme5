package pom;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	WebDriver driver;
	HashMap<String, String> productDetails;
	
	@FindBy(xpath="//*[.='Cart']")
	private WebElement cartDrawerText;
	
	@FindBy(xpath="//*[.='Your cart is empty']")
	private WebElement emptyCartText;
	
	@FindBy(xpath="(//button[@class='Drawer__Close Icon-Wrapper--clickable'])[2]")
	private WebElement cartDrawerCloseIcon;

	@FindBy(xpath = "(//a[contains(text(),'Continue shopping')])[2]")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath = "//div[contains(@class,'cart-item__image')]")
	private WebElement productImage;
	
	@FindBy(xpath = "//td[@class='cart-item__details']/a")
	private WebElement productTitle; 
	
	@FindBy(xpath = "//td[@class='cart-item__details']/div")
	private WebElement productPrice; 
	
	@FindBy(xpath = "//td[@class='cart-item__details']/dl/div/dd")
	private List<WebElement> productColorSize;  
	
	@FindBy(xpath="//input[@class='quantity__input']")
	private WebElement productQuantity;
	
	@FindBy(xpath="//button[@class='quantity__button'][@name='plus']")
	private WebElement productQuantityIncrease;
	
	@FindBy(xpath="//button[@class='quantity__button'][@name='minus']")
	private WebElement productQuantityDecrease;
	
	@FindBy(xpath="//cart-remove-button")
	private WebElement cartRemoveButton;
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton; 

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickCheckoutButton() throws Exception
	{
		checkoutButton.click();
		Thread.sleep(2000);
	}
	
	public void clickProductTitleAndVerify() throws Exception
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(productTitle).click().build().perform();
		System.out.println("Product title is clicked");
		Thread.sleep(2000);
	}
	
	public String captureAndClickProductTitle() throws Exception
	{
		String productTitleText = productTitle.getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(productTitle).click().build().perform();
		System.out.println("Product title is clicked");
		Thread.sleep(2000);
		return productTitleText;
	}
	
	public void clickContinueShoppingButton() throws Exception
	{
		continueShoppingButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyProductImage() throws Exception
	{
		Assert.assertTrue(productImage.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void verifyProductDetails() throws Exception
	{
		Assert.assertTrue(productTitle.isDisplayed());
		Assert.assertTrue(productPrice.isDisplayed());
		for(WebElement ele:productColorSize)
			Assert.assertTrue(ele.isDisplayed());
	}
	
	public void increaseAndDecreaseQuantity(int count) throws Exception
	{
		productQuantityIncrease.click();
		Thread.sleep(2000);
		
		productQuantityDecrease.click();
		Thread.sleep(2000);
		
		/*
		for(int i=1;i<=count;i++)
		{
			productQuantityIncrease.click();
			Thread.sleep(1000);
		}
		
		for(int i=1;i<=count;i++)
		{
			productQuantityDecrease.click();
			Thread.sleep(1000);
		}
		*/
	}
	
	public void clickRemoveButton() throws Exception
	{
		cartRemoveButton.click();
		Thread.sleep(2000);
	}
	
	public HashMap<String, String> captureProductDetails() throws Exception
	{
		productDetails = new HashMap<String, String>();
		Assert.assertTrue(productImage.isDisplayed());
		productDetails.put("title", productTitle.getText());
		productDetails.put("price", productPrice.getText());
		if(productColorSize.size()==1)
			productDetails.put("color", productColorSize.get(0).getText());
		else
		{
			productDetails.put("color", productColorSize.get(0).getText());
			productDetails.put("size", productColorSize.get(1).getText());
		}
		System.out.println(productDetails);
		
		return productDetails;
	} 
	
	public HashMap<String, String> captureProductDetailsWithQuantity() throws Exception
	{
		productDetails = new HashMap<String, String>();
		Assert.assertTrue(productImage.isDisplayed());
		productDetails.put("title", productTitle.getText());
		productDetails.put("price", productPrice.getText());
		if(productColorSize.size()==1)
			productDetails.put("color", productColorSize.get(0).getText());
		else
		{
			productDetails.put("color", productColorSize.get(0).getText());
			productDetails.put("size", productColorSize.get(1).getText());
		}
		
		productDetails.put("quantity", productQuantity.getAttribute("value"));
		System.out.println(productDetails);
		
		return productDetails;
	} 
	
	public void verifyEmptyCart() throws Exception
	{
		Assert.assertTrue(emptyCartText.isDisplayed());
		Thread.sleep(2000);
	}
}