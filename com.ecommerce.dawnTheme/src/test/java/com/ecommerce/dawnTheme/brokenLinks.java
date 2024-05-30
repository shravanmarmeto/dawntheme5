package com.ecommerce.dawnTheme;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {
	public static void main(String[] args) {

		String homePage = "https://theme-dawn-demo.myshopify.com";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://themes.shopify.com/themes/dawn/styles/default/preview");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='PreviewFrame']"));
		driver.switchTo().frame(iframe);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either NOT CONFIGURED for anchor tag or it is EMPTY");
				continue;
			}
			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, SKIPPING IT.");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {
					System.out.println(url + " IS A BROKEN LINK");
				} else {
					System.out.println(url + " IS A VALID LINK");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
