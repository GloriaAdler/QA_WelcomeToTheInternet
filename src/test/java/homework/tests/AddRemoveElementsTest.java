package homework.tests;

import homework.core.TestBase;
import homework.pages.AddRemoveElementsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class AddRemoveElementsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/add_remove_elements/");
    }

    @Test
    public void addElementsPositiveTest() {
        new AddRemoveElementsPage(app.driver, app.wait)
                .addElement()
                .deleteElement();
    }




}
