package LumaProjectAutomation.Luma_Project_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GearMenu {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testGearMenuNavigation() throws InterruptedException {
     
        // Find the "Gear" menu item
        WebElement gearMenu = driver.findElement(By.xpath("//span[text()='Gear']/ancestor::a"));

        // Initialize Actions class to perform mouse hover
        Actions actions = new Actions(driver);
        actions.moveToElement(gearMenu).perform();

        Thread.sleep(3000);

        List<WebElement> gearSubmenuItems = driver.findElements(By.xpath("//span[text()='Gear']/ancestor::li//li/a"));

        for (WebElement item : gearSubmenuItems) {
            System.out.println(item.getText());
        }

        WebElement specificItem = driver.findElement(By.xpath("//span[text()='Gear']/ancestor::li//a[contains(@href, 'gear/bags')]"));
        specificItem.click();

        // Wait for the navigation to complete
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
