package homework.tests;

import homework.core.TestBase;
import homework.pages.ContextMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static homework.pages.HomePage.HOME_PAGE_URL;

public class ContextMenuTests extends TestBase {

    //Lesson 25
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/context_menu");
    }

    @Test
    public void rightClickOnBoxAndAlertPositiveTest(){
        new ContextMenuPage(app.driver,app.wait)
                .rightClickOnBox()
                .verifyAlertText("You selected a context menu")
        ;
    }
}
