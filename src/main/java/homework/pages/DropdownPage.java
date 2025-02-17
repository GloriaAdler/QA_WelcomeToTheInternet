package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "dropdown")
    WebElement dropdownElement;

    public void selectEachOptionAndVerify() {
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        for (WebElement option : options) {
            if (!option.isEnabled()) { // Проверяем, не отключена ли опция
                System.out.println("Пропускаем заблокированный элемент: " + option.getText());
                continue; // Пропускаем этот вариант
            }

            dropdown.selectByVisibleText(option.getText());
            String selectedOption = dropdown.getFirstSelectedOption().getText();
            System.out.println("Выбрано: " + selectedOption);
            assert selectedOption.equals(option.getText()) : "Ошибка! Выбран неправильный элемент.";
        }
    }

    public void printAllOptions() {
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        System.out.println("Все доступные опции:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    public void negativeTestInvalidOption() {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Несуществующий элемент"); // Ошибка
        } catch (Exception e) {
            System.out.println("Ошибка при выборе несуществующего элемента: " + e.getMessage());
        }
    }
}
