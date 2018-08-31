package tests;

import infrastructure.Config;
import infrastructure.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.getDriverInstance(Config.isWindows);
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
