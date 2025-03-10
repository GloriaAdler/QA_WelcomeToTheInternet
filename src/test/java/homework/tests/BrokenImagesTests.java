package homework.tests;

import homework.core.TestBase;
import homework.pages.BrokenImagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class BrokenImagesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/broken_images");
    }

    @Test
    public void brokenImagesPositiveTest(){
        new BrokenImagesPage(app.driver,app.wait)
                .checkAllBrokenLinksImages();
    }
}
