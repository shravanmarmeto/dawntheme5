package pdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main2 {
	@Test
	public void pdp2() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://themes.shopify.com/themes/dawn/styles/default/preview");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(5000); // Using Thread.sleep for demonstration purposes, consider using WebDriverWait
							// instead

		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='PreviewFrame']"));
		driver.switchTo().frame(iframeElement);

		driver.findElement(By.xpath("//summary[@id='HeaderMenu-shoes']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@id='HeaderMenu-shoes-sandals']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"(//summary[@class='facets__summary caption-large focus-offset']//div//span[@class='facets__summary-label'])[1]"))
				.click();
		Thread.sleep(3000);

		List<WebElement> availabilityOptions = driver.findElements(By.xpath(
				"//ul[@class='facets-layout facets-layout-list facets-layout-list--text facets__list list-unstyled']//li"));
		if (!availabilityOptions.isEmpty()) {
			availabilityOptions.get(0).click();
			Thread.sleep(5000);
		}

		driver.findElement(By.xpath("//summary[text()='Price']")).click();
		driver.findElement(By.id("Filter-Price-GTE")).sendKeys("10");
		driver.findElement(By.id("Filter-Price-LTE")).sendKeys("1000");
		driver.findElement(By.xpath("(//summary[@class='facets__summary caption-large focus-offset'])[2]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"(//summary[@class='facets__summary caption-large focus-offset']//div//span[@class='facets__summary-label'])[2]"))
				.click();
		driver.findElement(By.id("Filter-filter.v.m.custom.color_swatch-1")).click();
		Thread.sleep(3000);

		List<WebElement> sortBy = driver.findElements(By.xpath("//div[@class='select']//select[@id='SortBy']//option"));
		for (WebElement option : sortBy) {
			option.click();
			Thread.sleep(2000);
			System.out.println(option.getText());
		}

		driver.findElement(By.id("CardLink-template--15729329504345__product-grid-6920722055257")).click();
		Thread.sleep(5000);

		List<WebElement> colorVariants = driver.findElements(
				By.xpath("(//fieldset[@class='js product-form__input product-form__input--pill'])[1]//label"));
		for (WebElement variant : colorVariants) {
			variant.click();
			Thread.sleep(2000);
		}

		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//button[@class='cart-notification__close modal__close-button link link--text focus-inset']"))
				.click();
		Thread.sleep(2000);

		WebElement soldOutProduct = driver
				.findElement(By.xpath("//input[@id='template--15729330159705__main-2-0' and @class='disabled']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@id='template--15729330159705__main-2-0' and @class='disabled']")));
		soldOutProduct.click();
		Thread.sleep(2000);

		WebElement soldOutButton = driver
				.findElement(By.xpath("//button[@id='ProductSubmitButton-template--15729330159705__main']"));
		System.out.println(soldOutButton.getText());

		Thread.sleep(4000);
		driver.quit();
	}
}