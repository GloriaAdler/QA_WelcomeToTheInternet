package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//HW 23-25, task 1
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


//Lesson 25
    @FindBy(tagName = "frame")
    List<WebElement> iframes;

    public NestedFramesPage getListOfFrames() {
        System.out.println("Number of iFrames on the page are: [" + iframes.size() + "]");

        for(WebElement iframe : iframes){
            String iFrameNAME = iframe.getAttribute("name");
            String iFrameSRC = iframe.getAttribute("src");
            System.out.println("Iframe found NAME: [" + (iFrameNAME != null ? iFrameNAME : "No ID") + "], SRC: [" + (iFrameSRC != null ? iFrameSRC : "No SRC") + "]");
        }
        return this;
    }

    public NestedFramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(xpath = "/html/body")
    WebElement bodyLocator;

    public NestedFramesPage verifyIframeText(String text) {
        shouldHaveText(bodyLocator,text, 3000);
        return this;
    }

    public NestedFramesPage switchToIframeByName(String name) {
        //scrollTo(500);
        driver.switchTo().frame(name);
        return this;
    }

    public NestedFramesPage stepUp() {
        driver.switchTo().parentFrame();//на шаг выше
        return this;
    }

    public NestedFramesPage exitFromAllFrames() {//возврат в корневую часть сайта
        driver.switchTo().defaultContent();
        return this;
    }
}
