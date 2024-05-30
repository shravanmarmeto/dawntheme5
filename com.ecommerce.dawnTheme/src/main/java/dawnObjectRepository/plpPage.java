package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class plpPage {

	public plpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='collection-hero__title']")
	private WebElement collectionTitle;
	@FindBy(xpath = "//form[@id='FacetFiltersForm']//span[contains(text(),'Availability')]")
	private WebElement availabilityDropdown;
	@FindBy(xpath = "//span[@class='facet-checkbox__text']/ancestor::li[@class='list-menu__item facets__item']//input[@id='Filter-filter.v.availability-1']")
	private WebElement inStockCheckbox;
	@FindBy(xpath = "//span[@class='facet-checkbox__text']/ancestor::li[@class='list-menu__item facets__item']//input[@id='Filter-filter.v.availability-2']")
	private WebElement outOfStockCheckbox;
	@FindBy(xpath = "//div[@id='Facet-1-template--15729329504345__product-grid']//a[@class='facets__reset link underlined-link']")
	private WebElement resetAvailablityCheckbox;
	@FindBy(xpath = "//div[@id='Facet-1-template--15729329504345__product-grid']//span[@class='facets__selected']")
	private WebElement availabilitySelectCount;
	@FindBy(xpath = "//form[@id='FacetFiltersForm']//span[contains(text(),'Color')]")
	private WebElement colorDropdown;
	@FindBy(xpath = "//div[@id='Facet-2-template--15729329504345__product-grid']//span[@class='facets__selected']")
	private WebElement colorSelectCount;
	@FindBy(xpath = "//div[@id='Facet-2-template--15729329504345__product-grid']//a[@class='facets__reset link underlined-link']")
	private WebElement resetColorCheckbox;
	@FindBy(xpath = "//select[@id='SortBy']")
	private WebElement sortbyBdropdown;
	@FindBy(xpath = "//span[@id='ProductCountDesktop']")
	private WebElement productCount;
	@FindBy(xpath = "//a[@class='full-unstyled-link']")
	private WebElement productName;
	@FindBy(xpath = "//a[@class='pagination__item pagination__item--prev pagination__item-arrow link motion-reduce']")
	private WebElement paginationIcon;
	@FindBy(xpath = "//div[@class='card-wrapper product-card-wrapper underline-links-hover']")
	private WebElement productCard;
	@FindBy(xpath = "//span[contains(text(),'Price')]")
	private WebElement priceDropdown;
	@FindBy(xpath = "//label[contains(text(),'From')]")
	private WebElement priceFromValue;
	@FindBy(xpath = "//label[contains(text(),'To')]")
	private WebElement priceToValue;
	@FindBy(xpath = "(//input[@name='filter.v.price.gte'])[1]")
	private WebElement priceFromEnterValue;
	@FindBy(xpath = "(//input[@name='filter.v.price.lte'])[1]")
	private WebElement priceToEnterValue;

	public WebElement getPriceFromEnterValue() {
		return priceFromEnterValue;
	}

	public WebElement getPriceToEnterValue() {
		return priceToEnterValue;
	}

	public WebElement getPriceDropdown() {
		return priceDropdown;
	}

	public WebElement getPriceFromValue() {
		return priceFromValue;
	}

	public WebElement getPriceToValue() {
		return priceToValue;
	}

	public WebElement getProductCard() {
		return productCard;
	}

	public WebElement getSortbyBdropdown() {
		return sortbyBdropdown;
	}

	public WebElement getProductCount() {
		return productCount;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getPaginationIcon() {
		return paginationIcon;
	}

	public WebElement getCollectionTitle() {
		return collectionTitle;
	}

	public WebElement getAvailabilityDropdown() {
		return availabilityDropdown;
	}

	public WebElement getInStockCheckbox() {
		return inStockCheckbox;
	}

	public WebElement getOutOfStockCheckbox() {
		return outOfStockCheckbox;
	}

	public WebElement getResetAvailablityCheckbox() {
		return resetAvailablityCheckbox;
	}

	public WebElement getAvailabilitySelectCount() {
		return availabilitySelectCount;
	}

	public WebElement getColorDropdown() {
		return colorDropdown;
	}

	public WebElement getColorSelectCount() {
		return colorSelectCount;
	}

	public WebElement getResetColorCheckbox() {
		return resetColorCheckbox;
	}

}
