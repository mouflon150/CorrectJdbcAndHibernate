package com.it.kg.service;

import com.it.kg.dao.UserDaoJdbcImpl;
import com.it.kg.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserJdbcServiceImpl implements UserService {

    private static final UserDaoJdbcImpl userDaoJdbc;

    static {
        try {
            userDaoJdbc = new UserDaoJdbcImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUsersTable() throws SQLException {
        userDaoJdbc.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        userDaoJdbc.dropUsersTable();
    }

    @Override
    public void saveUser(String firstName, String lastName, byte age) throws SQLException {
        userDaoJdbc.saveUser(firstName, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoJdbc.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDaoJdbc.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userDaoJdbc.cleanUsersTable();
    }
}