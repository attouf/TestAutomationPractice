package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By signIn = By.xpath("//div[@class='header_user_info']//a");
    private By logo= By.cssSelector("div img.logo.img-responsive");
    
        


    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public WebElement homePageVisible (){
        return driver.findElement(logo);
    }



    public Authentification clickSignIn(){
        driver.findElement(signIn).click();
        return new Authentification(driver);
    }
    public CreateAccount clickSignUp(){
        driver.findElement(signIn).click();
        return new CreateAccount(driver);
    }

}
