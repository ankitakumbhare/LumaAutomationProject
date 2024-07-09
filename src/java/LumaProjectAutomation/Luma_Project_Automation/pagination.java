package LumaProjectAutomation.Luma_Project_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class pagination {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
    }

    @Test
    public void selectShow24InMensBottoms() {
        // Navigate to Men -> Bottoms
        WebElement menMenu = driver.findElement(By.xpath("//span[text()='Men']"));
        menMenu.click();

        WebElement bottomsMenu = driver.findElement(By.xpath("//a[text()='Bottoms']"));
        bottomsMenu.click();

        // Wait for the page to load and show the "Show" dropdown
        WebElement showDropdown = driver.findElement(By.xpath("//select[@id='limiter']"));
        showDropdown.click();

        // Select "24" from the dropdown
        WebElement show24Option = driver.findElement(By.xpath("//option[text()='24']"));
        show24Option.click();

        // Verify that the 24 items per page option is selected
        WebElement selectedOption = driver.findElement(By.xpath("//select[@id='limiter']/option[@selected='selected']"));
        Assert.assertEquals(selectedOption.getText(), "24", "Show 24 option is not selected");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
