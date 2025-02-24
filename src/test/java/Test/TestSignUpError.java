package Test;

import org.testng.Assert;

import com.practice.pages.Authentification;
import com.practice.pages.CreateAccount;
import com.practice.pages.HomePage;
import com.practice.pages.PersonalInformationPage;
import com.practice.pages.UserAccount;

import base.BasicTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestSignUpError extends BasicTest{

    HomePage home = new HomePage(driver);
    static CreateAccount createPage;
    static Authentification auth = new Authentification(driver);
    static PersonalInformationPage personalPage;
    static UserAccount userPage;


    @Given("La page accueil est visible1")
    public void La_page_accueil_est_visible() {

        boolean visibleL = home.homePageVisible().isDisplayed();
        Assert.assertTrue(visibleL, "verifer la Home Page ");
    }

    @When("je clic sur le bouton SignIn1")
    public void je_clic_sur_le_bouton_SignIn() {
        createPage = home.clickSignUp();
    }

    @And("La page createAccount est visible1")
    public void La_page_createAccount_est_visible() {

        boolean visibleT = auth.authentificationTitleVisible().isDisplayed();
        Assert.assertTrue(visibleT, "verifier la Authentification Page");
    }

    @When("Taper une adresse email existante {string}")
    public void Taper_une_adresse_email_valide(String s) {

        createPage.setEmail(s);
    }

    @And("Je clic sur le bouton Create Account1")
    public void Je_clic_sur_le_bouton_Create_Account() {
        personalPage = createPage.clickCreateAccount();
    }

    @Then("Verifiez que le message {string} est visible")
    public void Verifiez_que_le_message_est_visible(String s) {
        String errmsg=createPage.getErrorDuplicateMailMsg();
        Assert.assertEquals(errmsg,s);
    }

}
