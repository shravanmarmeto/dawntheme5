package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createAccountPage {

	public createAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Create account')]")
	private WebElement createAccountTitle;
	@FindBy(id = "RegisterForm-FirstName")
	private WebElement firstnameTextFiled;
	@FindBy(id = "RegisterForm-LastName")
	private WebElement lastnameTextField;
	@FindBy(id = "RegisterForm-email")
	private WebElement emailTextFIield;
	@FindBy(id = "RegisterForm-password")
	private WebElement passwordTextField;
	@FindBy(xpath = "//form[@id='create_customer']//button[contains(text(),'Create')]")
	private WebElement createButton;
	@FindBy(id = "RegisterForm-email-error")
	private WebElement emailError;
	@FindBy(id = "RegisterForm-password-error")
	private WebElement passwordError;
	@FindBy(xpath = "//h2[@class='form__message']")
	private WebElement errorMain;

	public WebElement getErrorMain() {
		return errorMain;
	}

	public WebElement getEmailError() {
		return emailError;
	}

	public WebElement getPasswordError() {
		return passwordError;
	}

	public WebElement getCreateAccountTitle() {
		return createAccountTitle;
	}

	public WebElement getFirstnameTextFiled() {
		return firstnameTextFiled;
	}

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getEmailTextFIield() {
		return emailTextFIield;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

}
