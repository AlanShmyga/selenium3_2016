import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alan on 06.12.16.
 */
public class HomePage {

    WebDriver driver;

    private By boxCampaigns = By.id("box-campaigns");

    HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBoxCampaigns() {
        return driver.findElement(boxCampaigns);
    }
}
