import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alan on 06.12.16.
 */
public class ProductPage {

    WebDriver driver;

    private By productName = By.xpath("//h1[@class='title']");
    private By productRegularPrice = By.xpath("//s[@class='regular-price']");
    private By productCampaignPrice = By.xpath("//strong[@class='campaign-price']");

    ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductRegularPrice() {
        return driver.findElement(productRegularPrice).getText();
    }

    public String getProductCampaignPrice() {
        return driver.findElement(productCampaignPrice).getText();
    }
}
