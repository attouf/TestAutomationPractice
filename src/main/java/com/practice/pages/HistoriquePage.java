package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoriquePage {
    private WebDriver driver;
    private By historiqueButton = By.xpath("//ul[@class='myaccount-link-list']/li[1]");
    private By referenceCommande=By.xpath("//a[@class='color-myaccount']");
    private By msg=By.xpath("//p[@class='dark']");
    public HistoriquePage(WebDriver driver) {
        this.driver = driver;
    }



public HistoriquePage clickHistoriqueButton(){
    driver.findElement(historiqueButton).click();
    return this;

}

public void referenceVisible(String reference){
    driver.findElement(referenceCommande).sendKeys(reference);
    

}

public void clickReference(){
driver.findElement(referenceCommande).click();
}

public String messageVisible(){

 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated((msg)))
                .getText();
        return errorMsg;


}



}

