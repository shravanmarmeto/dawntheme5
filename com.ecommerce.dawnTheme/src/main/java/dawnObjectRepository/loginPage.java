package dawnObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")
	private WebElement loginTitle;
	@FindBy(id = "CustomerEmail")
	private WebElement emailTextField;
	@FindBy(id = "CustomerPassword")
	private WebElement passwordTextField;
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	private WebElement forgotPasswordLink;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	private WebElement signInButton;
	@FindBy(xpath = "//a[contains(text(),'Create account')]")
	private WebElement createAccountLink;

	public WebElement getLoginTitle() {
		return loginTitle;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

}
