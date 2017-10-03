package decorator;

import org.openqa.selenium.WebElement;

public class InputBox extends Element {
    public InputBox(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String input){
        webElement.sendKeys(input);
    }
}
