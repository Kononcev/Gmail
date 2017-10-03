package decorator;

import org.openqa.selenium.WebElement;

public abstract class Element {
    protected WebElement webElement;

    protected Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public boolean isEnabled(){
        return webElement.isEnabled();
    }

    public void clear(){
        webElement.clear();
    }
}
