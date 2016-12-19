import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 18.12.16.
 */
public class CatalogPage {

    WebDriver driver;
    WebDriverWait wait;

    private By categories = By.xpath("//tr[@class='row']//i[@class='fa fa-folder']//following-sibling::a");
    private By products = By.xpath("//tr[@class='row']//a[contains(@href, 'doc=edit_product') and preceding-sibling::img]");
    private String locatorToProductNode = "//tr[@class='row']//a[contains(@href, 'doc=edit_product') and text()='";
    private List<By> productsLocators = new ArrayList<By>();

    CatalogPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void openCategory() {
        List<WebElement> categoriesList = driver.findElements(categories);
        if(!categoriesList.isEmpty()) {
            for (WebElement category : categoriesList) {
                category.click();
            }
        }
    }

    private List<By> getProductList() {
        List<WebElement> productsElements = driver.findElements(products);
        for (WebElement product : productsElements) {
            productsLocators.add(getProductLocator(locatorToProductNode, product.getAttribute("innerText")));
        }
        return productsLocators;
    }

    public void checkEachProductPage() {
        openCategory();
        List<By> products = getProductList();
        for(By product : products) {
            init(product).click();
            ProductPage productPage = new ProductPage(driver, wait);
            Logger.log(driver.manage().logs().get("browser"));
            productPage.returnToProductList();
        }
    }

    private By getProductLocator(String locatorToProductNode, String productName) {
        return By.xpath(locatorToProductNode + productName + "']");
    }

    private WebElement init(By locator) {
        return driver.findElement(locator);
    }
}
