import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 12.12.16.
 */
public class CatalogPage {

    WebDriver driver;
    WebDriverWait wait;

    private By addNewProductButton = By.xpath("//a[@class='button' and contains(text(), 'Add New Product')]");
    private By productTableRow = By.xpath("//table[@class='dataTable']//tr[@class='row']");

    CatalogPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public AddNewProductPage addNewProduct() {
        driver.findElement(addNewProductButton).click();
        return new AddNewProductPage(driver, wait);
    }

    public boolean isProductPresent(String productName) {
        return driver.findElements(
                By.xpath("//table[@class='dataTable']//tr[@class='row']//a[text()='" + productName + "']")
        ).isEmpty();
    }
}
