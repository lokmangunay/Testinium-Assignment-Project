import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCases extends BaseMethods {

    final static Logger logger = Logger.getLogger(TestCases.class);

    public void setUp() throws InterruptedException {
        logger.info("Test başlatıldı.");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        homePageBeforeLogIn = new HomePageBeforeLogIn(driver);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        logger.info("Yönlendirilen sayfa : " + driver.getTitle());
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePageBeforeLogIn.closeCookiesWindow();
    }

    public void homePageCheck() throws InterruptedException {
        String homePageUrl = getUrl();
        String homePageUrlC = "https://www.lcwaikiki.com/tr-TR/TR";
        Assertions.assertEquals(homePageUrlC, homePageUrl, "Anasayfaya giriş yapamadınız.");
        Thread.sleep(2000);
    }

    public void login() {

        homePageBeforeLogIn.click(homePageBeforeLogIn.loginButton);
        loginPage = new LoginPage(driver);
        logger.info("Yönlendirilen sayfa : " + driver.getTitle());
        loginPage.logIn("thisisafakemail@gmail.com", "*********");
        // password is hidden for security reasons. Use your own credentials while running the test.

    }

    public void loginCheck() throws InterruptedException {
        homePageAfterLogIn = new HomePageAfterLogIn(driver);
        Thread.sleep(3000);
        String myAccountText = driver.findElement(homePageAfterLogIn.myAccountButton).getText();
        String loginCheckText = "Hesabım";

        Assertions.assertEquals(loginCheckText, myAccountText, "Hesabınıza giriş yapamadınız!!");

    }

    public void searchAProduct() throws InterruptedException {
        String product = "pantolan";
        homePageAfterLogIn.searchAProduct(product);
        System.out.println();
        logger.info(" '" + product + "' " + " arandı! İlgili ürünler listeleniyor...");
        logger.info("Yönlendirilen sayfa " + driver.getTitle());

    }

    public void seeMoreProducts() throws InterruptedException {
        productsPage = new ProductsPage(driver);

        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,2000)");

        logger.info("Sayfa sonuna scroll edildi");
        Thread.sleep(3000);

        productsPage.seeMoreProduct();
        logger.info("Daha Fazla ürün listeleniyor...");
        Thread.sleep(3000);

    }

    public void selectARandomProduct() throws InterruptedException {

        productsPage.selectRandomProduct();

    }

    public void addTheSelectedProductToCart() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();

        logger.info("Ürün Sepete Eklendi!");

        String productPriceOnProductDetailPage = productDetailPage.getProductPriceFromProductDetailPage();
        String price = productPriceOnProductDetailPage;
        productDetailPage.goToCart();

        cartPage = new CartPage(driver);
        logger.info("Yönlendirilen sayfa " + driver.getTitle());
        String productPriceOnCartPage = cartPage.getProductPriceFromCartPage();

        Assertions.assertEquals(price, productPriceOnCartPage,
                "Seçilen ürün ile sepete eklenen ürünün fiyatı aynı değil!");

    }


    public void increaseNumOfProduct() throws InterruptedException {
        logger.info("Ürün adedi 1 artırılıyor...");
        cartPage.increaseNumOfProduct();
        Thread.sleep(5000);

        Assertions.assertEquals("2", cartPage.numOfProduct.getText(),
                "Ürün sayısı 2 değildir.!");
        Thread.sleep(2000);
    }

    public void deleteProducts() {
        cartPage.deleteProductsFromCart();
        logger.info("Sepet Boşaltılıyor...");
    }

    public void isCartEmpty() {
        Assertions.assertTrue(cartPage.isCartEmptyMethod(),
                "Sepet boş değil!!!");

        logger.info("Sepet Boşaltıldı!");
    }


    public void tearDown() {
        driver.quit();
        logger.info("Test tamamlandı.");
    }


}
