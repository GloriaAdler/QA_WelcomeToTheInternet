package homework.tests;

import homework.core.TestBase;
import homework.pages.FloatingMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class FloatingMenuTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/floating_menu");
    }

    @Test
    public void floatingMenuPositiveTest(){
        new FloatingMenuPage(app.driver,app.wait)
                //.scrollToCenterPage()
                .scrollToEndOfPage()
                .verifyFloatingMenuIsPresent()
        ;
    }
}
