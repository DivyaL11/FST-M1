package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net");
        Reporter.log("Browser Opened");
    }

    @Test
    public void homepageTest() {
        // Get and assert the title of the home page
        Assert.assertEquals(driver.getTitle(), "Training Support");
        Reporter.log("Homepage Loaded");

        //Find and click About Us Link
        driver.findElement(By.id("about-link")).click();

        //Assertion for page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
        Reporter.log("About Us page loaded");
    }

    @AfterClass
    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");
        driver.quit();
    }

}