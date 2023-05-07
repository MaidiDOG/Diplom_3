import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;
import restApi.User;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class ProfilePageTest {
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
