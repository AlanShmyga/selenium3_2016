import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by alan on 04.12.16.
 */
public class CountriesPage {

    private WebDriver driver;
    private By tableRowLocator = By.xpath("//form[@name='countries_form']//tbody//tr[@class='row']");
    private By countryCellLocator = By.xpath("//form[@name='countries_form']//tbody//tr[@class='row']/td[5]/a");

    CountriesPage (WebDriver driver) {
        this.driver = driver;
    }
    public void checkCountriesSorting() {
        List<WebElement> countries = driver.findElements(countryCellLocator);
        for(WebElement country : countries) {
            System.out.println(country.getText());
        }
    }
}
