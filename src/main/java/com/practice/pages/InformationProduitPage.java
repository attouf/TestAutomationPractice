package com.practice.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationProduitPage {
    private WebDriver driver;

    private By colorList = By.xpath("//ul[@id='color_to_pick_list']//li");
    private By inStock = By.cssSelector("span#availability_value");
    private By continueShop = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
    private By productQte = By.xpath("//span[@class='ajax_cart_quantity unvisible']");
    public InformationProduitPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getColorList() {
        return driver.findElements(colorList);
    }

    public void selectionnerColor (){

        
        for (int i = 0; i < getColorList().size(); i++) {
           if (!(getColorList().get(i).getAttribute("class").contains("selected"))){
                getColorList().get(i).click();
                if (driver.findElement(inStock).isDisplayed()){
                    getColorList().get(i).click();
                    break;
                }
            }
        }
    }

    public InformationProduitPage clickSubmitButton(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.exclusive")))
                .click();
      
        return this;
    }        
    public String successMsgVisible(){
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Product successfully added to your shopping cart')]")))
                .getText();
    }
    

    public InformationProduitPage clickContinueButton (){
        driver.findElement(continueShop).click();
        return this ;
    }
    public String quantitePanier (){
        return driver.findElement(productQte).getText();
        
    }




}