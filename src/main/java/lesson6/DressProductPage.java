package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DressProductPage extends AbstractProductPage {

    public DressProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#catalog-element-select-size-219093-60-170 li:nth-child(2) > label")
    private List<WebElement> sizes;

    @Override
    protected void waitUntilLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(sizes));
    }

    public DressProductPage selectSize(int size) {
        String sizeStr = String.valueOf(size);
        sizes.stream()
                .filter(availableSize -> availableSize.getText().equalsIgnoreCase(sizeStr))
                .findAny()
                .orElseThrow()
                .click();

        return this;
    }

}
