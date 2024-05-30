package pom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import genericScripts.ScrollToElement;

//import genericScripts.ScrollToElement;

public class PDP {
	WebDriver driver;
	HashMap<String, String> productDetails;

	@FindBy(xpath = "//a[contains(@class,'cart')]")
	private WebElement cartIcon;

	@FindBy(xpath = "//div[contains(@class,'product-card')]")
	private List<WebElement> products;

	@FindBy(xpath = "//h2[contains(text(),'You may also like')]")
	private WebElement youMayAlsoLike;

	@FindBy(xpath = "//button[contains(@id,'ProductSubmitButton')]")
	private WebElement addToCart;

	@FindBy(xpath = "//button[contains(@id,'ProductSubmitButton')]/span")
	private WebElement addToCartText;

	@FindBy(xpath = "//button[contains(@class,'payment')]")
	private WebElement buyNow;

	@FindBy(xpath = "//div[@class='product__title']/h1")
	private WebElement productTitle;

	@FindBy(xpath = "//div[@class='price__regular']/span[2]")
	private WebElement productPrice;

	@FindBy(xpath = "//input[@class='quantity__input']")
	private WebElement productQuantity;

	@FindBy(xpath = "//button[@class='quantity__button'][@name='plus']")
	private WebElement productQuantityIncrease;

	@FindBy(xpath = "//div[@class='price__container']/div[2]/span[4]")
	private WebElement productSalePrice;

	@FindBy(xpath = "//span[contains(@class,'badge-sale')]")
	private List<WebElement> productSaleTag;

	@FindBy(xpath = "//legend[.='Color']")
	private List<WebElement> productColorLabel;

	@FindBy(xpath = "//input[@type='radio'][@name='Color'][@checked]")
	private WebElement productColor;

	@FindBy(xpath = "//input[@type='radio'][@name='Color']")
	private List<WebElement> productColorVariants;

	@FindBy(xpath = "//input[@type='radio'][@name='Color']/../label")
	private List<WebElement> productColorVariantsLabel;

	@FindBy(xpath = "//legend[.='Size']")
	private List<WebElement> productSizeLabel;

	@FindBy(xpath = "//input[@type='radio'][@name='Size']/../label")
	private List<WebElement> productSizeVariantsLabel;

	@FindBy(xpath = "//input[@type='radio'][@name='Size'][@checked]")
	private WebElement productSize;

	@FindBy(xpath = "//input[@type='radio'][@name='Size']")
	private List<WebElement> productSizeVariants;

	@FindBy(xpath = "//cart-notification//h2[contains(text(),'Item added to your cart')]")
	private WebElement cartNotification;

	@FindBy(id = "cart-notification-button")
	private WebElement viewCartButton;

