package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AddDressToBasketScenarioTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeClass
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // открыть главную страницу сайта
        driver.get("https://loverepublic.ru/");
    }

    @After
    public void quitDriver() {
        // выйти из драйвера и закрыть все окна
        driver.quit();
    }

    @Test
    public void test() {
        // открыть меню
        driver.findElement(By.cssSelector("li:nth-child(3) > .with-submenu > span")).click();
        // выбрать платья
        driver.findElement(By.linkText("Платья")).click();

        // местонахождение платья на странице
        By dressBy = By.xpath("//section[contains(@class, 'catalog-section')]/div[contains(@class, 'items clearfix')][1]/div[contains(@class, 'unit-33')][3]/div");
        // ждем, пока платье прогрузится
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dressBy));
        // выбрать это платье
        driver.findElement(dressBy).click();

        // выбрать размер
        driver.findElement(By.cssSelector("#catalog-element-select-size-219093-60-170 li:nth-child(2) > label")).click();
        // добавить в корзину
        driver.findElement(By.cssSelector("#add2basket-form-219093-60 .add2basket-submit")).click();

        // перейти в корзину
        driver.findElement(By.id("dialog-basket-small-link")).click();

        // местонахождение кнопки оформления заказа на странице
        By makeOrderButtonBy = By.id("make-order");
        // ждем, пока корзина прогрузится
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(makeOrderButtonBy));

        // кнопка оформления заказа
        WebElement makeOrderButtonElement = driver.findElement(makeOrderButtonBy);
        // кнопка видна
        assertTrue(makeOrderButtonElement.isDisplayed());
        // кнопка доступна для клика
        assertTrue(makeOrderButtonElement.isEnabled());
    }

}
