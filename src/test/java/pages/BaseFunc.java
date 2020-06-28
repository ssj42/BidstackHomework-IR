package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BaseFunc {
    private final String HOME_PAGE_URL = "k-senukai.lv";
    private WebDriver driver;
    public WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public void openHomePage() {
        goToUrl(HOME_PAGE_URL);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        assertFalse(findElements(locator).isEmpty(), "There is no such element on page");
        wait.until(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void click(By locator) {
        wait.until(visibilityOfElementLocated(locator)).click();
    }


    public void enterText(By locator, String text) {
        WebElement input = findElement(locator);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(text);
    }

    public String randomProductSelect(){
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10 - 1 + 1) + 1);
        return number;
    }

    public void closeBrowser() {
        assertNotNull(driver, "There is no opened browser");
        driver.close();
    }
}
