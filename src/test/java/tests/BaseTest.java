package tests;

import config.ConfigManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

@BeforeSuite
    public void init() throws Exception {
    ConfigManager.setUp("firefox");
}
@AfterSuite
    public void stop() throws Exception {
    ConfigManager.tearDown();
}
}
