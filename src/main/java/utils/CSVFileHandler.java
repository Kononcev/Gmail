package utils;

import model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {
    public static List<User> readUsers(String path){
        List<User> users=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) { String[] fields = line.split(",");
            String login = fields[0];
            String password = fields[1];
            User user = new User(login,password);
            users.add(user); }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
