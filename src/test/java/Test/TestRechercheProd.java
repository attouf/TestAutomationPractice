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

public class TestRechercheProd extends BasicTest{
    
    static RecherchreProduit recherheProdPage = new RecherchreProduit(driver);
    static ProduitPage produitPage ;
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
        produitPage= recherheProdPage.clickSearchButton();    }

    @Then("Verifier que tous les produits relatifs à la recherche sont visibles {string}")
    public void Verifiez_que_tous_les_produits_relatifs_la_recherche_sont_visibles(String s){
        List<String> produitsAffiches =produitPage.getProductsNames2();
        for (String produit : produitsAffiches) {
        String produitLowerCase = produit.trim().toLowerCase();
        String produitRechercheLowerCase = s.trim().toLowerCase();

        System.out.println("Produit affiché (en minuscules) : " + produitLowerCase);
        System.out.println("Chaîne de recherche (en minuscules) : " + produitRechercheLowerCase);
        System.out.println("Contient la recherche : " + produitLowerCase.contains(produitRechercheLowerCase));

        // Log des caractères individuels pour vérifier les caractères invisibles
        System.out.println("Caractères du produit affiché : " + Arrays.toString(produitLowerCase.toCharArray()));
        System.out.println("Caractères de la chaîne de recherche : " + Arrays.toString(produitRechercheLowerCase.toCharArray()));

        Assert.assertTrue(produitLowerCase.contains(produitRechercheLowerCase),
                          "Le produit affiché ne correspond pas à la recherche : " + produit);
    }
}

}
