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

public class ListIcon {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
  
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSelectListIcon() {
        // Navigate to "Women" > "Tops" section
        WebElement womenMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women")));
        womenMenu.click();
        
        WebElement topsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tops")));
        topsMenu.click();

        // Wait for the list icon to be visible and click it
        WebElement listIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mode-list")));
        listIcon.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

