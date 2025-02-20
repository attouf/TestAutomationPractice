package Test;

import org.testng.Assert;
import com.practice.pages.NewsLetterPage;

import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utile.DateGenerator;

public class TestNewsLettre  extends BasicTest {
TestSignUp testSignUp = new TestSignUp();

static NewsLetterPage newsLetterPage = new NewsLetterPage(driver);
private String newMail;

@Given("la page dacceuil est visible3")
public void la_page_d_acceuil_est_visible() {
    testSignUp.La_page_accueil_est_visible();

}

  


    @When("le titre NewsLettre doit être visible")
    public void le_titre_NewsLettre_doit_tre_visible() {
        boolean visible = newsLetterPage.newsLetterTitleVisisble().isDisplayed();
        Assert.assertTrue(visible, "verifier la home Page");
    }

   
    @When("je tape un email valide {string}")
    public void je_tape_un_email_valide(String s) {
        newMail = s + DateGenerator.generateDateHeure() + "@gmail.com";
        newsLetterPage.setEmail(newMail);
    }
    
    @When("je clique sur le bouton submit")
    public void je_clique_sur_le_bouton_submit() {
        newsLetterPage.clickSubmitButton();
    }
   
    @Then("le message {string} doit être visible")
    public void le_message_doit_tre_visible(String s) {
        String message = newsLetterPage.getSuccessMsg();
        Assert.assertEquals(message,s );
    }
    }

  
