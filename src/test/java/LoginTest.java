import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;

import org.junit.Test;

import pages.LoginPage;


public class LoginTest extends BaseTestWithUser {
    @Test
    @DisplayName("Вход через Личный Кабинет")
    public void checkLoginByEnterAccountButtonTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через Войти в аккаунт")
    public void checkLoginByHeaderLinkTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageByEnterAccountButton();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через страницу регистрации")
    public void checkLoginByButtonFromRegistrationPageTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageFromRegistration();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }
    @Test
    @DisplayName("Вход через страницу восстановления пароля")
    public void checkLoginByButtonFromForgotPasswordPageTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageFromForgotPassword();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }
}
