import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage() {
    }

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.xpath("//a[@id='pd_add_to_cart']");
    private By selectSizeOfProduct= By.xpath("//*[@id=\"option-size\"]/a[1]");
    private By  productPriceLocator =By.xpath("//*[@class='price']");
    private By goToCartLocator=By.xpath("//*[contains(text(),'Sepetim')]");
    public void addToCart(){
        click(selectSizeOfProduct);
        click(addToCartButton);
    }

    public String getProductPriceFromProductDetailPage(){
        String productPrice=driver.findElement(productPriceLocator).getText();
        return productPrice;
    }

    public void goToCart(){
        click(goToCartLocator);
    }
}
