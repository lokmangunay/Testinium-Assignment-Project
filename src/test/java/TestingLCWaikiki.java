import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestingLCWaikiki extends TestCases {


    @BeforeAll
    public void initiateTheTest() throws InterruptedException {
        setUp();
    }

    @Test
    public void addToCartTest() throws InterruptedException {

        homePageCheck();
        login();
        loginCheck();
        searchAProduct();
        seeMoreProducts();
        selectARandomProduct();
        addTheSelectedProductToCart();
        increaseNumOfProduct();
        deleteProducts();
        isCartEmpty();
    }

//    @AfterAll
//    public void terminateTheTest() {
//        tearDown();
//    }
}
