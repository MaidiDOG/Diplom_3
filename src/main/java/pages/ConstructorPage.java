package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;
    //Загголовки игнредиентов
    private By bunHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span");
    private By sauceHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private By fillingHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
    //Названия для отображения ингредиентов
    private By bunSegment = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");
    private By sauceSegment = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");
    private By fillingSegment = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Переход к булкам")
    public void goToBunSegment() {
        driver.findElement(bunHeader).click();
    }

    @Step("Переход к соусам")
    public void goToSauceSegment() {
        driver.findElement(sauceHeader).click();
    }

    @Step("Переход к начинкам")
    public void goToFillingSegment() {
        driver.findElement(fillingHeader).click();
    }

    @Step("Булки отображаются>")
    public boolean isBunSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunSegment));
        return driver.findElement(bunSegment).isDisplayed();
    }

    @Step("Соусы отображаются")
    public boolean isSauceSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSegment));
        return driver.findElement(sauceSegment).isDisplayed();
    }

    @Step("Начинка отображается")
    public boolean isFillingSegmentDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSegment));
        return driver.findElement(fillingSegment).isDisplayed();
    }
}
