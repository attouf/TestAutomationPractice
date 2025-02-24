package Test;
import org.testng.Assert;
import com.practice.pages.NewsLetterPage;
import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utile.DateGenerator;

public class TestNewsLettreError extends BasicTest {
    TestSignUp testSignUp = new TestSignUp();
    static NewsLetterPage newsLetterPage = new NewsLetterPage(driver);
    private String newMail;



    @Given("la page dacceuil est visible2")
    public void la_page_d_acceuil_est_visible() {
        testSignUp.La_page_accueil_est_visible();

    }

    @When("le titre NewsLettre doit être visible2")
    public void le_titre_NewsLettre_doit_tre_visible() {
        boolean visible = newsLetterPage.newsLetterTitleVisisble().isDisplayed();
        Assert.assertTrue(visible, "verifier la home Page");
    }

    @When("je tape un email valide2 {string}")
    public void je_tape_un_email_valide(String s) {
        newMail = s + DateGenerator.generateDateHeure() + "com";
        newsLetterPage.setEmail(newMail);
    }

    @When("je clique sur le bouton submit2")
    public void je_clique_sur_le_bouton_submit() {
        newsLetterPage.clickSubmitButton();
    }

    @Then("le message {string} doit être visible2")
    public void le_message_doit_tre_visible(String s) {
        String message = newsLetterPage.getErrorMsg();
        Assert.assertEquals(message, s);
    }
}


