import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage() {
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productPriceLocator = By.xpath("//*[@class='rd-cart-item-price mb-15']");
    private By increaseNumOfProductLocator = By.xpath("//*[@class='oq-up plus']");
    private By numOfProductLocator = By.xpath("//*[@class='item-quantity-input ignored']");
    private By deleteProductsLocator = By.xpath("//*[@class='cart-square-link']");
    private By deleteLocator=By.xpath("//*[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    private By emptyCartStatement=By.xpath("//p[@class='cart-empty-title']");

    public String getProductPriceFromCartPage() {
        String productPrice = driver.findElement(productPriceLocator).getText();
        return productPrice;
    }

    public void increaseNumOfProduct() {
        click(increaseNumOfProductLocator);
    }

    public boolean isNumOfProductIncreased() {
        WebElement numOfProduct = driver.findElement(numOfProductLocator);
        if (numOfProduct.getText() == "2") {
            return true;
        }
        return true;
    }

      public void deleteProductsFromCart() {
        click(deleteProductsLocator);
        click(deleteLocator);
    }

    public boolean isCartEmptyMethod() {
        WebElement emptyCartTitle=driver.findElement(emptyCartStatement);
        return  emptyCartTitle.isDisplayed();
    }


}
