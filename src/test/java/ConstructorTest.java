import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ConstructorPage;
import static config.AppConfig.BASE_URL;
import static config.WebDriverFactory.createWebDriver;


public class ConstructorTest {
    public WebDriver driver;
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
    @DisplayName("Переход к разделу с начинкой")
    public void gotoFillingSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToFillingSegment();
        Assert.assertTrue(page.isFillingSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу соусу из раздела с начинкой")
    public void gotoSauceSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToFillingSegment();
        page.goToSauceSegment();
        Assert.assertTrue(page.isSauceSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу булок из раздела с соусом")
    public void gotoBunSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToSauceSegment();
        page.goToBunSegment();
        Assert.assertTrue(page.isBunSegmentDisplayed());
    }
}
