package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void switchToFrameAndPrintText() {
        // Переключаемся в верхний фрейм
        driver.switchTo().frame("frame-top");

        // Переключаемся в левый фрейм и выводим текст
        driver.switchTo().frame("frame-left");
        System.out.println("Left Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame(); // Возвращаемся в frame-top

        // Переключаемся в средний фрейм и выводим текст
        driver.switchTo().frame("frame-middle");
        System.out.println("Middle Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame(); // Возвращаемся в frame-top

        // Переключаемся в правый фрейм и выводим текст
        driver.switchTo().frame("frame-right");
        System.out.println("Right Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent(); // Выходим из всех фреймов

        // Переключаемся в нижний фрейм и выводим текст
        driver.switchTo().frame("frame-bottom");
        System.out.println("Bottom Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent(); // Выходим из фреймов
    }

}
