import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 15.12.16.
 */
public class ProductPage {

    WebDriverWait wait;
    WebDriver driver;
    private By addToCartButton = By.xpath("//button[@name='add_cart_product']");
    private By homeLink = By.xpath("//a[@href='/litecart/']");

    ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addToCard() {
        driver.findElement(addToCartButton).click();
    }

    public void goToHome() {
        driver.findElement(homeLink).click();
    }
}
