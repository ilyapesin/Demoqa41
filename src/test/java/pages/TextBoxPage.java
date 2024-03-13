package pages;

import dto.TextBoxUserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage extends BasePage{
    By inputUserName=(By.xpath("//input[@id='userName']"));
    By inputUserEmail=(By.xpath("//input[@id='userEmail']"));
    By placeHolderAddress=(By.xpath("//textarea[@id='currentAddress']"));
    By placeHolderPermanentAddress=(By.xpath("//textarea[@id='permanentAddress']"));
    By btnSubmit=(By.xpath("//button[@id='submit']"));

    By resultsTextBox = By.xpath("//div[@id='output']//p");

    public boolean validateUrlTexBoxCorrectly() {
        String url = "https://demoqa.com/text-box";
        String currentUrl=getCurrentUrlBase();
        return isTextEqualBy2Strings(currentUrl, url);
    }
    public void fillForm(TextBoxUserInfo textBoxUserInfo) {
        sendTextBase(inputUserName, textBoxUserInfo.getName());
        sendTextBase(inputUserEmail, textBoxUserInfo.getEmail());
        sendTextBase(placeHolderAddress, textBoxUserInfo.getCurrentAddress());
        sendTextBase(placeHolderPermanentAddress, textBoxUserInfo.getPermanentAddress());
        clickBase(btnSubmit);
    }
    public boolean validateUserInfoDisplaysCorrect(TextBoxUserInfo textBoxUserInfo) {
        List<WebElement> elements = findElementsBase(resultsTextBox);
        String result = "";
        for(WebElement e: elements) {
            result +=getTextBaseByElement(e);
        }
        System.out.println(result);
        if(result.contains(textBoxUserInfo.getName())
                && result.contains(textBoxUserInfo.getEmail())
                && result.contains(textBoxUserInfo.getCurrentAddress())
                && result.contains(textBoxUserInfo.getPermanentAddress())) {
            return true;
        } else {
            return false;
        }
    }

}
