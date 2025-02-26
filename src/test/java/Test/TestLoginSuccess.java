package Test;

import java.io.IOException;

import org.testng.Assert;
import com.practice.pages.Authentification;
import com.practice.pages.HomePage;
import com.practice.pages.UserAccount;
import base.BasicTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utile.JsonReader;

public class TestLoginSuccess extends BasicTest {

    static Authentification auth = new Authentification(driver) ;
    static HomePage home = new HomePage(driver);
    static UserAccount userPage;
    
    TestSignUp testSignUp = new TestSignUp();

    @Given("la page dacceuil est visible")
    public void testHomePageVisibility() {

        boolean visibleL = home.homePageVisible().isDisplayed();
        Assert.assertTrue(visibleL, "verifer la Home Page ");
    }

    @When("je clic sur le bouton signIn")
    public void testAuthentificationVisibility() {
        auth = home.clickSignIn();
        boolean visibleT = auth.authentificationTitleVisible().isDisplayed();
        Assert.assertTrue(visibleT, "verifier la Authentification Page");
    }

    @When("je tape un email et un password valides")
    public void je_tape_un_email_et_un_password_valides() throws IOException, org.json.simple.parser.ParseException {

        auth.setEmail(JsonReader.userSignInData("email"));
        auth.setPassWd(JsonReader.userSignInData("password"));
    }

    @When("je clique sur le bouton SignIn")
    public void je_clique_sur_le_bouton_SignIn() {
        userPage = auth.clickSignButton();
    }

    @Then("la page UserAccount est visible")
    public void la_page_UserAccount_est_visible() {
        String message = userPage.getSuccessMsg();
        Assert.assertEquals(message,
                "Welcome to your account. Here you can manage all of your personal information and orders.");

    }

}
