package com.automation.mobile.test;

import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.User;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WebdriverIOLoginTest extends BaseTest {

    private static final String[] NAMES = {"Jennifer", "Alejandro", "Santiago",
            "Stephany", "Carlos", "Arley", "Julian"};
    private static final String ALPHABETICAL_CHARACTERS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String NUMERICAL_CHARACTERS = "0123456789";
    private static final String SYMBOLIC_CHARACTERS = "!@#$%^&*()_-=+[]{}\\|;:'\",.<>/?";
    private static final String[] DOMAINS = {"@mail.com", "@globant.com", "@gmail.com"};

    private LoginScreen loginScreen;
    private List<User> userList;

    private static List<User> usersGenerator(int usersToGenerate, int minLengthPassword, int maxLengthPassword) {
        List<User> users = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < usersToGenerate; i++) {
            String userName = NAMES[random.nextInt((NAMES.length))];
            String domain = DOMAINS[random.nextInt(DOMAINS.length)];
            int suffix = random.nextInt(1000);
            String email = userName + suffix + domain;
            StringBuilder genPassword = new StringBuilder();
            int passwordLength = minLengthPassword + random.nextInt(maxLengthPassword - minLengthPassword + 1);
            for (int j = 0; j < passwordLength; j++) {
                if (j < passwordLength - 3) {
                    genPassword.append(ALPHABETICAL_CHARACTERS.charAt(random.nextInt(ALPHABETICAL_CHARACTERS.length())));
                } else if (j < passwordLength - 1) {
                    genPassword.append(NUMERICAL_CHARACTERS.charAt(random.nextInt(NUMERICAL_CHARACTERS.length())));
                } else {
                    genPassword.append(SYMBOLIC_CHARACTERS.charAt(random.nextInt(SYMBOLIC_CHARACTERS.length())));
                }
            }
            String password = genPassword.toString();
            users.add(new User(userName, password, email));
        }
        return users;
    }

    private void performLogin(List<User> users){
        loginScreen.getSelectLogin().click();
        for (User user: users) {
            loginScreen.getEmailField().sendKeys(user.getEmail());
            loginScreen.getPasswordField().sendKeys(user.getPassword());
            loginScreen.getUsrLoginBtn().click();
            Assert.assertTrue(elementIsVisible(loginScreen.getLoginPopup()));
            loginScreen.getOkBtn().click();
            loginScreen.getEmailField().clear();
            loginScreen.getPasswordField().clear();
        }
    }

    private void performSignUp(List<User> users){
        loginScreen.getSelectSignUp().click();
        for (User user: users) {
            Assert.assertTrue(elementIsVisible(loginScreen.getConfirmPasswordField()));
            loginScreen.getEmailField().sendKeys(user.getEmail());
            loginScreen.getPasswordField().sendKeys(user.getPassword());
            loginScreen.getConfirmPasswordField().sendKeys(user.getPassword());
            loginScreen.getSignUpBtn().click();
            Assert.assertTrue(elementIsVisible(loginScreen.getLoginPopup()));
            loginScreen.getOkBtn().click();
            loginScreen.getEmailField().clear();
            loginScreen.getPasswordField().clear();
            loginScreen.getConfirmPasswordField().clear();
        }


    }
    @BeforeClass(groups = {"SetUp"})
    @Parameters({"usersToGenerate","minLengthPassword","maxLengthPassword"})
    public void setUp(int usersToGenerate, int minLengthPassword, int maxLengthPassword) {
        loginScreen = returnLoginScreen();
        loginScreen.getLoginBtn().click();
        Assert.assertTrue(elementIsSelected(loginScreen.getLoginBtn()));
        Assert.assertTrue(elementIsVisible(loginScreen.getLoginTitle()));
        userList = usersGenerator(usersToGenerate,minLengthPassword,maxLengthPassword);
    }

    @Test(groups = {"Login","Regression"})
    public void testWebdriverIOLogin() {
        performLogin(userList);
    }

    @Test(groups = {"SignUp", "Regression"})
    public void testWebdriverIOSignup() {
        performSignUp(userList);
    }

}
