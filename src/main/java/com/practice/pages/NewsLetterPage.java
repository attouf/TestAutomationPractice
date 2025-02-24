package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsLetterPage {
    private WebDriver driver;
    private By mailField = By.xpath("//div//input[@id='newsletter-input']");
    private By submitButton = By.xpath("//button[@name='submitNewsletter']");
    private By newsLetterTitle = By.xpath("//h4[contains(text(),'Newsletter')]"); // Vérifie le texte du titre
    private By successMessage = By.xpath("//p[@class='alert alert-success']");
    private By errorMessage = By.xpath("//p[@class='alert alert-danger']");

    public NewsLetterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement newsLetterTitleVisisble() {
        return driver.findElement(newsLetterTitle);
    }

    public void setEmail(String email) {
        driver.findElement(mailField).sendKeys(email);
    }

    public NewsLetterPage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    public String getSuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
    public String getErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}