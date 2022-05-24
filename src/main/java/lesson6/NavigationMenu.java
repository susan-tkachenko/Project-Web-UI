package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenu extends BaseView {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Платья")
    private WebElement dresses;

    @Override
    protected void waitUntilLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(dresses));
    }

    public DressesPage clickToDress(Type type) {
        dresses.click();
        return new DressesPage(driver);
    }

    public enum Type {

        DRESS("Платья");

        private final String text;

        Type(String text) {
            this.text = text;
        }

    }

}
