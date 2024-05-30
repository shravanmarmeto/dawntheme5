package pom;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AjaxCart {
	WebDriver driver;
	HashMap<String, String> productDetails;
	
	@FindBy(xpath="//cart-notification//h2[contains(text(),'Item added to your cart')]")
	private WebElement cartNotification;
	
	@FindBy(css = "div[id='cart-notification-product'] div img")
	private WebElement productImage;
	
	@FindBy(css ="div[id='cart-notification-product'] div h3")
	private WebElement productTitle;
	
	@FindBy(xpath="//div[@class='product-option']/dt[contains(text(), 'Color')]")
	private List<WebElement> productColorLabel;
	
	@FindBy(xpath="//div[@class='product-option']/dt[contains(text(), 'Color')]/following-sibling::dd")
	private WebElement productColor;
	
	@FindBy(xpath="//div[@class='product-option']/dt[contains(text(), 'Size')]")
	private List<WebElement> productSizeLabel;
	
	@FindBy(xpath="//div[@class='product-option']/dt[contains(text(), 'Size')]/following-sibling::dd")
	private WebElement productSize;     
	
	@FindBy(id="cart-notification-button")
	private WebElement viewCartButton;

	public AjaxCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public HashMap<String, String> captureProductDetailsFromAjaxCart() throws Exception
	{
		productDetails = new HashMap<String, String>();
		
		Assert.assertTrue(productImage.isDisplayed());
		
		productDetails.put("title", productTitle.getText());
		
		if(productColorLabel.size()!=0)
			productDetails.put("color", productColor.getText());
		
		if(productSizeLabel.size()!=0)
			productDetails.put("size", productSize.getText());     
		
		System.out.println(productDetails);
		
		return productDetails;
	}
	
	public void verifyCartNotification() throws Exception
	{
		Assert.assertTrue(cartNotification.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void clickViewCartButton() throws Exception
	{
		viewCartButton.click();
		Thread.sleep(2000);
	}
}
