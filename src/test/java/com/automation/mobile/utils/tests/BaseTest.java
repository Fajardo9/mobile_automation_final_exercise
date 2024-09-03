package com.automation.mobile.utils.tests;

import com.automation.mobile.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;


public class BaseTest {

    private static final String PROPERTIES_FILE = "src/main/resources/config.properties";
    private static final Properties properties = new Properties();
    public static AndroidDriver driver;

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

    @BeforeClass(alwaysRun = true,groups = {"SetUp"})
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

    public static AndroidDriver getDriver() {
        return driver;
    }

    public HomeScreen returnHomeScreen() {
        return new HomeScreen(driver);
    }

    public WebView returnWebViewScreen() {
        return new WebView(driver);
    }

    public LoginScreen returnLoginScreen(){
        return new LoginScreen(driver);
    }

    public FormsScreen returnFormsScreen() {
        return  new FormsScreen(driver);
    }

    public SwipeScreen returnSwipeScreen() {
        return new SwipeScreen(driver);
    }

    public DragScreen returnDragScreen() {
        return new DragScreen(driver);
    }


}
