package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseView {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        waitUntilLoaded();
    }

    protected abstract void waitUntilLoaded();
}
