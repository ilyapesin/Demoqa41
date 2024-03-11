package pages;

public class TextBoxPage extends BasePage{
    public boolean validateUrlTexBoxCorrectly() {
        String url = "https://demoqa.com/text-box";
        String currentUrl=getCurrentUrlBase();
        return isTextEqualBy2Strings(currentUrl, url);
    }
}
