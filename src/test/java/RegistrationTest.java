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

public class RegistrationTest {
    public WebDriver driver;
    private User user = new User();
    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Регистрация нового аккаунта через форму регистрации")
    public void checkRegistrationTest(){
        LoginPage page = new LoginPage(driver);
        page.gotoRegistrationPage();
        page.registerNewAccount("Alex", "Alex_Kosmin98@test.ru", "qwerty45678");
        Assert.assertTrue(page.isLoginButtonDisplayed());
        user.deleteUser("Alex_Kosmin98@test.ru", "qwerty45678");
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
