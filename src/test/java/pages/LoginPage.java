package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String url = "http://the-internet.herokuapp.com/login";
    private static final String userNameID = "username";
    private static final String passwordID = "password";
    private static final String loginXpath = "//button[@type='submit']";

    public LoginPage(WebDriver extDriver) {
        super(extDriver);
        navigate(url);
    }

    public void loginAs(String name, String password){
        log.info("Logging in as: " + name + " " + password);
        enterText(By.id(userNameID), name);
        enterText(By.id(passwordID), password);
        click(By.xpath(loginXpath));
    }
}
