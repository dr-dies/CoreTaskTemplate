package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userServiceObj = new UserServiceImpl();
        userServiceObj.createUsersTable();
        userServiceObj.saveUser("Герман", "Севостьянов", (byte) 25);
        userServiceObj.saveUser("Иван", "Капустин", (byte) 29);
        userServiceObj.saveUser("Ментор", "Менторов", (byte) 100);
        userServiceObj.saveUser("Василий", "Пупкин", (byte) 3);
        List<User> userList = userServiceObj.getAllUsers();
        userList.forEach(System.out::println);
        userServiceObj.cleanUsersTable();
        userServiceObj.dropUsersTable();
    }
}
