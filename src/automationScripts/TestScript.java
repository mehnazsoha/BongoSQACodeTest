package automationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://bongobd.com/");
		driver.manage().window().maximize(); // Maximize the window
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END); // Go to the end of a page
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME); // Go to the home of a page
		Thread.sleep(2000);

		for (int i = 1; i < 5; i++) {
			String pathString = "(//div[contains(@class,'MuiGrid-root')]/div/div/div/div/div[contains(@class,'slick-slide slick-active')]/div/div/button/a[contains(@href,'watch')])["
					+ i + "]";
			driver.findElement(By.xpath(pathString)).click();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(30000);
			driver.navigate().back(); // Back to the previous page
			Thread.sleep(3000);
		}
		driver.close(); // Close the window
	}
}