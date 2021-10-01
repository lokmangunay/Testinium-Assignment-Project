import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{
    final static Logger logger = Logger.getLogger(ProductsPage.class);


    public ProductsPage() {
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By seeMoreProductLocator= By.xpath("//a[@class='lazy-load-button']");

    public void seeMoreProduct(){
        click(seeMoreProductLocator);
    }

    public List<WebElement> getAll() {
        By productInfoBox = By.xpath("//div[@class='info']");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(productInfoBox));

        return driver.findElements(productInfoBox);
    }

    public void selectRandomProduct() throws InterruptedException {
        Thread.sleep(3000);

        Random rand = new Random();
        int randomProductIndex= rand.nextInt(getAll().size());



       JavascriptExecutor js = (JavascriptExecutor) driver;
         WebElement randomlySelectedProduct = getAll().get(randomProductIndex);

        logger.info("Rastgele seçilen ürün: " + randomlySelectedProduct.getText());
//
    js.executeScript("arguments[0].scrollIntoView(true);", randomlySelectedProduct);

        Thread.sleep(4000);

        randomlySelectedProduct.click();


    }
}
