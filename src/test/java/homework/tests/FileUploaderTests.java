package homework.tests;

import homework.core.TestBase;
import homework.pages.FileUploaderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.pages.HomePage.HOME_PAGE_URL;

public class FileUploaderTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/upload");
    }

    @Test
    public void  fileUploaderPositiveTest(){
        new FileUploaderPage(app.driver,app.wait)
                .chooseFileByChooseFileButton("C:\\Users\\Asus\\OneDrive\\Изображения\\unnamed2.png")
                .clickOnUploadButton()
                .verifyFileName("unnamed2.png")
        ;
    }

    @Test
    public void  fileUploaderInBoxOnWindowsPositiveTest(){
        new FileUploaderPage(app.driver,app.wait)
                .chooseFileInBox("\"C:\\Users\\Asus\\OneDrive\\Изображения\\unnamed2.png\"")
                .verifyFileNameInBox("unnamed2.png")
        ;
    }
}
