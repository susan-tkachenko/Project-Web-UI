package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AddDressToBasketScenario {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://loverepublic.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // открыть меню
        driver.findElement(By.cssSelector("li:nth-child(3) > .with-submenu > span")).click();
        // выбрать платья
        driver.findElement(By.linkText("Платья")).click();
        // выбрать 3е платье
        driver.findElement(By.xpath("//section[contains(@class, 'catalog-section')]/div[contains(@class, 'items clearfix')][1]/div[contains(@class, 'unit-33')][3]/div")).click();
        // выбрать размер
        driver.findElement(By.cssSelector("#catalog-element-select-size-219093-60-170 li:nth-child(2) > label")).click();
        // добавить в корзину
        driver.findElement(By.cssSelector("#add2basket-form-219093-60 .add2basket-submit")).click();

        Thread.sleep(5000);
        driver.quit();
    }

}
