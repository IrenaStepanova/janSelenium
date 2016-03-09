package Maventest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.xml.ws.soap.Addressing;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private FirefoxDriver driver;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("http://allo.ua/");
        driver.findElement(By.id("search")).sendKeys(("uyvgiytfyt"));
        driver.findElementByClassName("button-container").click();
        String actualResult = driver.findElementByClassName("category-title").getText();
        String expectedResult = "Результаты поиска для";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test2() {
        driver.get("http://allo.ua/");
        driver.findElement(By.id("search")).sendKeys(("Проектор Epson EH-TW9200"));
        driver.findElementByClassName("button-container").click();
        String actualResult = driver.findElementByClassName("product-name-container").getText();
        String expectedResult = "Epson" + " " + "EH-TW9200";
        Assert.assertTrue(actualResult.contains(expectedResult));


    }

    @Test
    public void test3() {
        driver.get("http://allo.ua/");
        driver.findElement(By.id("search")).sendKeys(("Проектор Epson EH-TW9200"));
        driver.findElementByClassName("button-container").click();
        driver.findElementByName("buy-button_74389").click();
        String actualResult = driver.findElementByClassName("lb-title").getText();
        String expectedResult = "Товар";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @After
    public void postCondition() {
        driver.close();
    }
}