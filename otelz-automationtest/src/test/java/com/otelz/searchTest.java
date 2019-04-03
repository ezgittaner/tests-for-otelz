package com.otelz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class searchTest {

	@Test
	public void Test() {
		System.out.println("Starting search test");

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

		// enter placeName
		WebElement placeName = driver
				.findElement(By.cssSelector("#searchBoxForm > div.sbc-body > div.form-group > input"));
		placeName.sendKeys("İzmir");
		sleep(1000);
		WebElement select = driver.findElement(
				By.cssSelector("#searchBoxForm > div.sbc-body > div.form-group > div > div > ul > li:nth-child(1)"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(select));

		select.click();

		// select date
		WebElement entry1Date = driver.findElement(By.cssSelector(
				"#searchBoxForm > div.sbc-body > div:nth-child(2) > div:nth-child(1) > div > span.date-input-cont"));
		entry1Date.click();
		WebElement entry2Date = driver.findElement(By.cssSelector(
				"#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(1) > td:nth-child(4) > a"));
		entry2Date.click();

		WebElement exit1Date = driver.findElement(By.cssSelector(
				"#searchBoxForm > div.sbc-body > div:nth-child(2) > div:nth-child(2) > label > span.date-input-cont"));
		exit1Date.click();

		WebElement exit2Date = driver.findElement(By.cssSelector(
				"#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(1) > td:nth-child(7) > a"));
		exit2Date.click();

		// click otel ara button
		WebElement otelAraButton = driver.findElement(
				By.cssSelector("#searchBoxForm > div.sbc-body > div:nth-child(5) > div:nth-child(2) > button"));

		otelAraButton.click();

		// new url
		String expectedUrl = "https://www.otelz.com/search/izmir/IL-8_04.04.2019_07.04.2019_0_1_5-2-0-0-0-0";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		sleep(1000);

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