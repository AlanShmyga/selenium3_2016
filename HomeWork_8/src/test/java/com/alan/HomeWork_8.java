package com.alan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by alan on 04.12.16.
 */
public class HomeWork_8 {

        WebDriver driver;
        WebDriverWait wait;

        @Before
        public void setup() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            driver.get("http://localhost/litecart");
        }

        @Test
        public void testStickers() {
            List<WebElement> products = driver.findElements(By.xpath("//ul[@class='listing-wrapper products']/li"));
            for (WebElement product : products) {
                List<WebElement> stickers = product.findElements(By.xpath(".//div[contains(@class, 'sticker')]"));
                assertTrue(stickers.size()==1);
            }
        }

        @After
        public void tearDown() {
            driver.quit();
            driver = null;
        }
}
