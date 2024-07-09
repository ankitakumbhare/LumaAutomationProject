package LumaProjectAutomation.Luma_Project_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrainingMenu {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testVideoDownloadOption() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");

        // Find the "Training" dropdown menu
        WebElement trainingDropdown = driver.findElement(By.xpath("//span[text()='Training']"));

        // Initialize Actions class to perform mouse hover
        Actions actions = new Actions(driver);
        actions.moveToElement(trainingDropdown).perform();

        // Wait for the dropdown to be displayed
        Thread.sleep(2000);

        // Find and click the "Video Download" option
        WebElement videoDownloadOption = driver.findElement(By.xpath("//span[text()='Video Download']"));
        videoDownloadOption.click();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
