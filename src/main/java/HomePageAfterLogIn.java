import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageAfterLogIn extends BasePage {

    public HomePageAfterLogIn() {
    }

    public HomePageAfterLogIn(WebDriver driver) {
        super(driver);
    }

    public By myAccountButton = By.className("header-icon-label");
    private By searchBoxLocator = By.id("search");
    WebElement searchBox = driver.findElement(searchBoxLocator);

    public void searchAProduct(String product) throws InterruptedException {

        Thread.sleep(5000);
        type(searchBoxLocator, product);
        searchBox.sendKeys(Keys.ENTER);


    }


}
