package tests;

import config.ConfigManager;
import dto.TextBoxUserInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ScreenShotManager;

public class TextBoxTests extends BaseTest{
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        ConfigManager.navigateToMainPage();
        mainPage.openElementsPage();
        elementPage.openTextBoxPage();
    }
    @Test
    public void textBoxPageOpened() throws InterruptedException{
        Assert.assertTrue(textBoxPage.validateUrlTexBoxCorrectly());
        ScreenShotManager.takeScreenshot("screenShot");
    }

    @Test(description = "test with filling all fields in the form and validate the common result")
    public void testForm() {
        TextBoxUserInfo textBoxUserInfo = new TextBoxUserInfo()
                .withName("John")
                .withEmail("john@mail.com")
                .withCurrentAddress("first street")
                .withPermanentAddress("second street");
        textBoxPage.fillForm(textBoxUserInfo);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Assert.assertTrue(textBoxPage.validateUserInfoDisplaysCorrect(textBoxUserInfo));
    }

}
