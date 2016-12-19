import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by alan on 15.12.16.
 */
public class CartTest {

    WebDriver driver;
    WebDriverWait wait;
    String appLink = "http://localhost/litecart";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void addToCart() {
        driver.get(appLink);
        HomePage homePage = new HomePage(driver, wait);
        homePage.addProductsToCart(homePage);
        homePage.goToCheckOutPage().deleteAllItemsOnCart();
        assertTrue(homePage.getItemsOnCartNumber().equals(0));
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
