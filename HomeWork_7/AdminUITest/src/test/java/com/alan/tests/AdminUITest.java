package com.alan.tests;

import com.alan.pages.LoginPage;
import com.alan.pages.SideBarPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alan on 23.11.16.
 */
public class AdminUITest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String userName = "admin";
    private String userPassword = "admin";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
    }

    @Test
    public void testAdminPages() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginAs(userName, userPassword);

        SideBarPage sideBarPage = new SideBarPage(driver, wait);
        sideBarPage.clickOnEachAppMenuItem();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
