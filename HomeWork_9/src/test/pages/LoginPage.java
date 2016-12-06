import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alan on 04.12.16.
 */
public class LoginPage {

    WebDriver driver;
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String username, String password) {
        fillInput(initElement(usernameInput), username);
        fillInput(initElement(passwordInput), password);
        initElement(loginButton).click();
    }

    private void fillInput(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
    }

    private WebElement initElement(By locator) {
        return driver.findElement(locator);
    }
}
