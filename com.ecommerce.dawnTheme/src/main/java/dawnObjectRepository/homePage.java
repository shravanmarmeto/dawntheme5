package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@id='PreviewFrame']")
	private WebElement iframe;
	@FindBy(xpath = "//img[@loading='eager']")
	private WebElement dawnLogo;
	@FindBy(id = "HeaderMenu-bags")
	private WebElement bagsDropdown;
	@FindBy(id = "HeaderMenu-shoes")
	private WebElement shoesDropdown;
	@FindBy(id = "HeaderMenu-lookbook")
	private WebElement lookBookLink;
	@FindBy(xpath = "//details-modal[@class='header__search']")
	private WebElement searchIcon;
	@FindBy(xpath = "//div[@class='header__icons']//a[@href='/account/login']")
	private WebElement profileIcon;
	@FindBy(id = "cart-icon-bubble")
	private WebElement cartIcon;
	@FindBy(xpath = "//p[@class='announcement-bar__message h5']")
	private WebElement announcementBar;
	@FindBy(xpath = "//a[@href='/collections/all']")
	private WebElement shopnowButton;
	@FindBy(xpath = "//h2[contains(text(),'Back in stock!')]")
	private WebElement backInStockSection;
	@FindBy(xpath = "//a[contains(text(),' Bags')]")
	private WebElement bagsLink;
	@FindBy(xpath = "//a[contains(text(),' Shoes')]")
	private WebElement shoesLink;
	@FindBy(xpath = "//ul[@class='footer-block__details-content list-unstyled']//a[contains(text(),'Lookbook')]")
	private WebElement lookbookLink;
	@FindBy(xpath = "//a[contains(text(),'About')]")
	private WebElement aboutLink;
	@FindBy(xpath = "//a[contains(text(),'Contact us')]")
	private WebElement conatctUsLink;
	@FindBy(xpath = "//a[contains(text(),'Shipping policy')]")
	private WebElement shippingPolicyLInk;
	@FindBy(xpath = "//a[contains(text(),'Blog')]")
	private WebElement blogLink;
	@FindBy(name = "contact[email]")
	private WebElement emailTextField;
	@FindBy(id = "Subscribe")
	private WebElement emailArrowButton;
	@FindBy(xpath = "//div[@class='footer__content-top page-width']//*[name()='svg' and @class='icon icon-facebook']")
	private WebElement facebookLink;
	@FindBy(xpath = "//div[@class='footer__content-top page-width']//*[name()='svg' and @class='icon icon-instagram']")
	private WebElement instagramLink;
	@FindBy(xpath = "//div[@class='footer__content-top page-width']//*[name()='svg' and @class='icon icon-youtube']")
	private WebElement youtubeLink;
	@FindBy(xpath = "//div[@class='footer__content-top page-width']//*[name()='svg' and @class='icon icon-tiktok']")
	private WebElement tiktokLink;
	@FindBy(xpath = "//div[@class='footer__content-top page-width']//*[name()='svg' and @class='icon icon-twitter']")
	private WebElement twitterLink;
	@FindBy(xpath = "//button[@aria-describedby='FooterCountryLabel']")
	private WebElement countryDropdown;
	@FindBy(xpath = "//input[@class='search__input field__input']")
	private WebElement searchTextfield;
	

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getIframe() {
		return iframe;
	}

	public WebElement getDawnLogo() {
		return dawnLogo;
	}

	public WebElement getBagsDropdown() {
		return bagsDropdown;
	}

	public WebElement getShoesDropdown() {
		return shoesDropdown;
	}

	public WebElement getLookBookLink() {
		return lookBookLink;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getAnnouncementBar() {
		return announcementBar;
	}

	public WebElement getShopnowButton() {
		return shopnowButton;
	}

	public WebElement getBackInStockSection() {
		return backInStockSection;
	}

	public WebElement getBagsLink() {
		return bagsLink;
	}

	public WebElement getShoesLink() {
		return shoesLink;
	}

	public WebElement getLookbookLink() {
		return lookbookLink;
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement getConatctUsLink() {
		return conatctUsLink;
	}

	public WebElement getShippingPolicyLInk() {
		return shippingPolicyLInk;
	}

	public WebElement getBlogLink() {
		return blogLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getEmailArrowButton() {
		return emailArrowButton;
	}

	public WebElement getFacebookLink() {
		return facebookLink;
	}

	public WebElement getInstagramLink() {
		return instagramLink;
	}

	public WebElement getYoutubeLink() {
		return youtubeLink;
	}

	public WebElement getTiktokLink() {
		return tiktokLink;
	}

	public WebElement getTwitterLink() {
		return twitterLink;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

}
