package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_SUBTITLE = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";

    public WebElement getSwipeSubtitle() {
        return swipeSubtitle;
    }

    @AndroidFindBy(uiAutomator = SWIPE_SUBTITLE)
    private WebElement swipeSubtitle;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
