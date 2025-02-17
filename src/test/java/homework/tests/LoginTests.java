package homework.tests;

import homework.core.TestBase;
import homework.pages.HomePage;
import homework.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait);
        new LoginPage(app.driver, app.wait);
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .clickOnAuthentication();
        new LoginPage(app.driver, app.wait)
                .enterLoginAndPassword("tomsmith","SuperSecretPassword!")
                .clickOnLoginButton()
        ;
    }

    @Test
    public void loginNegativeTest() {
        new LoginPage(app.driver, app.wait)
                .clickOnAuthentication();
        new LoginPage(app.driver, app.wait)
                .enterLoginAndPassword("userName","Password!")
                .clickOnLoginButton()
        ;
    }
}
