package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccount {

    private WebDriver driver;
    private By signOut=By.linkText("Sign out");
    public UserAccount(WebDriver driver) {
        this.driver = driver;

    }

    public String getSuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Attendre jusqu'à 10 secondes
        String msg = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[@class='info-account']")))
                .getText();

        return msg;
    }
    public String getSuccessMsgCreateAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Attendre jusqu'à 10 secondes
        String msg = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-success']")))
                .getText();

        return msg;
    }
    public Authentification clickSignOut(){
        driver.findElement(signOut).click();
        return new Authentification(driver);
    }

}
