package com.alan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 23.11.16.
 */
public class SideBarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By logoutButton = By.xpath("//a[@title='Logout']");
    private By menuItemId = By.xpath("//*[@id='app-']//span[@class='name']");
    private By childNodeItemId = By.xpath("//*[@id='app-']//li//span[@class='name']");
    private String menuItemIdLocatorTemplate = "//*[@id='app-']//span[@class='name' and text()='";
    private List<String> childMenuNodes;
    private List<String> menuNodes = new ArrayList<String>();

    public SideBarPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        getMenuNodesNames();
    }

    public void clickOnEachAppMenuItem() {
        for (String elementName : menuNodes) {
            initialize(makeMenuItemLocator(elementName)).click();
            childMenuNodes = new ArrayList<String>();
            getMenuChildNodesNames();
            if (!childMenuNodes.isEmpty()) {
                clickOnEachChildMenuItem();
            } else {
                wait.until(ExpectedConditions.titleIs(getExpectedTitle(elementName)));
            }
        }
    }

    public void clickOnEachChildMenuItem() {
        for (String childElementName : childMenuNodes) {
            initialize(makeMenuItemLocator(childElementName)).click();
            if (childElementName.equalsIgnoreCase("Scan Files")) {
                wait.until(ExpectedConditions.titleIs(getExpectedTitle("Scan Files For Translations")));
            }
            else if (childMenuNodes.contains("Background Jobs")) {
                wait.until(ExpectedConditions.titleContains("My Store"));
            }
            else if (childMenuNodes.contains("Store Info")){
                wait.until(ExpectedConditions.titleIs(getExpectedTitle("Settings")));
            }
            else {
                wait.until(ExpectedConditions.titleIs(getExpectedTitle(childElementName)));
            }
        }
    }

    private void getMenuNodesNames() {
        List<WebElement> nodes = driver.findElements(menuItemId);
        for(WebElement element : nodes) {
            menuNodes.add(element.getText().trim());
        }
    }

    private void getMenuChildNodesNames() {
        List<WebElement> subNodes = driver.findElements(childNodeItemId);
        for(WebElement element : subNodes) {
            childMenuNodes.add(element.getText().trim());
        }
    }

    private String getExpectedTitle(String name) {
        return name + " | My Store";
    }

    private By makeMenuItemLocator(String elementName) {
        return By.xpath(menuItemIdLocatorTemplate + elementName + "']");
    }

    private WebElement initialize(By locator) {
        return driver.findElement(locator);
    }
}
