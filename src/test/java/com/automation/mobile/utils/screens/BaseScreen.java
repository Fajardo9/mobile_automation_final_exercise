package com.automation.mobile.utils.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;
    private static final String HOME_BUTTON = "//android.view.View[@content-desc=\"Home\"]";
    private static final String WEBVIEW_BUTTON = "Webview";
    private static final String LOGIN_BUTTON = "//android.view.View[@content-desc=\"Login\"]";
    private static final String FORMS_BUTTON = "//android.view.View[@content-desc=\"Forms\"]";
    private static final String SWIPE_BUTTON = "//android.view.View[@content-desc=\"Swipe\"]";
    private static final String DRAG_BUTTON = "//android.view.View[@content-desc=\"Drag\"]";


    @AndroidFindBy(xpath = HOME_BUTTON)
    private WebElement homeBtn;

    @AndroidFindBy(accessibility = WEBVIEW_BUTTON)
    private WebElement webviewBtn;

    @AndroidFindBy(xpath = LOGIN_BUTTON)
    private WebElement loginBtn;

    @AndroidFindBy(xpath = FORMS_BUTTON)
    private WebElement formsBtn;

    @AndroidFindBy(xpath = SWIPE_BUTTON)
    private WebElement swipeBtn;

    @AndroidFindBy(xpath = DRAG_BUTTON)
    private WebElement dragBtn;

    /**
     * Getters
     * @return web elements available in the base screen
     */

    public WebElement getHomeBtn() {
        return homeBtn;
    }

    public WebElement getWebviewBtn() {
        return webviewBtn;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getFormsBtn() {
        return formsBtn;
    }

    public WebElement getSwipeBtn() {
        return swipeBtn;
    }

    public WebElement getDragBtn() {
        return dragBtn;
    }

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        System.out.println(homeBtn.isDisplayed());
    }

    public WebDriverWait setUpWait(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public Boolean elementIsVisible(@NotNull WebElement element) {
        setUpWait(4).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public Boolean elementIsSelected(WebElement element) {
        setUpWait(4).until(ExpectedConditions.elementToBeSelected(element));
        return element.isSelected();
    }

}
