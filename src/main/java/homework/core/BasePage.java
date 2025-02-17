package homework.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    //снимок экрана при ошибки (браузер должен закрываться методом)
    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test_screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot saved to: [" + screenshot.getAbsolutePath() + "]");
        return screenshot.getAbsolutePath();
    }

    //метод для проверки текста
    public void shouldHaveText(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
        try {
            boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element,text));
            Assert.assertTrue(isTextPresent,"Expected text: ["+text+"], actual text in element: [" + element.getText() + "] in element: [" + element + "]" );
        } catch (TimeoutException e) {
            throw new AssertionError("Text not found in element: [" + element +"], was text:[" + element.getText()+"]", e);
        }
    }

    //прокрутка вниз
    public void scrollTo(int y){
        js.executeScript("window.scrollBy(0," + y + ")");
    }


}
