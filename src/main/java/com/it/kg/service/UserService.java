package com.it.kg.service;

import com.it.kg.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(String firstName, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
