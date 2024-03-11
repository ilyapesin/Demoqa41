package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage{
   By textElements= By.xpath("//h5[text()='Elements']");
    By boxElements = By.xpath("//div[contains(@class, 'avatar')]");
    String element="Elements";
    String boxElementsJS="document.querySelector(\".card-body\").click();";
    public String getTextElements()  {
        return getTextBase(textElements);

    }


    public boolean isTextEqual() {
        return super.isTextEqual(textElements, element);
    }

    public void openElementsPage() throws InterruptedException {
       //clickBase(boxElements);
        jsExecutor(boxElementsJS);
    }
}

