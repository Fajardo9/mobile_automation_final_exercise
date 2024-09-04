package com.automation.mobile.utils.tests;

import com.automation.mobile.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public class BaseTest {

    private static final String PROPERTIES_FILE = "src/main/resources/config.properties";
    private static final Properties properties = new Properties();
    public static AndroidDriver driver;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);


    private void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTIES_FILE);
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading the properties File" + e);
        }
    }

    private static String getCapability(String variable) {
        return properties.getProperty(variable);
    }

    @BeforeClass(alwaysRun = true, groups = {"SetUp"})
    public void environmentSetup() {
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setupCapabilities(capabilities);
        try {
            driver = new AndroidDriver
                    (new URI("http://localhost:4723/").toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException("Error connecting to server" + e);
        }
    }

    public static void setupCapabilities(UiAutomator2Options capabilities) {
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
        capabilities.setApp(getCapability("app"));
        capabilities.setCapability("locatorAutocompletion", true);
    }

    public static void tearDown() {
        driver.quit();
    }

    public HomeScreen returnHomeScreen() {
        return new HomeScreen(driver);
    }

    public WebView returnWebViewScreen() {
        return new WebView(driver);
    }

    public LoginScreen returnLoginScreen() {
        return new LoginScreen(driver);
    }

    public FormsScreen returnFormsScreen() {
        return new FormsScreen(driver);
    }

    public SwipeScreen returnSwipeScreen() {
        return new SwipeScreen(driver);
    }

    public DragScreen returnDragScreen() {
        return new DragScreen(driver);
    }

    public void swipeHorizontal(double startPercentage, double endPercentage, double anchorPercentageX, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentageX / 100);
        int startPoint = (int) (size.width * startPercentage / 100);
        int endPoint = (int) (size.width * endPercentage / 100);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startPoint, anchor))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endPoint, anchor))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeVertical(double startPercentage, double endPercentage, double anchorPercentageY, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentageY / 100);
        int startPoint = (int) (size.height * startPercentage / 100);
        int endPoint = (int) (size.height * endPercentage / 100);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), anchor, startPoint))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), anchor, endPoint))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public WebDriverWait setUpWait(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public Boolean elementIsVisible(@NotNull WebElement element) {
        try{
            setUpWait(4).until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            return  false;
        }
        return element.isDisplayed();
    }

    public Boolean elementIsSelected(WebElement element) {
        try{
            setUpWait(4).until(ExpectedConditions.elementToBeSelected(element));
        }catch (TimeoutException e){
            return  false;
        }
        return element.isSelected();
    }

    public boolean elementIsNotVisible(WebElement element) {
        try{
            return setUpWait(4).until(ExpectedConditions.invisibilityOf(element));
        }catch (TimeoutException e){
            return  false;
        }
    }

}
