package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebView extends BaseScreen {
    private static final String LOADING = "android.webkit.WebView";
    @AndroidFindBy(className = LOADING)
    private WebElement loadingPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WebdriverIO\")")
    private WebElement robotIcon;

    public WebView(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getLoadingPage() {
        return loadingPage;
    }

    public WebElement getRobotIcon() {
        return robotIcon;
    }
}
