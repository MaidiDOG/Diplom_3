import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;

import org.junit.Test;

import pages.LoginPage;


public class RegistrationTest extends BaseTestWithoutUser {
    @Test
    @DisplayName("Регистрация нового аккаунта через форму регистрации")
    public void checkRegistrationTest(){
        LoginPage page = new LoginPage(driver);
        page.gotoRegistrationPage();
        page.registerNewAccount("Alex", "Alex_Kosmin_1998@test.ru", "qwerty45678");
        Assert.assertTrue(page.isLogButtonDisplayed());
        user.deleteUser("Alex_Kosmin_1998@test.ru", "qwerty45678");
    }
    @Test
    @DisplayName("Попытка регистрации аккаунта с некорректным паролем")
    public void checkRegistrationWithIncorrectPasswordTest(){
        LoginPage page = new LoginPage(driver);
        page.gotoRegistrationPage();
        page.registerNewAccount("Alex", "AlexKosmis@test.ru", "qwer1");
        Assert.assertTrue(page.isIncorrectPasswordDisplayed());
    }
}