package pdp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Main1 {

	@Test
	public void pdp() {
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://themes.shopify.com/themes/dawn/styles/default/preview");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='PreviewFrame']"));
		driver.switchTo().frame(iframeElement);

		WebElement clkBtn = driver.findElement(By.xpath("//a[text()='Shop now']"));
		clkBtn.click();

		driver.findElement(By.xpath("//a[@id='CardLink-template--15729329504345__product-grid-6920725692505']"))
				.click();
		List<WebElement> brandVariants = driver
				.findElements(By.xpath("//fieldset[@class='js product-form__input product-form__input--pill']//label"));
		for (WebElement variant : brandVariants) {
			variant.click();
			System.out.println(variant.getText());
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2000)");

		// Click on more options
		List<WebElement> moreOptions = driver
				.findElements(By.xpath("//div[@class='product__accordion accordion quick-add-hidden']"));
		for (WebElement option : moreOptions) {
			option.click();
		}
		js.executeScript("window.scrollTo(0, 3000)");

		// Verify "You may also like" section
		System.out.println(
				driver.findElement(By.xpath("//h2[@class='related-products__heading inline-richtext h2']")).getText());
		if (true) {
			boolean isEnabled = driver
					.findElement(By.xpath("//div[@class='wallet-button-fade-in']//button[text()='Buy it now']"))
					.isEnabled();
			System.out.println(isEnabled);
			driver.findElement(By.xpath("//input[@class='quantity__input']")).clear();
			driver.findElement(By.xpath("//button[text()='+']")).click();
			driver.findElement(By.xpath("//button[@id='ProductSubmitButton-template--15729330126937__main']")).click();
			driver.findElement(By.xpath("//a[@id='cart-notification-button']")).click();
			driver.findElement(By.xpath("//button[@id='checkout']")).click();
		} else {
			driver.findElement(By.xpath("//input[@class='quantity__input']")).clear();
			driver.findElement(By.xpath("//input[@class='quantity__input']")).sendKeys("15");
			driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			// Handle error message
			WebElement errorMessage = driver.findElement(By.xpath(
					"//div[@class='product-form__error-message-wrapper']//span[@class='product-form__error-message']"));
			System.out.println(errorMessage.getText());
			WebElement buyBtn = driver
					.findElement(By.xpath("//div[@class='wallet-button-fade-in']//button[text()='Buy it now']"));
			boolean isDisabled = buyBtn.getAttribute("disabled") != null;
			if (isDisabled) {
				System.out.println("The products are out of stock");
			}
		}

		driver.quit();
	}
}