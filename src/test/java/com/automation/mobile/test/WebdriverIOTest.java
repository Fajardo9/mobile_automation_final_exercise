package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebdriverIOTest extends BaseTest {
    public static final Logger log = LoggerFactory.getLogger(WebdriverIOTest.class);

    @Test(groups = {"SmokeTest","Regression"})
    public void testWebdriverUsabilityOfBottomMenuBar() {
        log.info("Verifying user home screen");
        HomeScreen homeScreen = returnHomeScreen();
        //Assert.assertTrue(getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Home\"]")).isDisplayed());
        Assert.assertTrue(homeScreen.elementIsSelected(homeScreen.getHomeBtn()));
        Assert.assertTrue(homeScreen.elementIsVisible(homeScreen.getImageView()));
        Assert.assertTrue(homeScreen.elementIsVisible(homeScreen.getWebviewBtn()));
        log.info("Verifying webview screen");
        homeScreen.getWebviewBtn().click();
        Assert.assertTrue(homeScreen.elementIsSelected(homeScreen.getWebviewBtn()));
        WebView webViewScreen = returnWebViewScreen();
        Assert.assertTrue(webViewScreen.elementIsVisible(webViewScreen.getLoadingPage()));
        log.info("Verifying login screen");
        LoginScreen loginScreen = returnLoginScreen();
        loginScreen.getLoginBtn().click();
        Assert.assertTrue(loginScreen.elementIsSelected(loginScreen.getLoginBtn()));
        Assert.assertTrue(loginScreen.elementIsVisible(loginScreen.getLoginTitle()));
        log.info("Verifying forms screen");
        FormsScreen formsScreen = returnFormsScreen();
        formsScreen.getFormsBtn().click();
        Assert.assertTrue(formsScreen.elementIsSelected(formsScreen.getFormsBtn()));
        Assert.assertTrue(formsScreen.elementIsVisible(formsScreen.getFormsTitle()));
        log.info("Verifying swipe screen");
        SwipeScreen swipeScreen = returnSwipeScreen();
        formsScreen.getSwipeBtn().click();
        Assert.assertTrue(swipeScreen.elementIsSelected(swipeScreen.getSwipeBtn()));
        Assert.assertTrue(swipeScreen.elementIsVisible(swipeScreen.getSwipeSubtitle()));
        log.info("Verifying drag screen");
        DragScreen dragScreen = returnDragScreen();
        dragScreen.getDragBtn().click();
        Assert.assertTrue(dragScreen.elementIsSelected(dragScreen.getDragBtn()));
        Assert.assertTrue(dragScreen.elementIsVisible(dragScreen.getPuzzleTemplate()));

    }

}
