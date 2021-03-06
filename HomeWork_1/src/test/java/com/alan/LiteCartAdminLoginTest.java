package com.alan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by alan on 19.11.16.
 */
public class LiteCartAdminLoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        DesiredCapabilities capabs = new DesiredCapabilities();
        capabs.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(
                new FirefoxBinary(new File("/Applications/FirefoxESR.app/Contents/MacOS/firefox")),
                new FirefoxProfile(),
                capabs
        );
        System.out.println(((HasCapabilities)driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void loginAsAdminTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement loginButton = driver.findElement(By.name("login"));
        WebElement loginInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        wait.until(ExpectedConditions.visibilityOf(loginButton));

        loginInput.sendKeys("admin");
        passwordInput.sendKeys("admin");
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Logout']")));
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
