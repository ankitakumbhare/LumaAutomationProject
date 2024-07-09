package LumaProjectAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Color {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize WebDriver
		driver = new ChromeDriver();

		// Initialize WebDriverWait with a timeout of 10 seconds
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Maximize the browser window
		driver.manage().window().maximize();
	}

	@Test
	public void testSelectSizeM() {

		// Navigate to the Magento site
		driver.get("https://magento.softwaretestingboard.com");

		// Wait for the 'Hot Sellers' section to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'radiant-tee')]")));

		// Locate the 'Radiant Tee' card within the 'Hot Sellers' section
		WebElement radiantTeeCard = driver.findElement(By.xpath("//a[contains(@href, 'radiant-tee')]"));

		// Click on the 'Radiant Tee' card
		radiantTeeCard.click();

		// Wait for the size 'M' option to be visible
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='option-label-size-143-item-168']")));

		// Select the size 'M'
		WebElement sizeM = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']"));
		sizeM.click();
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
