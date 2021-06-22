package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "password";
    private static Connection connection;

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException throwables) {
            throw new RuntimeException("Не удалось подключиться к БД ", throwables);
            // throwables.printStackTrace();
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
