package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import tests.BaseTest;

public class SuccessTest extends BaseTest {

    static final String nameCorrect = "tomsmith";
    static final String passwordCorrect = "SuperSecretPassword!";
    private static final String alertSuccess = "You logged into a secure area!";

    @Test
    public void Success() {
        new LoginPage(driver).loginAs(nameCorrect, passwordCorrect);
        new SecureAreaPage(driver).verifyAlert(alertSuccess);
    }
}
