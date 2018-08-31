package tests.hovers;

import org.testng.annotations.Test;
import pages.HoversPage;
import tests.BaseTest;

import java.util.ArrayList;

public class UserHoversTest extends BaseTest {

    ArrayList<String> expectedUsers = new ArrayList<String>() {{
        add("user1");
        add("user2");
        add("user3");
    }};

    @Test
    public void userHovers(){
        HoversPage hoversPage = new HoversPage(driver);
        hoversPage.verifyUsersPresented(expectedUsers);
    }
}
