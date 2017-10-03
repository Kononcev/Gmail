package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigFileHandler;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        System.setProperty(ConfigFileHandler.getInstance().getWebDriverURL(), ConfigFileHandler.getInstance().getChromeDriverPath());
        webDriverThreadLocal.set(new ChromeDriver());
        webDriverThreadLocal.get().manage().timeouts().implicitlyWait(ConfigFileHandler.getInstance().getImplicityWait(), TimeUnit.SECONDS);

        return webDriverThreadLocal.get();
    }

    public static void dropDriver(){
        try {
            webDriverThreadLocal.get().quit();
        }finally {
            webDriverThreadLocal.remove();
        }
    }

}