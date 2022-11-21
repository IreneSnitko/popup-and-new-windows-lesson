package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait10;
    private WebDriverWait webDriverWait20;

    private final String BASE_URL_99_BOTTLES = "https://www.99-bottles-of-beer.net/";

    private final String BASE_URL_WEATHER = "https://openweathermap.org/";

    private final String CLASS_LOADER_CONTAINER = "owm-loader-container";

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();

        webDriverWait20 = null;
        webDriverWait10 = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected void openBaseURL_99Bottles() {
        getDriver().get(BASE_URL_99_BOTTLES);
    }

    protected void openBaseURL_OpenWeatherMap() {
        getDriver().get(BASE_URL_WEATHER);
        waitForGrayContainerDisappeared();
    }

    protected void waitForGrayContainerDisappeared() {
        getWait20().until(ExpectedConditions.invisibilityOfElementLocated(
                By.className(CLASS_LOADER_CONTAINER)));
    }
}