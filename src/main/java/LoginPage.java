import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailLocator = By.xpath("//input[@id='LoginEmail']");
    private By passwordLocator = By.id("Password");
    private By logInButtonLocator = By.id("loginLink");

    public void logIn(String email, String password) {

        type(emailLocator,email);
        type(passwordLocator,password);
        click(logInButtonLocator);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

}
