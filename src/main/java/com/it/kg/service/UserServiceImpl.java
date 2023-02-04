package com.it.kg.service;

import com.it.kg.dao.UserDaoJdbcImpl;
import com.it.kg.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void createUsersTable() throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.dropUsersTable();
    }

    @Override
    public void saveUser(String firstName, String lastName, byte age) throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.saveUser(firstName, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        return userDaoJdbc.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.cleanUsersTable();
    }
}
