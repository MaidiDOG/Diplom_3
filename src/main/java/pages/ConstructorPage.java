package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class ConstructorPage {
    private WebDriver driver;
    //Заголовки игнредиентов
    private By bunHeader = By.xpath(".//div/span[text()='Булки']");
    private By sauceHeader = By.xpath(".//div/span[text()='Соусы']");
    private By fillingHeader = By.xpath(".//div/span[text()='Начинки']");

    //Выбранные элементы
    private static final By bunSegment = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Булки']");
    private static final By sauceSegment = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Соусы']");
    private static final By fillingSegment = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Начинки']");


    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Переход к булкам")
    public void goToBunSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunHeader));
        driver.findElement(bunHeader).click();
    }

    @Step("Переход к соусам")
    public void goToSauceSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceHeader));
        driver.findElement(sauceHeader).click();
    }

    @Step("Переход к начинкам")
    public void goToFillingSegment() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingHeader));
        driver.findElement(fillingHeader).click();
    }

    @Step("Булки отображаются")
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