	public PDP(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickCart() throws Exception {
		cartIcon.click();
		Thread.sleep(2000);
	}

	public boolean verifySoldOut() throws Exception {
		if (addToCartText.getText().contains("Sold out"))
			return true;
		else
			return false;
	}

	public void scrollToYouMayAlsoLikeSectionAndClickProduct() throws Exception {
		ScrollToElement.scrollToElement(driver, youMayAlsoLike);

		Faker faker = new Faker();
		int random = faker.number().numberBetween(0, products.size());

		products.get(random).click();

		products.get(0).click();
		Thread.sleep(2000);
	}

	public HashMap<String, String> changeColorSizeQuantityVariantAndCaptureDetails(int quantity) throws Exception {
		productDetails = new HashMap<String, String>();
		productDetails.put("title", productTitle.getText());

		if (productSaleTag.size() != 0) {
			String[] prices = productSalePrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		} else {
			String[] prices = productPrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		}

		String[] prices = productPrice.getText().split(" ");
		productDetails.put("price", prices[0]);

		for (int i = 1; i < productColorVariants.size(); i++) {
			WebElement productColorVariant = productColorVariants.get(i);
			if (!productColorVariant.getAttribute("class").equals("disabled")) {
				productColorVariantsLabel.get(i).click();
				productDetails.put("color", productColorVariant.getAttribute("value"));
				break;
			}
		}

		for (int i = 1; i < productSizeVariants.size(); i++) {
			WebElement productSizeVariant = productSizeVariants.get(i);
			if (!productSizeVariant.getAttribute("class").equals("disabled")) {
				productSizeVariantsLabel.get(i).click();
				productDetails.put("size", productSizeVariant.getAttribute("value"));
				break;
			}
		}

		for (int i = 0; i < quantity; i++) {
			productQuantityIncrease.click();
			Thread.sleep(1000);
		}

		/*
		 * Iterator<WebElement> iterator = productColorVariants.iterator();
		 * iterator.next();
		 * 
		 * while (iterator.hasNext()) { WebElement productColorVariant =
		 * iterator.next();
		 * if(!productColorVariant.getAttribute("class").equals("disabled")) {
		 * productColorVariant.click(); break; } }
		 */

		System.out.println();

		productDetails.put("quantity", Integer.toString(quantity));

		System.out.println(productQuantity.getAttribute("value"));

		return productDetails;
	}

	public void changeColorVariant() throws Exception {
		for (int i = 1; i < productColorVariants.size(); i++) {
			WebElement productColorVariant = productColorVariants.get(i);
			if (!productColorVariant.getAttribute("class").equals("disabled")) {
				productColorVariantsLabel.get(i).click();
				break;
			}
		}

		/*
		 * Iterator<WebElement> iterator = productColorVariants.iterator();
		 * iterator.next();
		 * 
		 * while (iterator.hasNext()) { WebElement productColorVariant =
		 * iterator.next();
		 * if(!productColorVariant.getAttribute("class").equals("disabled")) {
		 * productColorVariant.click(); break; } }
		 */
	}

	public void changeSizeVariant() throws Exception {
		for (int i = 1; i < productSizeVariants.size(); i++) {
			WebElement productColorVariant = productSizeVariants.get(i);
			if (!productColorVariant.getAttribute("class").equals("disabled")) {
				productSizeVariantsLabel.get(i).click();
				break;
			}
		}

		/*
		 * Iterator<WebElement> iterator = productSizeVariants.iterator();
		 * iterator.next();
		 * 
		 * while (iterator.hasNext()) { WebElement productSizeVariant = iterator.next();
		 * if(!productSizeVariant.getAttribute("class").equals("disabled")) {
		 * productSizeVariant.click(); break; } }
		 */
	}

	public void changeQuantity(int quantity) throws Exception {
		for (int i = 2; i <= quantity; i++) {
			productQuantityIncrease.click();
			Thread.sleep(1000);
		}
	}

	public String captureProductTitle() throws Exception {
		return productTitle.getText();
	}

	public HashMap<String, String> captureProductDetailsWithQuantity(int quantity) throws Exception {
		productDetails = new HashMap<String, String>();
		productDetails.put("title", productTitle.getText());

		if (productSaleTag.size() != 0) {
			String[] prices = productSalePrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		} else {
			String[] prices = productPrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		}

		String[] prices = productPrice.getText().split(" ");
		productDetails.put("price", prices[0]);

		if (productColorLabel.size() != 0)
			productDetails.put("color", productColor.getAttribute("value"));

		if (productSizeLabel.size() != 0)
			productDetails.put("size", productSize.getAttribute("value"));

		productDetails.put("quantity", Integer.toString(quantity));

		System.out.println(productDetails);

		return productDetails;
	}

	public HashMap<String, String> captureProductDetails() throws Exception {
		productDetails = new HashMap<String, String>();
		productDetails.put("title", productTitle.getText());

		if (productSaleTag.size() != 0) {
			String[] prices = productSalePrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		} else {
			String[] prices = productPrice.getText().split(" ");
			productDetails.put("price", prices[0]);
		}

		String[] prices = productPrice.getText().split(" ");
		productDetails.put("price", prices[0]);

		if (productColorLabel.size() != 0)
			productDetails.put("color", productColor.getAttribute("value"));

		if (productSizeLabel.size() != 0)
			productDetails.put("size", productSize.getAttribute("value"));

		System.out.println(productDetails);

		return productDetails;
	}

	public void captureProductDetailsFromAjaxCart() throws Exception {
		productDetails = new HashMap<String, String>();
		productDetails.put("title", productTitle.getText());
		String[] prices = productPrice.getText().split(" ");
		productDetails.put("price", prices[0]);

		if (productColorLabel.size() != 0)
			productDetails.put("color", productColor.getAttribute("value"));

		if (productSizeLabel.size() != 0)
			productDetails.put("size", productSize.getAttribute("value"));

		System.out.println(productDetails);
	}

	public void clickAddToCartButton() throws Exception {
		ScrollToElement.scrollToElement(driver, addToCart);
		addToCart.click();
		Thread.sleep(2000);
	}

	public void verifyCartNotification() throws Exception {
		Assert.assertTrue(cartNotification.isDisplayed());
		Thread.sleep(2000);
	}

	public void clickViewCartButton() throws Exception {
		viewCartButton.click();
		Thread.sleep(2000);
	}
}
