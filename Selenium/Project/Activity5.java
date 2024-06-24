package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @BeforeClass

    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @Test
    public void method() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        Thread.sleep(2000);
        driver.findElement(By.id("bigbutton")).click();
        String colour = driver.findElement(By.xpath("//div[@id='toolbar'and @class='desktop-toolbar']")).getCssValue("colour");
        System.out.println(colour);

    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }


}
