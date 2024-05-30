package genericScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	public static void scrollToElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point point = ele.getLocation();
//		int x = point.getX();
//		int y = point.getY();
		int x = point.getX() - 100;   
		int y = point.getY() - 100;
		js.executeScript("window.scrollBy("+x+", "+y+")");
	}
}











