package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class BasketPage extends BaseView {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "make-order")
    private WebElement makeOrderBtn;

    @Override
    protected void waitUntilLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(makeOrderBtn));
    }

    public void checkMakeOrderPossibility() {
        assertTrue(makeOrderBtn.isDisplayed());
        assertTrue(makeOrderBtn.isEnabled());
    }

}
