package tests.datatable;

import org.testng.annotations.Test;
import pages.DataTablesPage;
import tests.BaseTest;

public class DataTableSortTest extends BaseTest {

    private static final String header = "last-name";

    @Test
    public void dataTableSort(){
        DataTablesPage dataTablesPage = new DataTablesPage(driver);
        log.info("Verify alphabetic order");
        dataTablesPage.clickHeader(header);
        dataTablesPage.verifyColumnAlphabeticOrder(header, true);
        log.info("Verify reversed alphabetic order");
        dataTablesPage.clickHeader(header);
        dataTablesPage.verifyColumnAlphabeticOrder(header, false);
    }
}
