package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class HoversPage extends BasePage {

    private static final String url = "http://the-internet.herokuapp.com/hovers";
    private static final String userListXpath = "//div[@class='figure']";
    private static final String userPatternXpath = userListXpath + "[%d]";
    private static final String userNamePatternXpath = userPatternXpath + "//h5";

    public HoversPage(WebDriver extDriver) {
        super(extDriver);
        navigate(url);
    }

    public void verifyUsersPresented(ArrayList<String> users) {
        log.info("Verify users count = " + users.size());
        Assert.assertEquals(getElementsCount(By.xpath(userListXpath)), users.size());
        for (int i = 0; i < users.size(); i++){
            log.info("Verify user presented: " + users.get(i));
            Assert.assertEquals(users.get(i), getUserHoverText(i).substring(6));
        }
    }

    private String getUserHoverText(int index){
        hoverOver(By.xpath(String.format(userPatternXpath, index + 1)));
        return getElementText(By.xpath(String.format(userNamePatternXpath, index + 1)));
    }
}