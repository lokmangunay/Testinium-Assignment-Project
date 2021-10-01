import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseMethods {


        WebDriver driver;
        HomePageBeforeLogIn homePageBeforeLogIn;
        LoginPage loginPage;
        HomePageAfterLogIn homePageAfterLogIn;
        ProductsPage productsPage;
        ProductDetailPage productDetailPage;
        CartPage cartPage;


//    WebDriverWait wait = new WebDriverWait(driver,10,1000);

 //   WebElement findElement(By by){
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }

//    void clickToElement (By by){
//        findElement(by).click();
 //   }

    String getUrl(){
        return driver.getCurrentUrl();
    }

    void goToUrl(String requestedUrl){
        driver.get(requestedUrl);
    }


}
