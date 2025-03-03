package homework.tests;

import homework.core.TestBase;
import homework.pages.HomePage;
import homework.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class LoginTests extends TestBase {

    //HW 22 task 1
//    @BeforeMethod
//    public void preCondition() {
//        new HomePage(app.driver, app.wait);
//        new LoginPage(app.driver, app.wait);
//    }
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/login");
    }

    @Test
    @Parameters ({"username","password"})
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterLoginAndPassword("tomsmith","SuperSecretPassword!")
                .clickOnLoginButton()
        ;
    }

    @Test
    public void loginNegativeTest() {
        new LoginPage(app.driver, app.wait)
                .enterLoginAndPassword("userName","Password!")
                .clickOnLoginButton()
        ;
    }
}
