package com.example.checkinsai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void setup() {
        String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
    }

    @Test
    public void checkWebsiteURL() {
        basePage.goToUrl("https://checkins.eu/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://checkins.eu/");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
