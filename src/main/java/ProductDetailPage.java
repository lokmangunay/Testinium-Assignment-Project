import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage() {
    }

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.xpath("//a[@id='pd_add_to_cart']");
    private By selectSizeOfProduct = By.xpath("//*[@id=\"option-size\"]/a[1]");
    private By goToCartLocator = By.xpath("//*[contains(text(),'Sepetim')]");
    private List<WebElement> productPriceList = driver.findElements(By.xpath("//*[@class='price']"));

    public void addToCart() {
        click(selectSizeOfProduct);
        click(addToCartButton);
    }

    public String getProductPriceFromProductDetailPage() {
        String productPrice = productPriceList.get(1).getText();
        return productPrice;
    }

    public void goToCart() {
        click(goToCartLocator);
    }
}
