package Test;

import java.io.IOException;

import org.testng.Assert;

import com.practice.pages.HistoriquePage;


import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestHistoriqueCommande extends BasicTest{
    TestLoginSuccess testLoginSuccess = new TestLoginSuccess();
    HistoriquePage HistoriquePage=new HistoriquePage(driver);
   
   
    @Given("la page dacceuil est visible6")
    public void la_page_dacceuil_est_visible6(){
        testLoginSuccess.testHomePageVisibility();
    }
    @When("je clique sur le bouton SignIn6")
    public void je_clique_sur_le_bouton_SignIn() {
        testLoginSuccess.testAuthentificationVisibility();
    }

    @When("je tape un email et un password valides6")
    public void je_tape_un_email_et_un_password_valides ()throws IOException, org.json.simple.parser.ParseException {
        testLoginSuccess.je_tape_un_email_et_un_password_valides(); 
         
      }

    
      @When("je clique sur le bouton submit6")
      public void je_clique_sur_le_bouton_submit() {
        testLoginSuccess.je_clique_sur_le_bouton_SignIn();
      }
    @When("la page UserAccount est visible6")
    public void la_page_UserAccount_est_visible() {
        testLoginSuccess.la_page_UserAccount_est_visible();    }

    @When("je clique sur le bouton historique de historiqueCommande")
    public void je_clique_sur_le_bouton_historique_de_historiqueCommande() {
        HistoriquePage.clickHistoriqueButton();    }

    @When("je vérifie que la référence de commande {string} est visible")
    public void je_v_rifie_que_la_r_f_rence_de_commande_est_visible(String s) {
        HistoriquePage.referenceVisible(s);    }

    @When("je clique sur la référence")
    public void je_clique_sur_la_r_f_rence() {
        HistoriquePage.clickReference();    }

    @Then("le message {string} est visible")
    public void le_message_est_visible(String s) {
        String ref= HistoriquePage.messageVisible();
        Assert.assertEquals(s, ref);
        }

   
}
