import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by alan on 17.12.16.
 */
public class AddNewCountryPage {

    WebDriver driver;
    WebDriverWait wait;
    private By explanationLink = By.xpath("//i[@class='fa fa-external-link']");

    public AddNewCountryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void isExplanationOpenedInNewWindow() {
        String currentWindowId = driver.getWindowHandle();
        Set<String> openedWindowsIds = driver.getWindowHandles();
        initialize(explanationLink).click();
        String newWindowId = wait.until(anyOtherWindowThan(openedWindowsIds));
        driver.switchTo().window(newWindowId);
        driver.close();
        driver.switchTo().window(currentWindowId);
    }

    private ExpectedCondition<String> anyOtherWindowThan(final Set<String> windowId) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver webDriver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(windowId);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
