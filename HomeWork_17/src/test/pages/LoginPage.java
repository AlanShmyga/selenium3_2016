import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 18.12.16.
 */
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loginAs(String username, String password) {
        if(!driver.findElements(loginButton).isEmpty()) {
            fillInput(initElement(usernameInput), username);
            fillInput(initElement(passwordInput), password);
            initElement(loginButton).click();
        }
    }

    private void fillInput(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
    }

    private WebElement initElement(By locator) {
        return driver.findElement(locator);
    }
}

