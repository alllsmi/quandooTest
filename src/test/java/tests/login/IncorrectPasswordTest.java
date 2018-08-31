package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class IncorrectPasswordTest extends BaseTest {

    private static final String passwordIncorrect = "NotSuperSecretPassword!";
    private static final String alertIncorrectPassword = "Your password is invalid!";

    @Test
    public void incorrectName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(SuccessTest.nameCorrect, passwordIncorrect);
        loginPage.verifyAlert(alertIncorrectPassword);
    }
}
