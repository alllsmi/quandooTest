package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class DataTablesPage extends BasePage {

    private static final String url = "http://the-internet.herokuapp.com/tables";
    private static final String tableXpath = "//*[@id='table2']";
    private static final String headerPatternXpath = tableXpath + "/thead//span[@class='%s']";
    private static final String valuesPatternXpath = tableXpath + "/tbody//td[@class='%s']";

    public DataTablesPage(WebDriver extDriver) {
        super(extDriver);
        navigate(url);
    }

    public void clickHeader(String header){
        click(By.xpath(String.format(headerPatternXpath, header)));
    }

    public void verifyColumnAlphabeticOrder(String header, boolean alphabeticOrReversed){
        ArrayList<String> columnData = getColumnData(header);
        for (int i = 0; i < columnData.size() - 1; i++){
            if (alphabeticOrReversed){
                Assert.assertTrue(columnData.get(i).compareTo(columnData.get(i + 1)) <= 0);
            }
            else {
                Assert.assertTrue(columnData.get(i).compareTo(columnData.get(i + 1)) >= 0);
            }
        }
    }

    private ArrayList<String> getColumnData(String header){
        return getElementsText(By.xpath(String.format(valuesPatternXpath, header)));
    }
}
