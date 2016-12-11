import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by alan on 11.12.16.
 */
public class AbstractPage {
    WebDriver driver;
    protected By searchBox = By.xpath("//span[contains(@class, 'search--dropdown')]");

    public AbstractPage setSearchableComboBoxFieldValue(WebDriver driver, WebElement ComboBoxElement, String searchValue) {
        this.driver = driver;
        ComboBoxElement.click();
        WebElement dropDownValue = driver.findElement(By.xpath("//li[contains(@id, 'country_code') and text()='" + searchValue + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownValue).click().perform();
        return this;
    }
}
