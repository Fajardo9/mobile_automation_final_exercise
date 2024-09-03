package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormsScreen extends BaseScreen {
    public static final String FORMS_TITLE = "new UiSelector().className(\"android.view.ViewGroup\").instance(7)";

    public WebElement getFormsTitle() {
        return formsTitle;
    }

    @AndroidFindBy(uiAutomator = FORMS_TITLE)
    private WebElement formsTitle;
    public FormsScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
