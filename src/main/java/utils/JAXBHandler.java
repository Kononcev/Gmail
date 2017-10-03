package utils;

import model.Message;
import model.User;
import model.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBHandler {
    public static List<User> getListUsersFromXML(String filepath){
        try {
            Users users;
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller um = context.createUnmarshaller();
            users = (Users) um.unmarshal(new File(filepath));
            return users.getUsers();
        } catch (JAXBException e) {
            System.out.println(String.format("problem with xml file %s",filepath));
        }
        return null;
    }

    public static Message getMessageModelFromXML(String filepath){
        try {
            Message message;
            JAXBContext context = JAXBContext.newInstance(Message.class);
            Unmarshaller um = context.createUnmarshaller();
            message = (Message) um.unmarshal(new File(filepath));
            return message;
        } catch (JAXBException e) {
            System.out.println(String.format("problem with xml file %s",filepath));
        }
        return null;
    }
}
