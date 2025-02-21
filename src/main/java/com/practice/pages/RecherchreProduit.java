package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecherchreProduit {
    
private WebDriver driver;
private By nomProduit = By.id("search_query_top");
private By searchButton=By.xpath("//button[@class='btn btn-default button-search']");


public RecherchreProduit (WebDriver driver){
    this.driver = driver;
}



public void searchProduct (String product) {
    driver.findElement(nomProduit).sendKeys(product);


}

public ProduitPage clickSearchButton() {
    driver.findElement(searchButton).click();
    return new ProduitPage(driver);
}







}