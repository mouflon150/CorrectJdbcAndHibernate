package com.it.kg.dao;

import com.it.kg.model.User;
import com.it.kg.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public void dropUsersTable() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User u").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public User getById(long id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            User user = new User();
            user.setFname(name);
            user.setLname(lastName);
            user.setAge(age);
            session.save(user);
        }
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = getById(id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List getAllUsers() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select u from User u").getResultList();
        }
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User u").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
