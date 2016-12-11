import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by alan on 11.12.16.
 */
public class RegistreationTest {

    WebDriver driver;
    WebDriverWait wait;
    String baseLink = "http://localhost/litecart";
    String email = "email" + Util.getRandomNum(10) + "@mail.com";
    String password = "password";

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(baseLink);
        HomePage homePage = new HomePage(driver, wait);
                homePage.clickCreateNewAccountLink()
                .createNewAccount("TestUser" + Util.getRandomNum(10),
                        "LastName",
                        "11 SomeAddress str., apt. 1",
                        "01001", "NewYork", "United States",
                        email, "+105201001001", password);
        homePage.waitForAccountCreatedMessage();
        homePage.logout().loginAs(email, password).logout();

    }

    @After
    public void tearDown() {
        this.driver.quit();
        this.driver = null;
    }
}
