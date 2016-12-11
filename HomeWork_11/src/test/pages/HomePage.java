import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 11.12.16.
 */
public class HomePage {

    private By createNewAccountLinkLocator = By.xpath("//a[contains(@href, 'create_account')]");
    private WebDriver driver;
    private WebDriverWait wait;
    private By accountCreatedSuccessfullyLocator = By.xpath("//div[@id='notices']//div[@class='notice success']");
    private By logoutButton = By.xpath("//div[@id='box-account']//a[text()='Logout']");
    private By emailAddressInput = By.xpath("//form[@name='login_form']//input[@name='email']");
    private By passwordInput = By.xpath("//form[@name='login_form']//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit' and @name = 'login']");

    HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CreateAccountPage clickCreateNewAccountLink() {
        driver.findElement(createNewAccountLinkLocator).click();
        return new CreateAccountPage(driver);
    }

    public void waitForAccountCreatedMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(accountCreatedSuccessfullyLocator));
    }

    public HomePage loginAs(String email, String password) {
        driver.findElement(emailAddressInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver, wait);
    }

    public HomePage logout() {
        driver.findElement(logoutButton).click();
        return new HomePage(driver, wait);
    }
}
