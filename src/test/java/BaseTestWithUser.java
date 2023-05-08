import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import rest_api.User;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class BaseTestWithUser {
    public WebDriver driver;
    public User user = new User();
    public String email;
    public String password;
    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);

        email = "AleX_Kosmos2000@test.ru";
        password = "qwert123";
        user.registerNewUser(email, password, "Alex");
    }
    @After
    public void teardown() {
        user.deleteUser(email, password);
        driver.quit();
    }
}
