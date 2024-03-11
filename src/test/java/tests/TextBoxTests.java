package tests;

import config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    }

}
