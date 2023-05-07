import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import restApi.User;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class LoginTest {
    private WebDriver driver;
    private User user = new User();
    private String email;
    private String password;
    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);

        email = "AleX_Kosmos@test.ru";
        password = "qwert123";
        user.registerNewUser(email, password, "Alex");
    }
    @After
    public void teardown() {
        user.deleteUser(email, password);
        driver.quit();
    }
    @Test
    @DisplayName("Вход через Личный Кабинет")
    public void LoginByEnterAccountButtonTest() {
        LoginPage page = new LoginPage(driver);
        page.goToLoginPageByHeaderLink();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через Войти в аккаунт")
    public void LoginByHeaderLinkTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageByEnterAccountButton();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через страницу регистрации")
    public void LoginByButtonFromRegistrationPageTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageFromRegistration();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }
    @Test
    @DisplayName("Вход черезстраницу восстановления пароля")
    public void LoginByButtonFromForgotPasswordPageTest() {
        LoginPage page = new LoginPage(driver);
        page.gotoLoginPageFromForgotPassword();
        page.loginAccount(email, password);
        Assert.assertTrue(page.isCheckoutButtonDisplayed());
    }
}
