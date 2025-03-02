package homework.tests;

import homework.core.TestBase;
import homework.pages.DragAndDropPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class DragAndDropTests extends TestBase {

    //Lesson26
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/drag_and_drop");
    }

    @Test
    public void dragAndDropPositiveTest(){
        new DragAndDropPage(app.driver, app.wait)
                .actionDragMe()
                .verifyText("a")
        ;
    }

}
