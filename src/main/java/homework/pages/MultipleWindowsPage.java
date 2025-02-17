package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage {

    public MultipleWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement clickHereLink;

    public void openNewTab() {
        clickHereLink.sendKeys(Keys.CONTROL, Keys.RETURN); // Открываем ссылку в новой вкладке
    }

    public void switchToNewTabAndVerifyUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1)); // Переключаемся на новую вкладку
            System.out.println("Current URL: " + driver.getCurrentUrl());
            assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")
                    : "Ошибка! Мы не попали на нужную страницу.";

            driver.close(); // Закрываем новую вкладку
            driver.switchTo().window(tabs.get(0)); // Возвращаемся на страницу "Multiple Windows"
        } else {
            throw new RuntimeException("Новая вкладка не была открыта!");
        }
    }

    public void returnToHomePage() {
        driver.navigate().to("https://the-internet.herokuapp.com/"); // Возвращаемся на главную страницу
    }

}
