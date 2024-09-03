package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen {
    private static final String LOGIN_TITLE = "new UiSelector().text(\"Login / Sign up Form\")";
    private static final String SELECT_LOGIN = "new UiSelector().text(\"Login\").instance(0)";
    private static final String SELECT_SIGN_UP = "new UiSelector().text(\"Sign up\")";
    private static final String EMAIL_FIELD = "input-email";
    private static final String PASSWORD_FIELD = "input-password";
    private static final String CONFIRM_PASSWORD_FIELD = "input-repeat-password";
    private static final String BIOMETRIC_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").instance(16)";
    private static final String LOGIN_BUTTON = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup";
    private static final String SIGN_UP_BUTTON = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup";
    private static final String LOGIN_POPUP = "android:id/alertTitle";
    private static final String OK_BUTTON = "android:id/button1";

    @AndroidFindBy(uiAutomator = LOGIN_TITLE)
    private WebElement loginTitle;
    @AndroidFindBy(uiAutomator = SELECT_LOGIN)
    private WebElement selectLogin;
    @AndroidFindBy(uiAutomator = SELECT_SIGN_UP)
    private WebElement selectSignUp;
    @AndroidFindBy(accessibility = EMAIL_FIELD)
    private WebElement emailField;
    @AndroidFindBy(accessibility = PASSWORD_FIELD)
    private WebElement passwordField;
    @AndroidFindBy(accessibility = CONFIRM_PASSWORD_FIELD)
    private WebElement confirmPasswordField;
    @AndroidFindBy(uiAutomator = BIOMETRIC_BUTTON)
    private WebElement biometricLoginBtn;
    @AndroidFindBy(xpath = LOGIN_BUTTON)
    private WebElement loginBtn;
    @AndroidFindBy(xpath = SIGN_UP_BUTTON)
    private WebElement signUpBtn;
    @AndroidFindBy(id = LOGIN_POPUP)
    private WebElement loginPopup;
    @AndroidFindBy(id = OK_BUTTON)
    private WebElement okBtn;

    public WebElement getLoginTitle() {
        return loginTitle;
    }

    public WebElement getSelectLogin() {
        return selectLogin;
    }

    public WebElement getSelectSignUp() {
        return selectSignUp;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getBiometricLoginBtn() {
        return biometricLoginBtn;
    }

    public WebElement getUsrLoginBtn() {
        return loginBtn;
    }

    public WebElement getSignUpBtn() {
        return signUpBtn;
    }

    public WebElement getLoginPopup() {
        return loginPopup;
    }

    public WebElement getOkBtn() {
        return okBtn;
    }

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
