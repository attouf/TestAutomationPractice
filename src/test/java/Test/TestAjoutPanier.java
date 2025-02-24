package Test;

import org.testng.Assert;

import com.practice.pages.InformationProduitPage;
import com.practice.pages.ProduitPage;
import com.practice.pages.RecherchreProduit;

import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestAjoutPanier extends BasicTest {

    TestSignUp testSignUp = new TestSignUp();
    TestRechercheProd testRechrche = new TestRechercheProd();
    ProduitPage produitPage = new ProduitPage(driver);
    RecherchreProduit rechercheProduit = new RecherchreProduit(driver);
    InformationProduitPage prodInfoPage;
    boolean etat;
    boolean dispo;

    @Given("la page accueil est visible4")
    public void la_page_accueil_est_visible() {
        testSignUp.La_page_accueil_est_visible();
    }

    @When("je tape le nom de produit  {string} dans la barre de recherche")
    public void je_tape_le_nom_de_produit_dans_la_barre_de_recherche(String s) {
        testRechrche.je_tape_le_nom_de_produit_dans_la_barre_de_recherche(s);
    }

    @When("Je clic sur le bouton de recherche1")
    public void Je_clic_sur_le_bouton_de_recherche() {
        testRechrche.Je_clic_sur_le_bouton_de_recherche();
    }

    @When("Verifier que tous les produits relatifs à la recherche sont visibles2 {string}")
    public void Verifier_que_tous_les_produits_relatifs_la_recherche_sont_visibles(String s) {

        testRechrche.Verifiez_que_tous_les_produits_relatifs_la_recherche_sont_visibles(s);
    }

    @When("je survole le premier produit verifier letat du bouton Add To Cart est Enabled or Disabled")
    public void je_survole_le_premier_produit_et_je_verifie_etat() {
        etat = produitPage.survolerLeProduit();

    }

    @When("Si le bouton Add et Enabled je clic dessus")
    public void Si_le_bouton_Add_et_Enabled_je_clic_dessus() {

        if (etat==false) {//etat = false si le bouton est enabled
            produitPage.clickAddButton();
        }
    }

    @When("Sinon je verifie si le produit existe avec autre couleur")
    public void Sinon_je_verifie_si_le_produit_existe_avec_autre_couleur() {
        if (etat){
           
            String msg = produitPage.produitDisponibleAutreCouleur().getText();
            System.out.println(msg);
            if ("Product available with different options".equals(msg)){
                dispo= true;
                System.out.println("dispo");
            }
            else{
                dispo = false;
            }
    
    
    }
    }

    @When("Je clic sur le bouton More")
    public void Je_clic_sur_le_bouton_More() {
        if (dispo) {
            System.out.println("dispo atef");
            prodInfoPage=produitPage.clickMoreButton();
        }
    }

    @When("je change la couleur du produit dispo en stock")
    public void je_change_la_couleur_du_produit() {
        prodInfoPage.selectionnerColor();
    }
  

    @When("je clic sur le bouton Add to cart")
    public void je_clic_sur_le_bouton_Add_to_cart() {
        prodInfoPage.clickSubmitButton();
    }

    @Then("Verifier que le message {string}est visible1")
    public void Verifier_que_le_message(String s) {
        String msg = prodInfoPage.successMsgVisible();
        Assert.assertEquals(msg,s);
        }

    

    @Then("je clic sur le bouton continue shopping")
    public void je_clic_sur_le_bouton_continue_shopping() {
       prodInfoPage.clickContinueButton();
    }

    @Then("verifier que le quantite du panier est égale à {string}")
    public void verifier_que_le_quantite_du_panier_est_gale(String s) {
        String qte =prodInfoPage.quantitePanier();
        Assert.assertEquals(qte,s);
    }

}
