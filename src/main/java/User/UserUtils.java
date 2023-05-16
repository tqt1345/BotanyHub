package User;

import com.mycompany.botanyhub.DataHandler;

import java.util.ArrayList;

public class UserUtils {
    public static <T extends User> User getUserWithCredentials(String username, String password, ArrayList<T> users) throws Exception {
        for (T user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("Invalid username or password");
    }

    public static void login (String username, String password) throws Exception {
        User currentUser = getUserWithCredentials(username, password, DataHandler.customers);
        DataHandler.setCurrentUser(currentUser,username);
    }
}
