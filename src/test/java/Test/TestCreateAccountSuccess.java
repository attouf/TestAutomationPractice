/*package Test;

import org.testng.Assert;
import com.practice.pages.CreateAccount;
import com.practice.pages.HomePage;
import com.practice.pages.PersonalInformationPage;
import com.practice.pages.UserAccount;

import base.BasicTest;
import io.cucumber.java.en.Given;


public class TestCreateAccountSuccess extends BasicTest {
    private HomePage home;

     

   

    @Given("la page dacceuil est la visible")
    public void testCreateAccountSuccess() {
        home = new HomePage(driver);
        TestLginSuccess.testHomePageVisibility();
        CreateAccount createPage = home.clickSignUp();
        createPage.setEmail("atef@gmail.com");
        PersonalInformationPage informationPage = createPage.clickCreateAccount();
        informationPage.setFirstName("atef");
        informationPage.setLastName("mohamed");
        informationPage.setEmail("atef@gmail.com");
        informationPage.setPassword("atef1234");
        UserAccount userPage = informationPage.clickRegisterButton();
        String msg = userPage.getSuccessMsgCreateAccount();
        Assert.assertEquals(msg, "Your account has been created.", "Erreur de creation de compte!");

    }

  

}
*/