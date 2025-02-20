package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformationPage {

    private WebDriver driver;
    private By informationTitle = By.xpath("//div//h3[@class='page-subheading']");

    private By lastName = By.xpath("//input[@id='customer_lastname']");
    private By mail = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='passwd']");
    private By registerButton = By.xpath("//button[@id='submitAccount']");
    


    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement personalTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(informationTitle));
        
    }
    public void setEmail(String email){
        driver.findElement(mail).clear();
        driver.findElement(mail).sendKeys(email);
    }
    public void setPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void setFirstName(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customer_firstname']"))).sendKeys(name);
    }                                                                                                                               
    public void setLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public UserAccount clickRegisterButton (){
        driver.findElement(registerButton).click();
        return new UserAccount(driver);
    } 

    
}
