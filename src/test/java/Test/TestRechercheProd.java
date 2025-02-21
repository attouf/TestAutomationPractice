package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.practice.pages.HomePage;
import com.practice.pages.RecherchreProduit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestRechercheProd {
    static WebDriver driver;
    static RecherchreProduit recherheProdPage = new RecherchreProduit(driver);
    static TestSignUp signUpPage = new TestSignUp();

    @Given("la page accueil est visible3")
    public void la_page_accueil_est_visible() {
        signUpPage.La_page_accueil_est_visible();

    }

    @When("je tape le nom de produit &lt;nomProduit&gt; dans la barre de recherche")
    public void je_tape_le_nom_de_produit_dans_la_barre_de_recherche() {
        recherheProdPage.searchProduct
    }

    @When("Je clic sur le bouton de recherche")
    public void Je_clic_sur_le_bouton_de_recherche() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("Verifiez que tous les produits relatifs à la recherche sont visibles")
    public void Verifiez_que_touss_les_produits_relatifs_la_recherche_sont_visibles() {
        // Write code here that turns the phrase above into concrete actions
    }

}
