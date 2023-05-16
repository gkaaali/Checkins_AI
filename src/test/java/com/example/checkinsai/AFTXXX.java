package com.example.checkinsai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class AFTXXX extends BaseTest {
    private HomePage homePage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        super.setup();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the website
        String url = "https://checkins.eu/";
        driver.get(url);
    }

    @Test
    public void testSearchWithNip() {
        // Click on the nipButton after waiting for it to be visible
        WebElement nipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='home.search_box.nip']")));
        nipButton.click();

        // Generate a random NIP of length 10
        String randomNip = generateRandomNip(10);

        // Enter the generated NIP into the search box
        homePage.enterTextInSearchBox(randomNip);

        // Click the submit button
        homePage.submitSearchBox();

        // Perform assertions or further operations on the search results
        // ...
    }

    @AfterMethod
    public void tearDown() {
        super.teardown();
    }

    private String generateRandomNip(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }
}
