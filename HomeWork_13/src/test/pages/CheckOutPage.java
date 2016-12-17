import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by alan on 15.12.16.
 */
public class CheckOutPage {

    WebDriver driver;
    WebDriverWait wait;
    private By itemsOnCartLocator = By.xpath("//ul[@class='shortcuts']/li[@class='shortcut']");
    List<WebElement> itemsOnCart;
    private By removeFromCartButton = By.name("remove_cart_item");
    private By backToStoreLink = By.xpath("//div[@id='content']//a[contains(text(), 'Back')]");

    CheckOutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void deleteAllItemsOnCart() {
        initItemsOnCart();
        for(int i = 0; i < itemsOnCart.size(); i++) {
            deleteItemOnCart();
        }
        driver.findElement(backToStoreLink).click();
    }

    private void initItemsOnCart() {
        itemsOnCart = driver.findElements(itemsOnCartLocator);
    }
    private void deleteItemOnCart() {
        WebElement removeButton = driver.findElement(removeFromCartButton);
        removeButton.click();
        wait.until(ExpectedConditions.stalenessOf(removeButton));
    }
}
