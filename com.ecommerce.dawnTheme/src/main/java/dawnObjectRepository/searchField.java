package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchField {

	public searchField(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "search__input field__input")
	private WebElement searchFiled;
	@FindBy(className = "search__button field__button")
	private WebElement searchButton;
	@FindBy(className = "search-modal__close-button modal__close-button link link--text focus-inset")
	private WebElement closeSearchFiled;
	@FindBy(xpath = "//h2[text()='Suggestions']")
	private WebElement suggestionList;
	@FindBy(xpath = "Products")
	private WebElement productsList;

	public WebElement getSearchFiled() {
		return searchFiled;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCloseSearchFiled() {
		return closeSearchFiled;
	}

	public WebElement getSuggestionList() {
		return suggestionList;
	}

	public WebElement getProductsList() {
		return productsList;
	}

}
