import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 18.12.16.
 */
public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    private By cancelButton = By.xpath("//button[@name='cancel']");

    ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void returnToProductList() {
        driver.findElement(cancelButton).click();
    }
}
