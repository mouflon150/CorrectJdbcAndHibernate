package com.it.kg.dao;

import com.it.kg.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    User getById(long id) throws SQLException;

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
