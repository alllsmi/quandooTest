package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    Logger log = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    private static final String alertID = "flash";

    public BasePage(WebDriver extDriver){
        this.driver = extDriver;
    }

    protected void navigate(String url){
        log.info("Navigate to " + url + " page");
        driver.get(url);
    }

    protected void click(By by){
        waitForElement(by);
        driver.findElement(by).click();
    }

    protected void enterText(By by, String text){
        waitForElement(by);
        driver.findElement(by).sendKeys(text);
    }

    protected String getElementText(By by){
        waitForElement(by);
        return driver.findElement(by).getText();
    }

    protected ArrayList<String> getElementsText(By by){
        List<WebElement> elements = driver.findElements(by);
        ArrayList<String> texts = new ArrayList<String>();
        for (WebElement e : elements){
            texts.add(e.getText());
        }
        return texts;
    }

    public void verifyAlert(String message){
        log.info("Verify alert presented: " + message);
        String actual = getElementText(By.id(alertID));
        Assert.assertEquals(actual.substring(0, actual.length() - 2), message);
    }

    protected int getElementsCount(By by){
        return driver.findElements(by).size();
    }

    protected void hoverOver(By by){
        new Actions(driver).moveToElement(driver.findElement(by)).perform();
    }

    private void waitForElement(By by){
        new WebDriverWait(driver, 10, 50)
                .until(ExpectedConditions.numberOfElementsToBe(by, 1));
    }
}
