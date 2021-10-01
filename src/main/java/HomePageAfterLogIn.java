import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageAfterLogIn extends BasePage {

    public HomePageAfterLogIn() {
    }

    public HomePageAfterLogIn(WebDriver driver) {
        super(driver);
    }

    public By myAccountButton = By.className("header-icon-label");
    private By searchBoxLocator=By.id("search");
    WebElement searchBox=driver.findElement(searchBoxLocator);

    public void searchAProduct(String product) throws InterruptedException {

        Thread.sleep(5000);
        type(searchBoxLocator,product);
         searchBox.sendKeys(Keys.ENTER);
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }



}
