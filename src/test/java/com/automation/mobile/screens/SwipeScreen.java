package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_TITLE = "new UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_SUBTITLE = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")";
    private static final String VISIBLE_CARD = "new UiSelector().description(\"card\").instance(1)";
    private static final String FINAL_CARD = "card";
    //private static final String GITHUB_CARD = "new UiSelector().text(\"FULLY OPEN SOURCE\")";
    private static final String GITHUB_CARD = "//android.widget.TextView[@text=\"FULLY OPEN SOURCE\"]";
    private static final String COMMUNITY_CARD = "new UiSelector().text(\"GREAT COMMUNITY\")";
    private static final String JS_FOUNDATION_CARD = "new UiSelector().text(\"JS.FOUNDATION\")";
    private static final String SUPPORT_VIDEO_CARD = "new UiSelector().text(\"SUPPORT VIDEOS\")";
    private static final String EXTENDABLE_CARD = "new UiSelector().text(\"EXTENDABLE\")";
    private static final String COMPATIBLE_CARD = "new UiSelector().text(\"COMPATIBLE\")";
    public static final String SECRET_MESSAGE = "new UiSelector().text(\"You found me!!!\")";
    private static final String SECRET_LOGO = "WebdriverIO logo";

    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement swipeTitle;
    @AndroidFindBy(uiAutomator = SWIPE_SUBTITLE)
    private WebElement swipeSubtitle;
    @AndroidFindBy(uiAutomator = VISIBLE_CARD)
    private WebElement visibleCard;
    @AndroidFindBy(accessibility = FINAL_CARD)
    private WebElement finalCard;
    @AndroidFindBy(xpath = GITHUB_CARD)
    private WebElement gitHubCard;
    @AndroidFindBy(uiAutomator = COMMUNITY_CARD)
    private WebElement communityCard;
    @AndroidFindBy(uiAutomator = JS_FOUNDATION_CARD)
    private WebElement jsFoundationCard;
    @AndroidFindBy(uiAutomator = SUPPORT_VIDEO_CARD)
    private WebElement supportVideoCard;
    @AndroidFindBy(uiAutomator = EXTENDABLE_CARD)
    private WebElement extendableCard;
    @AndroidFindBy(uiAutomator = COMPATIBLE_CARD)
    private WebElement compatibleCard;
    @AndroidFindBy(uiAutomator = SECRET_MESSAGE)
    private WebElement secretMessage;
    @AndroidFindBy(accessibility = SECRET_LOGO)
    private WebElement secretLogo;

    public WebElement getSwipeTitle() {
        return swipeTitle;
    }

    public WebElement getSwipeSubtitle() {
        return swipeSubtitle;
    }

    public WebElement getVisibleCard() {
        return visibleCard;
    }

    public WebElement getFinalCard() {
        return finalCard;
    }

    public WebElement getGitHubCard() {
        return gitHubCard;
    }

    public WebElement getCommunityCard() {
        return communityCard;
    }

    public WebElement getJsFoundationCard() {
        return jsFoundationCard;
    }

    public WebElement getSupportVideoCard() {
        return supportVideoCard;
    }

    public WebElement getExtendableCard() {
        return extendableCard;
    }

    public WebElement getCompatibleCard() {
        return compatibleCard;
    }

    public WebElement getSecretMessage() {
        return secretMessage;
    }

    public WebElement getSecretLogo() {
        return secretLogo;
    }

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
