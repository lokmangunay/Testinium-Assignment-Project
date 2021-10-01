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

    String getUrl(){
        return driver.getCurrentUrl();
    }




}
