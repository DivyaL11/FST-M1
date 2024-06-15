package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static liveProject.W3CActionsBase.doSwipe;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Andriod");
        options.setPlatformName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

// Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
// Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Open Selenium Page
        driver.get("https://v1.training-support.net/selenium");
    }

        @Test
        public void webAppTest() throws InterruptedException{
            //Get width and height of the screen
            Dimension dims = driver.manage().window().getSize();

            //Wait for the page to load
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

    //scroll(fling) to the end of the page
            Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.7));
            Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.5));
            doSwipe(driver, start, end, 70);

            //wait for To-Do List link and click it
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText")));

            //find elements on the page
            WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
            WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

            //Enter Tasks
            addTaskInput.sendKeys("Add Task to list");
            addTaskButton.click();
            Thread.sleep(1000);
            addTaskInput.sendKeys("Get number of tasks");
            addTaskButton.click();
            Thread.sleep(1000);
            addTaskInput.sendKeys("Clear the list");
            addTaskButton.click();
            Thread.sleep(1000);

            //Clear the list
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text= 'Clear List']")).click();


            //Assertion
            List<WebElement> tasksAdded = driver.findElements(AppiumBy.xpath("//android.webkit.WebView[@text='Todo List']/android.view.View/android.view.View"));
            Assert.assertEquals(tasksAdded.size(),0);
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }
    }

