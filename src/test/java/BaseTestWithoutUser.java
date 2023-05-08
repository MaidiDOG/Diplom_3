import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import rest_api.User;

import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;

public class BaseTestWithoutUser {
    public WebDriver driver;
    public User user = new User();
    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
