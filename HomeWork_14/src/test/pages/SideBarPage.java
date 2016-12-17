import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by alan on 17.12.16.
 */
public class SideBarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By logoutButton = By.xpath("//a[@title='Logout']");
    private By countriesNode = By.xpath("//li[@id='app-']//span[@class='name' and text()='Countries']");

    public SideBarPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
    }

    public CountriesPage goToCountries(){
        initialize(countriesNode).click();
        return new CountriesPage(driver, wait);
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
