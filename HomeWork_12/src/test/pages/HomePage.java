import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 11.12.16.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By logoutButton = By.xpath("//div[@id='box-account']//a[text()='Logout']");
    private By emailAddressInput = By.xpath("//form[@name='login_form']//input[@name='email']");
    private By passwordInput = By.xpath("//form[@name='login_form']//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit' and @name = 'login']");
    private By catalogMenuItemLocator = By.xpath("//li[@id='app-']/a/span[@class='name' and text()='Catalog']");

    HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public HomePage loginAs(String email, String password) {
        driver.findElement(emailAddressInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver, wait);
    }

    public CatalogPage goToCatalogPage() {
        driver.findElement(catalogMenuItemLocator).click();
        return new CatalogPage(driver, wait);
    }

    public HomePage logout() {
        driver.findElement(logoutButton).click();
        return new HomePage(driver, wait);
    }
}
