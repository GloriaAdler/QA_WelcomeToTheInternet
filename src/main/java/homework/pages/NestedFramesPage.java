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
        //верхний фрейм
        driver.switchTo().frame("frame-top");

        //левый фрейм
        driver.switchTo().frame("frame-left");
        System.out.println("Left Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();

        //средний фрейм
        driver.switchTo().frame("frame-middle");
        System.out.println("Middle Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();

        //правый фрейм
        driver.switchTo().frame("frame-right");
        System.out.println("Right Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();

        //нижний фрейм
        driver.switchTo().frame("frame-bottom");
        System.out.println("Bottom Frame Text: " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
    }

}
