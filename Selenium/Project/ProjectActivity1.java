package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity1 {

    WebDriver driver;

        @BeforeClass

        public void setUp() {
            // Set up the Firefox driver
            WebDriverManager.firefoxdriver().setup();
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();
        }

        @Test
            public void verifyWebsiteTitle() {
            // Navigate to URL
            String url = "http://alchemy.hguy.co/crm";
            driver.get(url);

            // Get website title
            String websiteTitle = driver.getTitle();

            // Verify title
            String expectedTitle = "SuiteCRM";
            Assert.assertEquals(websiteTitle, expectedTitle, "Website title does not match expected title.");
        }

        @AfterClass
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }