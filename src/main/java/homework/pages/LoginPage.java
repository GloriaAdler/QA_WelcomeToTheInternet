package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[contains(text(),'Form Authentication')]")
    WebElement authentication;

    //вход на главную страницу
    public HomePage clickOnAuthentication() {
        click(authentication);
        return new HomePage(driver, wait);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    public LoginPage enterLoginAndPassword(String user, String pw) {
        type(username,user);
        type(password,pw);
        return this;
    }

    @FindBy (xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return this;
    }


}
