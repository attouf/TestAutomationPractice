package Test;
import org.testng.Assert;
import com.practice.pages.Authentification;
import com.practice.pages.CreateAccount;
import com.practice.pages.HomePage;
import com.practice.pages.UserAccount;
import base.BasicTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogOut extends BasicTest {
    HomePage home=new HomePage(driver);
    static CreateAccount createPage;
    static Authentification auth;
    static UserAccount userPage;
    TestSignUp testSignUp = new TestSignUp();
    TestLoginSuccess testLoginSuccess = new TestLoginSuccess();

@Given("la page dacceuil est visible1")
public void la_page_d_acceuil_est_visible() {
    testSignUp.La_page_accueil_est_visible();

}

  @When("je clic sur le bouton signIn1")
    public void je_clic_sur_le_bouton_signIn() {
        auth = home.clickSignIn();    }

    @When("je tape un email {string} et un password {string} valides1")
    public void je_tape_un_email_et_un_password_valides(String s, String s2) {
       testLoginSuccess.je_tape_un_email_et_un_password_valides(s,s2) ;
    }

    @When("je clique sur le bouton SignIn1")
    public void je_clique_sur_le_bouton_SignIn() {
         userPage = auth.clickSignButton();  
    
    
    }
    @When("la page UserAccount est visible1")
    public void la_page_UserAccount_est_visible() {
        String message = userPage.getSuccessMsg();
        Assert.assertEquals(message,"Welcome to your account. Here you can manage all of your personal information and orders." );
    }

    @When("je clique sur le bouton SignOut")
    public void je_clique_sur_le_bouton_SignOut() {
        auth=userPage.clickSignOut();
    }

    @Then("verifier la page Authentification est visible")
    public void verifier_la_page_Authentification_est_visible() {
       
        boolean visibleT = auth.authentificationTitleVisible().isDisplayed();
        Assert.assertTrue(visibleT, "verifier la Authentification Page");
    }

    }

