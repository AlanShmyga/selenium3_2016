import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddNewProductTest {

    WebDriver driver;
    WebDriverWait wait;
    private By addNewProductButton = By.xpath("//a[@class='button' and contains(text(), 'Add New Product')]");
    private By loginButton = By.xpath("//button[@type='submit']");
    private String username = "admin";
    private String password = "admin";
    private String productName = "AlanProduct";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void countriesSort() {
        driver.get("http://localhost/litecart/admin");
        if (!driver.findElements(loginButton).isEmpty()) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAs(username, password);
        }

        HomePage homePage = new HomePage(driver, wait);
        homePage
                .goToCatalogPage()
                .addNewProduct()
                .goToGeneralTab()
                .setProductName(productName)
                .setStatusEnabled()
                .goToInformationTab()
                .setManufacturer("ACME Corp.")
                .goToPricesTab()
                .setPurchasePrice(100D)
                .saveProduct();
        assertTrue(new CatalogPage(driver, wait).isProductPresent(productName));
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
