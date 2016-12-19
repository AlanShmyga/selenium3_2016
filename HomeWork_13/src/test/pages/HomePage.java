import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private By cartItemsCount = By.xpath("//div[@id='cart']/a[@class='content']/span[@class='quantity']");
    private By cartCheckOutLink = By.xpath("//div[@id='cart']/a[@class='link']");
    private By popularProductBox = By.xpath("//div[@id='box-most-popular']//li");

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

    public HomePage logout() {
        driver.findElement(logoutButton).click();
        return new HomePage(driver, wait);
    }

    public ProductPage openProductPage(int itemIndex) {
        driver.findElements(popularProductBox).get(itemIndex).click();
        return new ProductPage(driver, wait);
    }

    public Integer getItemsOnCartNumber() {
        return Integer.parseInt(driver.findElement(cartItemsCount).getText());
    }

    public void waitUntilItemsOnCardWillBe(int expectedNumOfItemsOnCard) {
        wait.until(ExpectedConditions.attributeToBe(cartItemsCount, "innerText", String.valueOf(expectedNumOfItemsOnCard)));
    }

    public CheckOutPage goToCheckOutPage() {
        driver.findElement(cartCheckOutLink).click();
        return new CheckOutPage(driver, wait);
    }

    public void addProductsToCart(HomePage homePage) {
        ProductPage product;
        int expectedNumOfProductOnCart = 1;
        int desiredNumberOfProductsOnCart = 3;
        for(;expectedNumOfProductOnCart <= desiredNumberOfProductsOnCart; expectedNumOfProductOnCart++) {
            product = homePage.openProductPage(expectedNumOfProductOnCart);
            product.addToCard();
            homePage.waitUntilItemsOnCardWillBe(expectedNumOfProductOnCart);
            product.goToHome();
        }
    }
}
