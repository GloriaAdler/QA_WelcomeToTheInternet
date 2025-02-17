package homework.tests;

import homework.core.TestBase;
import homework.pages.HomePage;
import homework.pages.LoginPage;
import homework.pages.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait)
                .clickOnNestedFramesLink();
    }

    @Test
    public void iframeTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToFrameAndPrintText();
    }
}
