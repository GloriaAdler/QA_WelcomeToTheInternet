package homework.tests;

import homework.core.TestBase;
import homework.pages.KeyPressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class KeyPressTests extends TestBase {

    //Lesson26
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/key_presses");
    }

    @Test
    public void keyPressPositiveTest(){
        String letter = "a";
        new KeyPressPage(app.driver,app.wait)
                .pressKey(letter)
                .verifyPressedKey(letter)
        ;
    }
}
