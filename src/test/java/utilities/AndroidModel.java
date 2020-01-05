package utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AndroidModel {

    private static AndroidDriver driver;
    private static FluentWait<MobileDriver> wait;

    public static void closeDriver() {
        driver.quit();
    }

    public static List<AndroidElement> findElementsBy(By element) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return driver.findElements(element);
    }

    public static AndroidElement findElementBy(By element) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return (AndroidElement) driver.findElement(element);
    }

    public static AndroidElement findElementByText(String element) {
        By by = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + element + "\")");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return (AndroidElement) driver.findElement(by);
    }

    public static AndroidElement scrollToElement(By element) {
        return (AndroidElement) driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector()" +
                        ".resourceId(" + element + ")).instance(0))");
    }

    public static AndroidElement scrollToText(String text) {
        return (AndroidElement) driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))")
                ;
    }

    public static void swipe(int fromX, int fromY, int offsetX, int offsetY) {
        (new TouchAction(driver))
                .press(PointOption.point(fromX, fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(offsetX, offsetY))
                .release()
                .perform();
    }

    public static void swipeDown() {
        swipe(30, 1316, 30, 800);
    }

    public static void swipeUp() {
        swipe(30, 800, 30, 1316);
    }

    public static void sendText(By element, String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        driver.findElement(element).sendKeys(text);
    }

    public static void waitElementToBePresent(By element) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    public static void waitElementToBePresentWithText(String element) {
        By by = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + element + "\")");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    private static void setUpFluentWait() {
        wait = new FluentWait<>((MobileDriver) driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class);
    }

    public static void startDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Mobile Device");
        caps.setCapability("udid", "304e573834443098");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "pl.otomoto");
        caps.setCapability("appActivity", "com.fixeads.verticals.cars.startup.view.activities.StartupActivity");
        caps.setCapability("browserName", "");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4783/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        setUpFluentWait();
    }
}
