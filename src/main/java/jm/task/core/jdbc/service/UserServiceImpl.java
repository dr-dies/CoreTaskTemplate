package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl ();
        userServ.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl();
        userServ.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl();
        userServ.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl();
        userServ.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl();
        return userServ.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl userServ = new UserDaoJDBCImpl();
        userServ.cleanUsersTable();
    }
}
