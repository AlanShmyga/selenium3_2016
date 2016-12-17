import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 17.12.16.
 */
public class CountriesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By addNewCountryButton = By.xpath("//a[@class='button' and contains(@href, 'edit_country')]");

    public CountriesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public AddNewCountryPage addNewCountry() {
        initialize(addNewCountryButton).click();
        return new AddNewCountryPage(driver, wait);
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
