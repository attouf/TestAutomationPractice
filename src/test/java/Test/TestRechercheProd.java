package Test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.practice.pages.HomePage;
import com.practice.pages.ProduitPage;
import com.practice.pages.RecherchreProduit;

import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestRechercheProd extends BasicTest {

    static RecherchreProduit recherheProdPage = new RecherchreProduit(driver);
    static ProduitPage produitPage;
    static TestSignUp signUpPage = new TestSignUp();

    @Given("la page accueil est visible3")
    public void la_page_accueil_est_visible() {
        signUpPage.La_page_accueil_est_visible();

    }

    @When("je tape le nom de produit {string} dans la barre de recherche")
    public void je_tape_le_nom_de_produit_dans_la_barre_de_recherche(String s) {
        recherheProdPage.searchProduct(s);
    }

    @When("Je clic sur le bouton de recherche")
    public void Je_clic_sur_le_bouton_de_recherche() {
        produitPage = recherheProdPage.clickSearchButton();
    }

    @Then("Verifier que tous les produits relatifs à la recherche sont visibles {string}")
    public void Verifiez_que_tous_les_produits_relatifs_la_recherche_sont_visibles(String s) {
       
        List<String> produitsAffiches = produitPage.getProductsNames2();
        for (int i = 0; i < produitsAffiches.size(); i++) {
            Assert.assertTrue(produitsAffiches.get(i).toLowerCase().contains(s.toLowerCase()));
            System.out.println(i + ". " + produitsAffiches.get(i) + " - contain: " + s);
        }

       
        }
    }
