package decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.WebDriverSingleton;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click(){
        new Actions(WebDriverSingleton.getInstance()).clickAndHold(webElement).release().perform();
    }
}
