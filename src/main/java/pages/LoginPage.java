package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    //Локаторы для кнопки/поля для входа в "Личный Кабинет"
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']"); //локатор для кнопки "Войти в аккаунт"
    private final By getOrderButton = By.xpath("//button[text() = 'Оформить заказ']"); //локатор для кнопки "Войти в аккаунт"
    private final By emailFieldForLogin = By.xpath("//label[text() = 'Email']/parent::*/input"); //Поле для ввода email на странице входа
    private final By passwordFieldForLogin = By.xpath("//label[text() = 'Пароль']/parent::*/input"); //Поле для ввода password на странице входа
    private final By buttonForLoginInRegister = By.xpath("//a[text() = 'Войти']"); //Локтор для кнопки "Войти" на странице регистрации.
    private final By loginButtonForLogin = By.xpath("//button[text() = 'Войти']");
    //Локаторы для кнопки/поля для регистрации аккаунта
    private final By nameFieldForRegister = By.xpath("//label[text() = 'Имя']/parent::*/input");
    private final By emailFieldForRegister = By.xpath("//label[text() = 'Email']/parent::*/input");
    private final By passwordFieldForRegister = By.xpath("//label[text() = 'Пароль']/parent::*/input");
    private final By registerButtonForRegister = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By buttonForLoginAfterRegister = By.xpath("//button[text() = 'Войти']"); //Локтор для кнопки "Войти" после регистрации.
    private By registrationLinkButton = By.xpath("//a[text() = 'Зарегистрироваться']");
    private By incorrectPassword = By.xpath("//*[text() = 'Некорректный пароль']");
    //Локаторы для кнопки/поля для восстановления пароля
    private final By buttonForRestPassword = By.xpath("//a[text() = 'Восстановить пароль']"); //Забыли пароль? Восстановить пароль
    private final By buttonForLoginInRestPassword = By.xpath("//a[text() = 'Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step ("Перейти на страницу входа")
    public void gotoLoginPageByEnterAccountButton(){
        driver.findElement(loginButton).click();
    }
    @Step("Перейти на страницу регистрации")
    public void gotoRegistrationPage(){
        this.gotoLoginPageByEnterAccountButton();
        WebElement element = driver.findElement(registrationLinkButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    @Step ("Регистрация нового аккаунта")
    public void registerNewAccount(String name, String email, String password){
        driver.findElement(nameFieldForRegister).clear();
        driver.findElement(nameFieldForRegister).sendKeys(name);

        driver.findElement(emailFieldForRegister).clear();
        driver.findElement(emailFieldForRegister).sendKeys(email);

        driver.findElement(passwordFieldForRegister).clear();
        driver.findElement(passwordFieldForRegister).sendKeys(password);

        driver.findElement(registerButtonForRegister).click();
    }

    public boolean isIncorrectPasswordDisplayed(){
        return driver.findElement(incorrectPassword).isDisplayed();
    }

    public void goToLoginPageByHeaderLink(){
        driver.findElement(loginButton).click();
    }

    public void loginAccount(String email, String password){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonForLogin));

        driver.findElement(emailFieldForLogin).clear();
        driver.findElement(emailFieldForLogin).sendKeys(email);

        driver.findElement(passwordFieldForLogin).clear();
        driver.findElement(passwordFieldForLogin).sendKeys(password);

        driver.findElement(loginButtonForLogin).click();
    }

    public boolean isCheckoutButtonDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(getOrderButton));

        return driver.findElement(getOrderButton).isDisplayed();
    }

    public boolean isLogButtonDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonForLoginAfterRegister));

        return driver.findElement(buttonForLoginAfterRegister).isDisplayed();
    }
    public void gotoLoginPageFromRegistration(){
        this.gotoRegistrationPage();
        WebElement element = driver.findElement(buttonForLoginInRegister);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void gotoForgotPasswordPage(){
        this.gotoLoginPageByEnterAccountButton();
        WebElement element = driver.findElement(buttonForRestPassword);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void gotoLoginPageFromForgotPassword(){
        this.gotoForgotPasswordPage();
        WebElement element = driver.findElement(buttonForLoginInRestPassword);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}

