package homework.tests;

import homework.core.TestBase;
import homework.pages.HomePage;
import homework.pages.LoginPage;
import homework.pages.NestedFramesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class IframesTests extends TestBase {

    //HW 23-25, task 1
//    @BeforeMethod
//    public void preCondition() {
//        new HomePage(app.driver, app.wait)
//                .clickOnNestedFramesLink();
//    }

    @Test
    public void iframeTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToFrameAndPrintText();
    }

    //Lesson 25
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/nested_frames");
    }

    @Test
    public void iframePositiveTest() {
        new NestedFramesPage(app.driver, app.wait)
                .getListOfFrames();
    }

    @Test
    public void switchToIframeByIndexPositiveTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToIframeByIndex(1)
                .verifyIframeText("BOTTOM")
        ;
    }

    @Test
    public void switchToIframeByNamePositiveTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToIframeByName("frame-bottom")
                .verifyIframeText("BOTTOM")
        ;
    }

    @Test
    public void switchToLeftIframeByNamePositiveTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToIframeByName("frame-top")
                .switchToIframeByName("frame-left")
                .verifyIframeText("LEFT")
                .stepUp()
                .switchToIframeByName("frame-middle")
                .verifyIframeText("MIDDLE")
                .stepUp()
                .switchToIframeByName("frame-right")
                .verifyIframeText("RIGHT")
                .exitFromAllFrames()
                .switchToIframeByName("frame-bottom")
                .verifyIframeText("BOTTOM")
        ;
    }
}
