package test.data;

import model.User;
import org.testng.annotations.DataProvider;
import utils.CSVFileHandler;
import utils.ConfigFileHandler;
import utils.JAXBHandler;

import java.util.List;

public class DataProviderClass {
    @DataProvider(name = "xmlData",parallel = true)
    public static Object[][] dataProviderMethod1() {
        List<User> users = JAXBHandler.getListUsersFromXML(ConfigFileHandler.getInstance().getUserXMLPath());
        Object[][] objects = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            objects[i][0] = users.get(i).getLogin();
            objects[i][1] = users.get(i).getPassword();
        }
        return objects;
    }

    @DataProvider(name = "csvData",parallel = true)
    public static Object[][] dataProviderMethod2() {
        List<User> users = CSVFileHandler.readUsers(ConfigFileHandler.getInstance().getCSVFilePath());
        Object[][] objects = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            objects[i][0] = users.get(i).getLogin();
            objects[i][1] = users.get(i).getPassword();
        }
        return objects;
    }
}
