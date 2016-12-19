import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by alan on 18.12.16.
 */
public class LogsTest {
    WebDriver driver;
    WebDriverWait wait;
    String appLink = "http://localhost/litecart/admin/";
    String username = "admin";
    String password = "admin";

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkLogs() {
        driver.get(appLink);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginAs(username, password);

        SideBarPage sideBar = new SideBarPage(driver, wait);
        sideBar.goToCatalog().checkEachProductPage();

        List<String> logMessages = Logger.getMessages();
        for(String message : logMessages) {
            assertTrue(!message.contains("SEVERE"));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
