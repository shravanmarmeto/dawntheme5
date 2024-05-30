package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	public cartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='title-wrapper-with-link']//h1[contains(text(),'Your cart')]")
	private WebElement cartTitle;
	@FindBy(xpath = "//a[@class='cart-item__name h4 break']")
	private WebElement productTitle;
	@FindBy(xpath = "(//div[@class='product-option'])[1]")
	private WebElement price;
	@FindBy(xpath = "//td[@class='cart-item__totals right small-hide']//span[@class='price price--end']")
	private WebElement totalPriceOfOneProduct;
	@FindBy(xpath = "//div[@class='product-option']/child::dt[contains(text(),'Color')]/following-sibling::dd")
	private WebElement color;
	@FindBy(xpath = "//div[@class='product-option']/child::dt[contains(text(),'Size')]/following-sibling::dd")
	private WebElement size;
	@FindBy(xpath = "//button[@name='minus']")
	private WebElement quantityDecreaseButton;
	@FindBy(xpath = "//button[@name='plus']")
	private WebElement quantityIncreaseButton;
	@FindBy(xpath = "//input[@class='quantity__input']")
	private WebElement totalQuantity;
	@FindBy(xpath = "class=\"totals__total-value\"")
	private WebElement totalPrice;
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkoutButton;
	@FindBy(xpath = "//h2[@class='title inline-richtext h2 scroll-trigger animate--slide-in']")
	private WebElement youMayAlsoLikeThisSection;
	@FindBy(xpath = "//div[@class='center collection__view-all scroll-trigger animate--slide-in']//a[@class='button']")
	private WebElement viewAllButton;
	
	

	public WebElement getProductTitle() {
		return productTitle;
	}



	public WebElement getPrice() {
		return price;
	}



	public WebElement getTotalPriceOfOneProduct() {
		return totalPriceOfOneProduct;
	}



	public WebElement getColor() {
		return color;
	}



	public WebElement getSize() {
		return size;
	}



	public WebElement getQuantityDecreaseButton() {
		return quantityDecreaseButton;
	}



	public WebElement getQuantityIncreaseButton() {
		return quantityIncreaseButton;
	}



	public WebElement getTotalQuantity() {
		return totalQuantity;
	}



	public WebElement getTotalPrice() {
		return totalPrice;
	}



	public WebElement getCheckoutButton() {
		return checkoutButton;
	}



	public WebElement getYouMayAlsoLikeThisSection() {
		return youMayAlsoLikeThisSection;
	}



	public WebElement getViewAllButton() {
		return viewAllButton;
	}



	public WebElement getCartTitle() {
		return cartTitle;
	}

}
