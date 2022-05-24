package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DressesPage extends BaseView {

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[contains(@class, 'catalog-section')]/div[contains(@class, 'items clearfix')][1]/div[contains(@class, 'unit-33')][3]/div")
    private List<WebElement> products;

    @Override
    protected void waitUntilLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(products));
    }

    public DressProductPage selectProduct(int number) {
        products.get(number).click();
        return new DressProductPage(driver);
    }

}
