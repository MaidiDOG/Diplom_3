package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {
    /*
    Переменные окружения, прописанные в системе:
    BROWSER_DRIVERS - путь к папке с драйверами для браузеров
    YANDEX_BROWSER_DRIVER_FILENAME - имя файла драйвера Яндекс браузера (Хромдрайвера нужной версии)
    YANDEX_BROWSER_PATH - путь к исполняемому файлу Яндекс браузера в системе
    */
    private static final String YANDEX_BROWSER = "C:/Users/Александр/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv(YANDEX_BROWSER));
        return new ChromeDriver(options);
    }
}