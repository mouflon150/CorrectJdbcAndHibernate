package com.it.kg.service;

import com.it.kg.dao.UserDaoHibernateImpl;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateServiceImpl implements UserService {

    private static final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public void dropUsersTable() throws SQLException {
        userDaoHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String firstName, String lastName, byte age) throws SQLException {
        userDaoHibernate.saveUser(firstName, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    public List getAllUsers() throws SQLException {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userDaoHibernate.cleanUsersTable();
    }
}
