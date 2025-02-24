package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Authentification {
    private WebDriver driver;
    private By mailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin") ;
    private By authentificationTitle=By.cssSelector("h1.page-heading");

  
    public Authentification (WebDriver driver){
        this.driver = driver;
    }
    public WebElement authentificationTitleVisible (){
        return driver.findElement(authentificationTitle);
    }

    public void setEmail (String email){
        driver.findElement(mailField).sendKeys(email);
    }
    public void setPassWd (String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    public UserAccount clickSignButton (){
        driver.findElement(submitButton).click();
        return new UserAccount(driver);
    } 
    public String getErrorMsg (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']//li"))).getText();
        return errorMsg;


    }




}
