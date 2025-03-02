package homework.tests;

import homework.core.TestBase;
import homework.pages.HomePage;
import homework.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase {

    //HW 22 task 2
    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait)
                .clickOnMultipleWindowsLink();
    }

    @Test
    public void openMultipleWindowsTest() {
        new MultipleWindowsPage(app.driver, app.wait)
                .openNewTab();
        new MultipleWindowsPage(app.driver, app.wait)
                .switchToNewTabAndVerifyUrl();
        new MultipleWindowsPage(app.driver, app.wait)
                .returnToHomePage();
    }
}
