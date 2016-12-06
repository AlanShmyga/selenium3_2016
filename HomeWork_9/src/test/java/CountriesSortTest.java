import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

/**
 * Created by alan on 04.12.16.
 */
public class CountriesSortTest {

    WebDriver driver;
    WebDriverWait wait;
    private By countryCellLocator = By.xpath("//form[@name='countries_form']//tbody//tr[@class='row']/td[5]/a");
    private By loginButton = By.xpath("//button[@type='submit']");
    private String username = "admin";
    private String password = "admin";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void countriesSort() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        if (!driver.findElements(loginButton).isEmpty()) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAs(username, password);
        }

        List<WebElement> countries = driver.findElements(countryCellLocator);
        List<String> countriesNames = new ArrayList<String>();
        List<String> sortedCountriesNames;
        for (WebElement country : countries) {
            countriesNames.add(country.getText());
        }
        sortedCountriesNames = countriesNames;
        sort(sortedCountriesNames);
        assertEquals(countriesNames, sortedCountriesNames);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
