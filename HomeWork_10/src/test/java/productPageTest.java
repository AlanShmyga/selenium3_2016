import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by alan on 06.12.16.
 */
public class productPageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private By product = By.xpath(".//li[contains(@class, 'product')]");
    private By productNameLocator = By.className("name");
    private By productRegularPriceLocator = By.className("regular-price");
    private By productCampaignPriceLocator = By.className("campaign-price");

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testProductPage() {
        driver.get("http://localhost/litecart/en/");
        HomePage homePage = new HomePage(driver);
        WebElement desiredProduct = homePage.getBoxCampaigns().findElements(product).get(0);
        String productName = desiredProduct.findElement(productNameLocator).getText().trim();
        String regularPrice = desiredProduct.findElement(productRegularPriceLocator).getText().trim();
        String campaignPrice = desiredProduct.findElement(productCampaignPriceLocator).getText().trim();
        desiredProduct.click();
        ProductPage productPage = new ProductPage(driver);

        assertEquals(productName, productPage.getProductName());
        assertEquals(regularPrice, productPage.getProductRegularPrice());
        assertEquals(campaignPrice, productPage.getProductCampaignPrice());
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}