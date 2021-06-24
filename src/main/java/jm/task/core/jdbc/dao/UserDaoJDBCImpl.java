package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection newCon = Util.connect();
        try {
            PreparedStatement statement = newCon.prepareStatement("CREATE TABLE user (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40), " +
                    "lastName VARCHAR (40), age INT)");
            statement.execute();
            newCon.commit();
        } catch (SQLException e) {
            Util.rollback();
        }

        Util.connect();
    }

    public void dropUsersTable() {
        Connection newCon = Util.connect();
        try {
            PreparedStatement statement = newCon.prepareStatement("DROP TABLE user");
            statement.execute();
            newCon.commit();
        } catch (SQLException e) {
            Util.rollback();
        }
        Util.close();
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection newCon = Util.connect();
        PreparedStatement statement = null;
        try {
            statement = newCon.prepareStatement("INSERT user(name, lastName, age) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);

            statement.executeUpdate();
            newCon.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Util.close();
    }

    public void removeUserById(long id) {
        Connection newCon = Util.connect();
        try {
            PreparedStatement statement = newCon.prepareStatement("DELETE FROM user WHERE id=?");
            statement.setLong(1, id);
            statement.execute();
            newCon.commit();
        } catch (SQLException e) {
            Util.rollback();
        }
        Util.close();

    }

    public List<User> getAllUsers() {
        Connection newCon = Util.connect();
        List<User> users = new ArrayList<>();
        try {
            Statement statement = newCon.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                byte age = resultSet.getByte(4);
                User user = new User(name, lastName, age);
                users.add(user);
            }
            newCon.commit();
            newCon.close();
            return users;
        } catch (SQLException e) {
            Util.rollback();
        }
        Util.close();
        return users;
    }

    public void cleanUsersTable() {
        Connection newCon = Util.connect();

        try {
            PreparedStatement statement = newCon.prepareStatement("DELETE FROM user");
            statement.execute();
            newCon.commit();
        } catch (SQLException e) {
            Util.rollback();
        }
        Util.close();
    }
}
