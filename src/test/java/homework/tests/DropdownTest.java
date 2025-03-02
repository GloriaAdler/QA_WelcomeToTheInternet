package homework.tests;

import homework.core.TestBase;
import homework.pages.DropdownPage;
import homework.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class DropdownTest extends TestBase {

    //Homework of lesson 23-25, task 3
//    @BeforeMethod
//    public void preCondition() {
//        new HomePage(app.driver, app.wait)
//                .goToDropdownPage();
//    }

    @Test
    public void dropdownTest() {
        new DropdownPage(app.driver, app.wait)
                .printAllOptions(); // Вывести все варианты в консоль
        new DropdownPage(app.driver, app.wait)
                .selectEachOptionAndVerify(); // Выбрать и проверить каждый вариант
        new DropdownPage(app.driver, app.wait)
                .negativeTestInvalidOption(); // Попробовать выбрать несуществующий элемент
    }

    //Lesson 25
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/dropdown");
    }

    @Test
    public void selectDropdownOptionByNamePositiveTest() {
        String option = "Option 1";
        new DropdownPage(app.driver, app.wait)
                .selectOptionByText(option)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByValuePositiveTest() {
        String option = "2";
        new DropdownPage(app.driver, app.wait)
                .selectOptionByValue(option)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByIndexPositiveTest() {
        int index = 1;
        String option = "Option " + index;
        new DropdownPage(app.driver, app.wait)
                .selectOptionByIndex(index)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByIndexDefaultPositiveTest() {
        new DropdownPage(app.driver, app.wait)
                //.selectOptionByIndex(0)
                .verifySelectedOption("Please select an option")
        ;
    }
}
