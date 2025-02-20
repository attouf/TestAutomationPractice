/*package Test;

import org.testng.annotations.Test;

import com.practice.pages.Authentification;

import base.BasicTest;

public class TestLoginError extends BasicTest {

      
    public void testLoginError() {
        TestLginSuccess.testHomePageVisibility();
        TestLginSuccess.testAuthentificationVisibility();
        testLoginErrorMail();
    }

    public void testLoginErrorMail() {
        Authentification auth = new Authentification(driver);
        auth.setEmail("bekri.ateff@gmail.com");
        auth.setPassWd("omar1234");
        auth.clickSignButton();
        String messsageEr = auth.getErrorMsg();
        System.out.println(messsageEr);
    }
 
}*/
