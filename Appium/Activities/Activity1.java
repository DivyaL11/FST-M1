package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //Driver Declaration
    AndroidDriver driver;

    //Set up method

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //Set Capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.sec.android.app.popupcalculator")
                .setAppActivity(".Calculator")
                .noReset();

        //Set the server URL
        URL serverURL = new URL("http://localhost:4723/wb/hub");

        //Initialize the Android driver
        driver = new AndroidDriver(serverURL, caps);

    }

    @Test
    public void multiplyTest() {
        //Find the 7 and tap it
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
        //Find the multiply symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        //Find the 6 and tap it
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/bt_06")).click();
        //Find the equalsto symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        //Assertions
        String result = driver.findElement(AppiumBy.id("txtCalc")).getText();
        Assert.assertEquals(result, "42");
    }

    @AfterClass
    public void tearDown() {
        //close the app
        driver.quit();
    }
}

