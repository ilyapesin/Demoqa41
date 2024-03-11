package pages;

import org.openqa.selenium.By;

public class ElementPage extends BasePage{
    By btnOpenTextBox = By.id("item-0");
    public void openTextBoxPage() {

        clickBase(btnOpenTextBox);
    }
}
