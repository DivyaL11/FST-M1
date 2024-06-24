package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity2 {

    WebDriver driver;

    @BeforeClass

    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyWebsiteTitleAndGetHeaderImageURL() {
        // Navigate to URL
        String url = "http://alchemy.hguy.co/crm";
        driver.get(url);

        // Get website title
        String websiteTitle = driver.getTitle();

        // Verify title
        String expectedTitle = "SuiteCRM";
        if (!websiteTitle.equals(expectedTitle)) {
            throw new AssertionError("Website title does not match expected title.");
        }

        // Get URL of the header image
        WebElement headerImage = driver.findElement(By.xpath("//img[@class='img-responsive']"));
        String headerImageUrl = headerImage.getAttribute("src");
        System.out.println("URL of the header image: " + headerImageUrl);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    }
