package com.otelz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class logInTest {

	@Test
	public void Test() {
		System.out.println("Starting logInTest test");

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

		sleep(4000);

		// click giris yap
		WebElement girisYap = driver.findElement(By.className("menu-text"));
		girisYap.click();

		// enter username
		WebElement username = driver.findElement(By.cssSelector("#txtEmail"));
		username.sendKeys("ezgittaner@gmail.com");

		// enter password
		WebElement password = driver.findElement(By.cssSelector("#txtSifre"));
		password.sendKeys("testforotelz");

		// push log in button
		WebElement logInButton = driver.findElement(By.cssSelector(
				"#wrapper > div.headerv3-top > div > div.navbar-right.navbar-icons-menu > div.headerv3-ddl.ddl-logins.responsive-position.active > div.headerv3-ddl-content > div > div.headerv3-ddl-kullanici-content.stilliinput.js-loginminipage.clearfix > div.headerv3-ddl-kullanici-left > div.ddl-form-container > div.yuvarlatilmisgolgelibutton.button-0896ff-fff.js-dologintop.half-width-md.full-width-sm"));
		logInButton.click();

		// new url
		String expectedUrl = "https://www.otelz.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		// correct message
		WebElement successMessage = driver
				.findElement(By.cssSelector("#searchBoxForm > div.sbc-header.clearfix > div.scb-header-left > h1"));
		String expectedSuccessMessage = "En Uygun Otelleri Bul";
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
