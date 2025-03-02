package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage extends BasePage {

    //Homework of lesson 23-25, task 3
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

    // Lesson 25
    //* 🔹 Выбирает элемент по его отображаемому тексту (тому, что видит пользователь).
    //* 🔹 Работает с текстом, который находится между тегами <option>.
    public DropdownPage selectOptionByText(String optionText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
        System.out.println("✅ Выбрана опция по видимому тексту: " + optionText);
        return this;
    }

    //* 🔹 Выбирает элемент по его атрибуту value.
    //* 🔹 Работает с value="", который обычно используется для идентификации значений.
    public DropdownPage selectOptionByValue(String optionValue) {
        Select select = new Select(dropdownElement);
        select.selectByValue(optionValue);
        System.out.println("✅ Выбрана опция по ID: " + optionValue);
        return this;
    }

    //* 🔹 Выбирает элемент по его порядковому номеру в списке.
    //* 🔹 Нумерация начинается с 0.
    public DropdownPage selectOptionByIndex(int index) {
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
        System.out.println("✅ Выбрана опция по индексу: " + index);
        return this;
    }

    public DropdownPage verifySelectedOption(String expectedText) {
        //System.out.println(dropdown.getText());
        Select select = new Select(dropdownElement);
        WebElement selectedOption = select.getFirstSelectedOption();
        //Assert.assertEquals(selectedOption.getText(),expectedText);
        shouldHaveText(selectedOption, expectedText,500);
        System.out.println("✅ Проверена опция: " + selectedOption.getText());
        return this;
    }
}
