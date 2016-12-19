import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 18.12.16.
 */
public class SideBarPage {

    WebDriver driver;
    WebDriverWait wait;

    private By catalogMenuItem = By.xpath("//li[@id='app-']//span[@class='name' and text()='Catalog']");

    public SideBarPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CatalogPage goToCatalog() {
        initialize(catalogMenuItem).click();
        return new CatalogPage(driver, wait);
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
