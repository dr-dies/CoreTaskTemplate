
package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userServ;

    public UserServiceImpl() {
        userServ = new UserDaoHibernateImpl();
    }
    public void createUsersTable() {
        userServ.createUsersTable();
    }

    public void dropUsersTable() {
        userServ.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userServ.saveUser(new User(name, lastName, age));
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userServ.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userServ.getAllUsers();
    }

    public void cleanUsersTable() {
        userServ.cleanUsersTable();
    }
}