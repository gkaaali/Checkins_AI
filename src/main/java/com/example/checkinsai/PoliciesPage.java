package com.example.checkinsai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoliciesPage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@class='v-form']//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//div[@class='v-input--selection-controls__input']//input[@type='checkbox']")
    private WebElement consentCheckbox;

    @FindBy(xpath = "//button[@class='v-btn v-btn--has-bg theme--light v-size--default primary align-self-end text-capitalize mt-10 py-5']")
    private WebElement sendPolicyButton;

    @FindBy(xpath = "//p[contains(text(),'W bazie Checkins.eu nie znaleziono polisy spełniającej kryteria.')]")
    private WebElement infoMessage;

    public PoliciesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadPolicyFile(String filePath) {
        fileInput.sendKeys(filePath);
    }

    public void checkConsent() {
        consentCheckbox.click();
    }

    public void clickSendPolicyButton() {
        sendPolicyButton.click();
    }

    public String getInfoMessage() {
        return infoMessage.getText();
    }
}
