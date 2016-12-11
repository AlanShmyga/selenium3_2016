import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by alan on 11.12.16.
 */
public class CreateAccountPage extends AbstractPage {

    private WebDriver driver;
    private By firstNameInputLocator = By.name("firstname");
    private By lastNameInputLocator = By.name("lastname");
    private By address1InputLocator = By.name("address1");
    private By postCodeInputLocator = By.name("postcode");
    private By cityInputLocator = By.name("city");
    private By countryInputLocator = By.xpath("//span[contains(@id, 'country_code')]");
    private By emailInputLocator = By.name("email");
    private By phoneInputLocator = By.name("phone");
    private By desiredPasswordInputLocator = By.name("password");
    private By confirmPasswordInputLocator = By.name("confirmed_password");
    private By submitButton = By.xpath("//button[@type='submit']");
    private String desiredCountry = "United States";

    CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAccount(String firstName, String lastName,
                                 String address1, String postCode,
                                 String city, String country,
                                 String email, String phone,
                                 String password) {
        driver.findElement(firstNameInputLocator).sendKeys(firstName);
        driver.findElement(lastNameInputLocator).sendKeys(lastName);
        driver.findElement(address1InputLocator).sendKeys(address1);
        driver.findElement(postCodeInputLocator).sendKeys(postCode);
        driver.findElement(cityInputLocator).sendKeys(city);
        setSearchableComboBoxFieldValue(driver, driver.findElement(countryInputLocator), desiredCountry);
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(phoneInputLocator).sendKeys(phone);
        driver.findElement(desiredPasswordInputLocator).sendKeys(password);
        driver.findElement(confirmPasswordInputLocator).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
