package com.alan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by alan on 15.11.16.
 */
public class MyFirstTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void someTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
        assertTrue(driver.findElement(By.linkText("Что такое Selenium WebDriver? / Хабрахабр")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
