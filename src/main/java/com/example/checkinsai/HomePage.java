package com.example.checkinsai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//button[@class='v-app-bar__nav-icon hidden-md-and-up v-btn v-btn--icon v-btn--round theme--light v-size--default']")
    WebElement menuButton;

    @FindBy(xpath = "//a[@data-test='navbar.logo']")
    WebElement logo;

    @FindBy(xpath = "//a[@data-test='navbar.add_policy']")
    WebElement addPolicyLink;

    @FindBy(xpath = "//a[@data-test='navbar.for_carrier']")
    WebElement forCarrierLink;

    @FindBy(xpath = "//a[@data-test='navbar.benefits']")
    WebElement benefitsLink;

    @FindBy(xpath = "//a[@data-test='navbar.contact']")
    WebElement contactLink;

    @FindBy(xpath = "//div[@class='v-input language__select v-input--hide-details v-input--is-label-active v-input--is-dirty v-input--dense theme--light v-text-field v-text-field--single-line v-text-field--solo v-text-field--solo-flat v-text-field--is-booted v-text-field--enclosed v-select']")
    WebElement languageSelect;

    @FindBy(xpath="//h1[@class='text-h4 text-lg-h3 text-center text-md-left title--main font-weight-black my-10 my-lg-16 align-self-center align-self-md-start text-break secondary--text']")
    private WebElement mainHeader;

    @FindBy(xpath="//span[@data-test='home.search_box.nip']")
    private WebElement nipButton;

    @FindBy(xpath="//span[@data-test='home.search_box.policy_number']")
    private WebElement policyNumberButton;

    @FindBy(xpath="//span[@data-test='home.search_box.registration_number']")
    private WebElement registrationNumberButton;

    @FindBy(xpath="//input[@data-test='home.search_box.input']")
    private WebElement searchBoxInput;

    @FindBy(xpath="//button[@data-test='home.search_box.submit']")
    private WebElement searchBoxSubmitButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextInSearchBox(String text) {
        searchBoxInput.sendKeys(text);
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickAddPolicyLink() {
        addPolicyLink.click();
    }

    public void clickForCarrierLink() {
        forCarrierLink.click();
    }

    public void clickBenefitsLink() {
        benefitsLink.click();
    }

    public void clickContactLink() {
        contactLink.click();
    }

    public void selectLanguage(String language) {
        languageSelect.click();
        WebElement languageOption = driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='" + language + "']"));
        languageOption.click();
    }

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public void clickNipButton() {
        nipButton.click();
    }

    public void clickPolicyNumberButton() {
        policyNumberButton.click();
    }

    public void clickRegistrationNumberButton() {
        registrationNumberButton.click();
    }

    public void submitSearchBox() {
        searchBoxSubmitButton.click();
    }
}
