package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static lesson6.NavigationMenu.Type.DRESS;

public class AddDressToBasketScenarioTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeClass
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        mainPage = new MainPage(driver);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void test() {
        mainPage
                .clickMenu()
                .clickToDress(DRESS)
                .selectProduct(3)
                .selectSize(44)
                .buy()
                .goToBasket()
                .checkMakeOrderPossibility();
    }

}
