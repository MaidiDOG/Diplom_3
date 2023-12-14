import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;

import org.junit.Test;

import pages.LoginPage;
import pages.ProfilePage;


public class ProfilePageTest extends BaseTestWithUser {
    @Test
    @DisplayName("Переход по клику на Личный Кабинет")
    public void checkTransitionToProfilePageTest(){
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        Assert.assertTrue(pPage.isExitFromAccountDisplayed());
    }
    @Test
    @DisplayName("Переход по клику на кнопку конструктора из личного кабинета")
    public void checkTransitionToConstructorFromProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        pPage.goToConstructor();
        Assert.assertTrue(pPage.isConstructorDisplayed());
    }
    @Test
    @DisplayName("Переход по клику на логотип из личного кабинета")
    public void checkTransitionToLogoFromProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        pPage.goToLogoButton();
        Assert.assertTrue(pPage.isConstructorDisplayed());
    }
    @Test
    @DisplayName("Выход пользователя из личного кабинета")
    public void checkExitFromProfilePageTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        ProfilePage pPage = new ProfilePage(driver);
        pPage.goToProfilePage();
        pPage.exitFromAccount();
        Assert.assertTrue(pPage.isExitDisplayed());
    }
}