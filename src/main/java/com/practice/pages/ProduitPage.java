package com.practice.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProduitPage {
    private WebDriver driver;
    
    private By searchTitle=By.xpath("//input[@class='search_query form-control ac_input']");
    private By  productName= By.xpath("//ul[@class='product_list grid row']//a[@class='product-name']");

    public ProduitPage (WebDriver driver){
        this.driver = driver;

    }
     public WebElement searchTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle));
        
    }
    public List<WebElement> getProductsNames1() {
        return driver.findElements( productName);
    }


    public List<String> getProductsNames2() {
        return getProductsNames1().stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
