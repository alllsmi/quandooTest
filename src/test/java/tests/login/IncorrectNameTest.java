package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class IncorrectNameTest extends BaseTest {

    private static final String nameIncorrect = "tomsmith123";
    private static final String alertIncorrectName = "Your username is invalid!";

    @Test
    public void incorrectName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(nameIncorrect, SuccessTest.passwordCorrect);
        loginPage.verifyAlert(alertIncorrectName);
    }
}
