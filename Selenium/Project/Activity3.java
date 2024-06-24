package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass

    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
    @Test
    public void method() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        String ImageURL = headerImage.getAttribute("src");
        System.out.println(ImageURL);
        //Get the copyright text

    }
    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}

//text in the footer is not coming.


