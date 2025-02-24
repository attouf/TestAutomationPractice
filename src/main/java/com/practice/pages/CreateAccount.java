package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
    private WebDriver driver;
    private By mailField = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(mailField).sendKeys(email);
    }

    public PersonalInformationPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return new PersonalInformationPage(driver);

    }

    public String getErrorDuplicateMailMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']//ol//li")))
                .getText();
        return errorMsg;

    }

}
