package Test;

import org.testng.Assert;

import io.cucumber.java.en.Given;

public class TestNewsLettre {

    @Given("la page dacceuil est visible1")
public void la_page_d_acceuil_est_visible() {
    boolean visible=home.homePageVisible().isDisplayed();
    Assert.assertTrue(visible,"Verifier la homePage");

}

    @Given("la page dacceuil est visible2")
    public void la_page_dacceuil_est_visible() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("je défile la page en bas")
    public void je_d_file_la_page_en_bas() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("je tape un email valide {string}")
    public void je_tape_un_email_valide(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("je clique sur le bouton {string}")
    public void je_clique_sur_le_bouton(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("le message {string} doit être visible")
    public void le_message_doit_tre_visible(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("le titre NewsLettre doit être visible")
    public void le_titre_NewsLettre_doit_tre_visible() {
        // Write code here that turns the phrase above into concrete actions
    }

}
