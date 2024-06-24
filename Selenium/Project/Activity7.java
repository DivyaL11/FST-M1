package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Reading a popup that contains additional information about the account/lead.
public class Activity7 {

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
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();

        String PageTile = driver.getTitle();
        System.out.println(PageTile);
        String CurrentURL = driver.getCurrentUrl();

        driver.findElement(By.id("adspan_dff2dd29-8a3f-22b6-bd24-5f5a7d339e97")).click();

    }

    @AfterClass
    public void cleanup() {

        //driver.quit();
    }


}
