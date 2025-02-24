package com.practice.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProduitPage {
    private WebDriver driver;

    private By searchTitle = By.xpath("//input[@class='search_query form-control ac_input']");
    private By productName = By.xpath("//ul[@class='product_list grid row']//a[@class='product-name']");
    private By productCard = By.xpath(
            "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']");
    private By addButton = By.cssSelector("span.ajax_add_to_cart_button");
    boolean etatButton;
    private By moreButton = By.cssSelector("a.button.lnk_view.btn.btn-default");
    private By produitDispo = By.xpath("//span[@class='available-dif']");;

    public ProduitPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement searchTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle));

    }

    public List<WebElement> getProductsNames1() {
        return driver.findElements(productName);
    }

    public List<String> getProductsNames2() {
        return getProductsNames1().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean survolerLeProduit() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productCard)).perform();
        String classe = driver.findElement(addButton).getAttribute("class");
        etatButton = classe.contains("disabled");
        return etatButton;
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public InformationProduitPage clickMoreButton() {
        driver.findElement(moreButton).click();
        return new InformationProduitPage(driver);

    }

    public WebElement produitDisponibleAutreCouleur (){
        return driver.findElement(produitDispo);

    }

}
