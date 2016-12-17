import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 17.12.16.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By loginButton = By.name("login");
    private By loginInput = By.name("username");
    private By passwordInput = By.name("password");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
    }

    public SideBarPage loginAs(String username, String password) {
        initialize(loginInput).sendKeys(username);
        initialize(passwordInput).sendKeys(password);
        initialize(loginButton).click();
        wait.until(ExpectedConditions.titleIs("My Store"));
        return new SideBarPage(driver, wait);
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
