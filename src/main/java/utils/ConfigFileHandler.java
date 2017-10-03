package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileHandler {
    private static Properties prop;
    private static ConfigFileHandler instance;

    private ConfigFileHandler(){
        prop = new Properties();
        loadConfigFile();
    }

    public static ConfigFileHandler getInstance(){
        if(instance!=null)
            return instance;
        else
            return instance = new ConfigFileHandler();
    }

    private void loadConfigFile(){
        try(InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getChromeDriverPath(){
        return prop.getProperty("chrome_drover_exe");
    }

    public String getWebDriverURL(){
        return prop.getProperty("web_driver_url");
    }

    public String getGmailURL(){
        return prop.getProperty("gmail_url");
    }


    public String getUserXMLPath() {
        return prop.getProperty("users_xml_path");
    }

    public String getMessageXMLPath() {
        return prop.getProperty("messages_xml_path");
    }

    public int getImplicityWait(){return new Integer(prop.getProperty("implicity_wait"));}

    public String getCSVFilePath(){return prop.getProperty("users_csv");}
}
