package pages;

import decorator.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdriver.WebDriverSingleton;

public class PageObject {
    WebDriver driver;
    public PageObject() {
        this.driver=WebDriverSingleton.getInstance();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void dropDriver(){
        WebDriverSingleton.dropDriver();
    }
}
