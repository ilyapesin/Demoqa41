package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTests extends BaseTest{

    @Test

    public void test() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(mainPage.isTextEqual());

    }
}
