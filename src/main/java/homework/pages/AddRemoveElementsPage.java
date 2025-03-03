package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//button[text()='Add Element']")
    WebElement addButton;

    @FindBy(css = "#elements button")
    List<WebElement> deleteButtons;

    public AddRemoveElementsPage addElement() {
        addButton.click();
        return this;
    }

    public AddRemoveElementsPage deleteElement() {
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
        return this;
    }
}
