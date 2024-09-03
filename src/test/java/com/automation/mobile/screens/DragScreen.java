package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DragScreen extends BaseScreen {
    private static final String HEAD_PIECE = "//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView";
    private static final String PUZZLE_TEMPLATE = "//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.widget.ImageView";

    public WebElement getPuzzleTemplate() {
        return puzzleTemplate;
    }

    public WebElement getHeadPiece() {
        return headPiece;
    }

    @AndroidFindBy(xpath = PUZZLE_TEMPLATE)
    private WebElement puzzleTemplate;
    @AndroidFindBy(xpath = HEAD_PIECE)
    private WebElement headPiece;

    public DragScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
