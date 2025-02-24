package Test;

import org.slf4j.helpers.Util;
import org.testng.Assert;
import com.practice.pages.Authentification;
import com.practice.pages.CreateAccount;
import com.practice.pages.HomePage;
import com.practice.pages.PersonalInformationPage;
import com.practice.pages.UserAccount;
import base.BasicTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utile.DateGenerator;

public class TestSignUp extends BasicTest {
    HomePage home = new HomePage(driver);
    static CreateAccount createPage;
    static Authentification auth = new Authentification(driver);
    static PersonalInformationPage personalPage;
    static UserAccount userPage;
    private String newMail;

    @Given("La page accueil est visible")
    public void La_page_accueil_est_visible() {

        boolean visibleL = home.homePageVisible().isDisplayed();
        Assert.assertTrue(visibleL, "verifer la Home Page ");
    }

    @When("je clic sur le bouton SignIn")
    public void je_clic_sur_le_bouton_SignIn() {
        createPage = home.clickSignUp();
    }

    @And("La page createAccount est visible")
    public void La_page_createAccount_est_visible() {

        boolean visibleT = auth.authentificationTitleVisible().isDisplayed();
        Assert.assertTrue(visibleT, "verifier la Authentification Page");
    }

    @When("Taper une adresse email valide {string}")
    public void Taper_une_adresse_email_valide(String s) {
        newMail = s + DateGenerator.generateDateHeure() + "@gmail.com";
        createPage.setEmail(newMail);
    }

    @And("Je clic sur le bouton Create Account")
    public void Je_clic_sur_le_bouton_Create_Account() {
        personalPage = createPage.clickCreateAccount();
    }

    @And("Verifiez que la page Personal information est visible")
    public void Verifiez_que_la_page_Create_Account_est_visible() {

        boolean visibleTi = personalPage.personalTitleVisible().isDisplayed();
        Assert.assertTrue(visibleTi, "verifier la Page Personal");
    }

    @When("Je remplis le formulaire  {string} {string} {string}")
    public void Je_remplis_le_formulaire(String s, String s2, String s4) {
        personalPage.setFirstName(s);
        personalPage.setLastName(s2);
        personalPage.setEmail(newMail);
        personalPage.setPassword(s4);

    }

    @And("Je clic sur le bouton Register")
    public void Je_clic_sur_le_bouton_Register() {
        userPage = personalPage.clickRegisterButton();
    }

    @And("Verifier que le message {string} est visible")
    public void Verifiez_que_le_message_est_visible(String s) {
        String msg = userPage.getSuccessMsgCreateAccount();
        Assert.assertEquals(msg, "Your account has been created.");

    }

}
