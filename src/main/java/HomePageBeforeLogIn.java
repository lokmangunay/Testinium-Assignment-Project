import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageBeforeLogIn extends BasePage{

    public HomePageBeforeLogIn() {
    }

    public HomePageBeforeLogIn(WebDriver driver) {
        super(driver);
    }

    public By loginButton=By.id("header-user-section");

    private By closeCookiesPopUp=By.xpath("//*[@class='closeBtn']");

    public void closeCookiesWindow(){
        click(closeCookiesPopUp);
    }
}
