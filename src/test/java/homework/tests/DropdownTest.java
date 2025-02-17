package homework.tests;

import homework.core.TestBase;
import homework.pages.DropdownPage;
import homework.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait)
                .goToDropdownPage();
    }

    @Test
    public void testDropdown() {
        new DropdownPage(app.driver, app.wait)
                .printAllOptions(); // Вывести все варианты в консоль
        new DropdownPage(app.driver, app.wait)
                .selectEachOptionAndVerify(); // Выбрать и проверить каждый вариант
        new DropdownPage(app.driver, app.wait)
                .negativeTestInvalidOption(); // Попробовать выбрать несуществующий элемент
    }
}
