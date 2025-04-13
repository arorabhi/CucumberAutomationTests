package org.ecm.utility;

import org.ecm.selectors.LandingPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManagerUtility {
    private static DriverManagerUtility instance;
    private WebDriver driver;

    private DriverManagerUtility() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/selenium/drivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        ConfigUtils.loadProperties();
        driver.get(ConfigUtils.getPropertyByKey("url"));
        // Accept cookies
        driver.findElement(By.id(LandingPageSelectors.NECESSARY_COOKIES)).click();
    }

    public static DriverManagerUtility getInstance() {
        if (instance == null) {
            instance = new DriverManagerUtility();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
