package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private final By buttonOnLogo = By.xpath("//*[@id=\"root\"]/div/header/nav/div"); //Локатор для кнопки при нажатии на логотип
    private final By buttonOnProfilePage = By.xpath("//*[@id=\"root\"]/div/header/nav/a"); //Локатор для кнопки "Личный Кабинет"
    private final By headerDragBun = By.xpath("//*[@id=\"root\"]/div/main/section[2]/ul/li[1]/div/span/span[1]"); //Локатор для заголовка "Перетяните булочку сюда (верх)"
    private final By buttonExit = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");//Локатор кнопки выхода из аккаунта
    private final By buttonConstructor = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");//Локатор кнопки конструктора
    private final By headerLogin = By.xpath("//*[@id=\"root\"]/div/main/div/h2");//Локатор заголовка  "Войти"

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToProfilePage(){
        driver.findElement(buttonOnProfilePage).click();
    }
    public void goToLogoButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonOnLogo));
        driver.findElement(buttonOnLogo).click();
    }
    public void exitFromAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
        driver.findElement(buttonExit).click();
    }
    public boolean isExitFromAccountDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
        return driver.findElement(buttonExit).isDisplayed();
    }
    public void goToConstructor(){
        driver.findElement(buttonConstructor).click();
    }
    public boolean isConstructorDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerDragBun));
        return driver.findElement(headerDragBun).isDisplayed();
    }
    public boolean isExitDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogin));
        return driver.findElement(headerLogin).isDisplayed();
    }

}
