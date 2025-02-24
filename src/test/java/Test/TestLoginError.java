package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pages.Authentification;
import com.practice.pages.HomePage;

import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLoginError extends BasicTest {

HomePage home = new HomePage(driver);
 TestSignUp testSignup= new TestSignUp()  ;
static Authentification auth=new Authentification(driver);

    @Given("la page dacceuil est visible5")
    public void la_page_dacceuil_est_visible() {
        testSignup.La_page_accueil_est_visible();  
      }

    @When("je clic sur le bouton signIn2")
    public void je_clic_sur_le_bouton_signIn() {
       testSignup.je_clic_sur_le_bouton_SignIn();
    
    
    }

    @When("je tape un email invalide {string}")
    public void je_tape_un_email_invalide(String s) {
        auth.setEmail(s); 
       }

    @When("je tape un password {string}")
    public void je_tape_un_password(String s) {
        auth.setPassWd(s);   
     }

    @When("je clique sur le bouton SignIn3")
    public void je_clique_sur_le_bouton_SignIn() {
        auth.clickSignButton();  
      }

    @Then("le message erreur {string} doit etre visible")
    public void le_message_d_erreur_doit_etre_visible(String s) {
       String msg = auth.getErrorMsg();
        Assert.assertEquals(msg, s);
    }

   
}
