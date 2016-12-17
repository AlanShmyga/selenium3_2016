import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by alan on 17.12.16.
 */
public class NewWindowTest {

    WebDriver driver;
    WebDriverWait wait;
    private String appUrl = "http://localhost/litecart/admin";
    private String username = "admin";
    private String password = "admin";

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testThanPagesAreOpenedInNewWindow() {
        driver.get(appUrl);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage
                .loginAs(username, password)
                .goToCountries()
                .addNewCountry()
                .isExplanationOpenedInNewWindow();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
