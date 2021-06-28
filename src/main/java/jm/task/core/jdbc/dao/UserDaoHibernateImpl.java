package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session = null;
    private Transaction transaction = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40), " +
                "lastName VARCHAR (40), age INT)").addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createQuery("delete User").executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void saveUser(User user) {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        User user = null;
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        user = session.get(User.class, id);
        if (user != null) {
            session.delete(user);
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        users = (List<User>) session.createQuery("select e from User e").list();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM userTable").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
