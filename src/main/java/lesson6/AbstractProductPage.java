package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractProductPage<T extends AbstractProductPage<T>> extends BaseView {

    public AbstractProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#add2basket-form-219093-60 .add2basket-submit")
    private WebElement buyBtn;

    @FindBy(id = "dialog-basket-small-link")
    private WebElement moveToBasketBtn;

    public T buy() {
        buyBtn.click();
        return (T) this;
    }

    public BasketPage goToBasket() {
        moveToBasketBtn.click();
        return new BasketPage(driver);
    }

}
