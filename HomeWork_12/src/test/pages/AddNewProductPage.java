import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 12.12.16.
 */
public class AddNewProductPage {

    WebDriver driver;
    WebDriverWait wait;

    private By generalTab = By.xpath("//div[@class='tabs']//a[text()='General']");
    private By informationTab = By.xpath("//div[@class='tabs']//a[text()='Information']");
    private By pricesTab = By.xpath("//div[@class='tabs']//a[text()='Prices']");
    private By saveButton = By.xpath("//button[@type='submit' and @name='save']");
    private By statusEnabled = By.xpath("//label[contains(text(), 'Enabled')]/input[@name='status']");
    private By productNameLocator = By.xpath("//input[contains(@name, 'name')]");
    private By manufacturer = By.name("manufacturer_id");
    private By purchasePrice = By.name("purchase_price");
    private Integer increment = 0;

    AddNewProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public AddNewProductPage goToGeneralTab() {
        driver.findElement(generalTab).click();
        return this;
    }

    public AddNewProductPage goToInformationTab() {
        driver.findElement(informationTab).click();
        return this;
    }

    public AddNewProductPage goToPricesTab() {
        driver.findElement(pricesTab).click();
        return this;
    }

    public void saveProduct() {
        driver.findElement(saveButton).click();
    }

    public AddNewProductPage setStatusEnabled() {
        driver.findElement(statusEnabled).click();
        return this;
    }

    public AddNewProductPage setProductName(String value) {
        WebElement productNameInput = driver.findElement(productNameLocator);
        productNameInput.clear();
        productNameInput.sendKeys(increment(value));
        return this;
    }

    public AddNewProductPage setManufacturer(String value) {
        new Select(driver.findElement(manufacturer)).selectByVisibleText(value);
        return this;
    }

    public AddNewProductPage setPurchasePrice(Double value) {
        WebElement productPrice = driver.findElement(purchasePrice);
        productPrice.clear();
        productPrice.sendKeys(value.toString());
        return this;
    }

    private String increment(String value) {
        increment++;
        return value + increment.toString();
    }
}
