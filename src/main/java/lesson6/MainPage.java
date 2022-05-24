package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://loverepublic.ru/");
    }

    @FindBy(css = "li:nth-child(3) > .with-submenu > span")
    private WebElement menu;

    @Override
    protected void waitUntilLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
    }

    public NavigationMenu clickMenu() {
        menu.click();
        return new NavigationMenu(driver);
    }

}
