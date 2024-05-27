package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.bouncycastle.cms.RecipientId.password;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    public void setup() {
        //Setup firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Intialilize driver
        driver = new FirefoxDriver();
        //Open the Page
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "creds")
    public Object[][] credentials() {
        return new Object[][]{

                {"admin", "password", "Welcome Back, admin"},
                {"admin12", "password1", "Invalid credentials"},
                {"      ", "-------", "Invalid credentials"}

        };
    }

    @Test(dataProvider = "creds")
    public void loginTest(String username, String password, String message) {
        //Find username, password and login elements
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));

        //Clear the input fields
        usernameField.clear();
        passwordField.clear();

//Enter credentials and click log in
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        //Get the confirmation message and assert
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, message);
    }

    @AfterClass
    public void tearDown() {
        //Close the browser
        driver.quit();
    }
}
