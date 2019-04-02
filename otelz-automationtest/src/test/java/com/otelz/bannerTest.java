package com.otelz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class bannerTest {

	@Test(priority = 1)
	public void banner1Test() {
		System.out.println("Starting banner1 test");

		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		sleep(3000);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// open the page
		String url = "https://www.otelz.com/";
		driver.get(url);
		System.out.println("Page is opened.");

		sleep(2000);

		// click istanbul banner
		WebElement banner = driver.findElement(By.cssSelector(
				"#vueApp > div:nth-child(2) > div:nth-child(3) > div.col-sm-8 > a:nth-child(1) > div > h3"));
		banner.click();

		// new url
		String expectedUrl = "https://www.otelz.com/istanbul-otelleri";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		// otel ara button is visible

		WebElement araButton = driver
				.findElement(By.cssSelector("#searchBoxForm > div > div:nth-child(4) > div:nth-child(2) > button"));
		Assert.assertTrue(araButton.isDisplayed(), "Button is not visible.");

		// correct message
		WebElement successMessage = driver.findElement(By.className("phero-title"));
		String expectedSuccessMessage = "İstanbul'da otel mi arıyorsun?";
		String actualSuccessMessage = successMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		sleep(3000);

		// Close browser
		driver.quit();
	}

	@Test(priority = 2)
	public void banner2Test() {
		System.out.println("Starting banner2 test");

		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		sleep(3000);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// open the page
		String url = "https://www.otelz.com/";
		driver.get(url);
		System.out.println("Page is opened.");

		sleep(2000);

		// click antalya banner
		WebElement banner = driver.findElement(
				By.cssSelector("#vueApp > div:nth-child(2) > div:nth-child(3) > div.col-sm-8 > a:nth-child(2) > div"));
		banner.click();

		// new url
		String expectedUrl = "https://www.otelz.com/antalya-otelleri";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		// otel ara button is visible

		WebElement araButton = driver
				.findElement(By.cssSelector("#searchBoxForm > div > div:nth-child(4) > div:nth-child(2) > button"));
		Assert.assertTrue(araButton.isDisplayed(), "Button is not visible.");

		// correct message
		WebElement successMessage = driver.findElement(By.className("phero-title"));
		String expectedSuccessMessage = "Antalya'da otel mi arıyorsun?";
		String actualSuccessMessage = successMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		sleep(3000);

		// Close browser
		driver.quit();
	}

	/** Static sleep */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
