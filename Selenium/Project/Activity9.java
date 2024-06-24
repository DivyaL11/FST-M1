package project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
            WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Set up the Firefox driver
            WebDriverManager.firefoxdriver().setup();
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();
        }

    @Test
        public void printUsernamesAndFullNamesFromLeadsPage() {
            // Navigate to Alchemy CRM and login
            String url = "http://alchemy.hguy.co/crm";
            driver.get(url);
            driver.findElement(By.id("user_name")).sendKeys("admin");  // Replace with your username
            driver.findElement(By.id("username_password")).sendKeys("password");  // Replace with your password
            driver.findElement(By.id("bigbutton")).click();

            // Navigate to Leads page
            driver.findElement(By.id("grouptab_0")).click();  // Click on "Sales" menu
            driver.findElement(By.id("moduleTab_9_Leads")).click();  // Click on "Leads" submenu

            // Wait for Leads page to load (assuming the table is dynamically loaded)
            try {
                Thread.sleep(3000);  // Add a delay to ensure the table is fully loaded (not recommended for production use)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Print usernames and full names from the table
            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
            for (WebElement row : rows) {
                WebElement usernameElement = row.findElement(By.xpath(".//td[9]"));  // Assuming username is in 9th column
                WebElement fullNameElement = row.findElement(By.xpath(".//td[3]"));   // Assuming full name is in 3rd column
                String username = usernameElement.getText();
                String fullName = fullNameElement.getText();
                System.out.println("Username: " + username + ", Full Name: " + fullName);
            }
        }

        @AfterClass
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }