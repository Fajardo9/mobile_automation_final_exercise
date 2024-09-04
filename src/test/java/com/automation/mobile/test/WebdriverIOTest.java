package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebdriverIOTest extends BaseTest {

    @Test(groups = {"SmokeTest","Regression"})
    public void testWebdriverUsabilityOfBottomMenuBar() {
        log.info("Verifying user home screen");
        HomeScreen homeScreen = returnHomeScreen();
        //Assert.assertTrue(getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Home\"]")).isDisplayed());
        Assert.assertTrue(elementIsSelected(homeScreen.getHomeBtn()));
        Assert.assertTrue(elementIsVisible(homeScreen.getImageView()));
        Assert.assertTrue(elementIsVisible(homeScreen.getWebviewBtn()));
        log.info("Verifying webview screen");
        homeScreen.getWebviewBtn().click();
        Assert.assertTrue(elementIsSelected(homeScreen.getWebviewBtn()));
        WebView webViewScreen = returnWebViewScreen();
        Assert.assertTrue(elementIsVisible(webViewScreen.getLoadingPage()));
        log.info("Verifying login screen");
        LoginScreen loginScreen = returnLoginScreen();
        loginScreen.getLoginBtn().click();
        Assert.assertTrue(elementIsSelected(loginScreen.getLoginBtn()));
        Assert.assertTrue(elementIsVisible(loginScreen.getLoginTitle()));
        log.info("Verifying forms screen");
        FormsScreen formsScreen = returnFormsScreen();
        formsScreen.getFormsBtn().click();
        Assert.assertTrue(elementIsSelected(formsScreen.getFormsBtn()));
        Assert.assertTrue(elementIsVisible(formsScreen.getFormsTitle()));
        log.info("Verifying swipe screen");
        SwipeScreen swipeScreen = returnSwipeScreen();
        formsScreen.getSwipeBtn().click();
        Assert.assertTrue(elementIsSelected(swipeScreen.getSwipeBtn()));
        Assert.assertTrue(elementIsVisible(swipeScreen.getSwipeSubtitle()));
        log.info("Verifying drag screen");
        DragScreen dragScreen = returnDragScreen();
        dragScreen.getDragBtn().click();
        Assert.assertTrue(elementIsSelected(dragScreen.getDragBtn()));
        Assert.assertTrue(elementIsVisible(dragScreen.getPuzzleTemplate()));

    }

}
