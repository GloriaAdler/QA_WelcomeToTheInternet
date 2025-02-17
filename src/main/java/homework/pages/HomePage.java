package homework.pages;

import homework.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy (xpath = "//a[contains(text(),'Nested Frames')]")
    WebElement nestedFrames;

    public HomePage clickOnNestedFramesLink() {
        click(nestedFrames);
        return this;
    }

    @FindBy (xpath = "//a[contains(text(),'Multiple Windows')]")
    WebElement multipleWindows;

    public MultipleWindowsPage clickOnMultipleWindowsLink() {
        click(multipleWindows);
        return new MultipleWindowsPage(driver, wait);
    }

    @FindBy(xpath = "//a[contains(text(),'Dropdown')]")
    WebElement dropdownLink;

    public DropdownPage goToDropdownPage() {
        click(dropdownLink);
        return new DropdownPage(driver, wait);
    }
}
