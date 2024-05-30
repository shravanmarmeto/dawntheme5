package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pdpPage {
	public pdpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='product__title']")
	private WebElement productTitle;
	@FindBy(xpath = "//div[@class='product-form__buttons']//button[@class='product-form__submit button button--full-width button--secondary']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//span[@class='price-item price-item--regular']")
	private WebElement priceText;
	@FindBy(xpath = "//span[contains(text(),'Sold out')]")
	private WebElement soldoutText;
	@FindBy(xpath = "//button[@role='button']")
	private WebElement buyItNowButton;
	@FindBy(xpath = "//h2[contains(text(),'Materials')]")
	private WebElement materialsDropdown;
	@FindBy(xpath = "//h2[contains(text(),'Shipping & Returns')]")
	private WebElement shippingAndReturnsDropdown;
	@FindBy(xpath = "//h2[contains(text(),'Care Instructions')]")
	private WebElement careInstructionsDropdown;
	@FindBy(xpath = "//button[@class='share-button__button']")
	private WebElement shareButton;
	@FindBy(xpath = "//h2[contains(text(),'Dimensions')]")
	private WebElement dimensionsBagsDropdown;
	@FindBy(xpath = "//h2[contains(text(),'You may also like')]")
	private WebElement youMayAlsoLikeThisSection;
	@FindBy(xpath = "//legend[contains(text(),'Color')]")
	private WebElement colorOptions;
	@FindBy(xpath = "//legend[contains(text(),'Size')]")
	private WebElement sizeOptions;
	@FindBy(xpath = "//label[contains(text(),'Quantity')]")
	private WebElement quantityOptions;
	@FindBy(xpath = "//h3[@class='cart-notification-product__name h4']")
	private WebElement notificationProductTitle;
	@FindBy(xpath = "//div[@class='product-option']/child::dt[contains(text(),'Color')]/following-sibling::dd")
	private WebElement notificationProductColor;
	@FindBy(xpath = "//div[@class='product-option']/child::dt[contains(text(),'Size')]/following-sibling::dd")
	private WebElement notificationsProductSize;
	@FindBy(xpath = "//a[@id='cart-notification-button']")
	private WebElement viewCartButton;
	@FindBy(xpath = "//button[@class='button button--primary button--full-width']")
	private WebElement checkOutButton;
	@FindBy(xpath = "//button[@class='link button-label']")
	private WebElement continueShoppingButton;
	@FindBy(xpath = "//button[@class='cart-notification__close modal__close-button link link--text focus-inset']")
	private WebElement notificationCloseButton;
	@FindBy(xpath = "//button[@class='quantity__button']")
	private WebElement quantityButton;
	public WebElement getQuantityButton() {
		return quantityButton;
	}

	public WebElement getNotificationProductTitle() {
		return notificationProductTitle;
	}

	public WebElement getNotificationProductColor() {
		return notificationProductColor;
	}

	public WebElement getNotificationsProductSize() {
		return notificationsProductSize;
	}

	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getNotificationCloseButton() {
		return notificationCloseButton;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getPriceText() {
		return priceText;
	}

	public WebElement getSoldoutText() {
		return soldoutText;
	}

	public WebElement getBuyItNowButton() {
		return buyItNowButton;
	}

	public WebElement getMaterialsDropdown() {
		return materialsDropdown;
	}

	public WebElement getShippingAndReturnsDropdown() {
		return shippingAndReturnsDropdown;
	}

	public WebElement getCareInstructionsDropdown() {
		return careInstructionsDropdown;
	}

	public WebElement getShareButton() {
		return shareButton;
	}

	public WebElement getDimensionsBagsDropdown() {
		return dimensionsBagsDropdown;
	}

	public WebElement getYouMayAlsoLikeThisSection() {
		return youMayAlsoLikeThisSection;
	}

	public WebElement getColorOptions() {
		return colorOptions;
	}

	public WebElement getSizeOptions() {
		return sizeOptions;
	}

	public WebElement getQuantityOptions() {
		return quantityOptions;
	}

	public WebElement getAddToCart() {
		return addToCartButton;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}
}
