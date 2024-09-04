package com.automation.mobile.test;

import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WebdriverIOSwipeTest extends BaseTest {
    private SwipeScreen swipeScreen;
    private final List<WebElement> availableCards = new ArrayList<>();

    private void initCardsList() {
        availableCards.add(0, swipeScreen.getGitHubCard());
        availableCards.add(1, swipeScreen.getCommunityCard());
        availableCards.add(2, swipeScreen.getJsFoundationCard());
        availableCards.add(3, swipeScreen.getSupportVideoCard());
        availableCards.add(4, swipeScreen.getExtendableCard());
        availableCards.add(5, swipeScreen.getCompatibleCard());
    }

    @BeforeClass(groups = {"SetUp"})
    public void setUp() {
        swipeScreen = returnSwipeScreen();
        initCardsList();
        swipeScreen.getSwipeBtn().click();
        Assert.assertTrue(elementIsSelected(swipeScreen.getSwipeBtn()));
        Assert.assertTrue(elementIsVisible(swipeScreen.getSwipeSubtitle()));
    }

    @Test(groups = {"Swipe Cards", "Regression"})
    public void swipeCardsTest() {
        for (int i = 0; i <= availableCards.size() - 1; i++) {
            Assert.assertTrue(elementIsVisible(availableCards.get(i)));
            swipeHorizontal(75, 15, 65, 200);
            if (i == availableCards.size() - 1) {
                elementIsVisible(swipeScreen.getFinalCard());
            } else {
                Assert.assertTrue(elementIsVisible(availableCards.get(i + 1)));
                log.info(availableCards.get(i + 1).getDomAttribute("text"));
                elementIsNotVisible(availableCards.get(i));
            }

        }

    }

    @Test(groups = {"Swipe To Bottom", "Regression"})
    public void swipeToBottomTest() {
        Date dateTime = new Date();
        Long initTime = dateTime.getTime();
        Assert.assertTrue(elementIsVisible(swipeScreen.getSwipeTitle()));
        do {
            Long passedTime = dateTime.getTime();
            if(passedTime-initTime>=10) break;
            swipeVertical(30, 5, 50, 100);
        } while (!isElementVisible(swipeScreen.getSecretMessage()));
        Assert.assertTrue(isElementVisible(swipeScreen.getSecretLogo()));
        log.info("Secret information found");
    }


    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NullPointerException | TimeoutException | NoSuchElementException e) {
            return false;
        }
    }


    @Override
    public void swipeVertical(double startPercentage, double endPercentage, double anchorPercentageY, int duration) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentageY / 100);
        int startPoint = (int) (size.height * startPercentage / 100);
        int endPoint = (int) (size.height * endPercentage / 100);
        if (elementIsVisible(swipeScreen.getVisibleCard())) {
            Rectangle rectangle = swipeScreen.getVisibleCard().getRect();
            int cardTopY = rectangle.getY();
            int cardBottomY = rectangle.getY() + rectangle.getHeight();
            if (startPoint >= cardTopY && startPoint <= cardBottomY) {
                startPoint = cardBottomY + 20;
            }
            if (endPoint >= cardTopY && endPoint <= cardBottomY) {
                endPoint = cardTopY - 20;
            } else if (elementIsVisible(swipeScreen.getFinalCard())) {
                rectangle = swipeScreen.getFinalCard().getRect();
                cardTopY = rectangle.getY();
                cardBottomY = rectangle.getY() + rectangle.getHeight();
                if (startPoint >= cardTopY && startPoint <= cardBottomY) {
                    startPoint = cardBottomY + 20;
                }
            }


                log.info("Tap positions: {}", "Anchor "+ anchor + " Start point " + startPoint + " End point " + endPoint);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1)
                        .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), anchor, startPoint))
                        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), anchor, endPoint))
                        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(swipe));
            }


        }
}
