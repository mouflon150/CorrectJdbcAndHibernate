package com.it.kg.dao;

import com.it.kg.model.User;
import com.it.kg.util.JdbcUtil;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private Connection connection;

    public UserDaoJdbcImpl() throws SQLException {
        connection = new JdbcUtil().getConnection();
    }

    public void createUsersTable() throws SQLException {
        String queryToCreate = """
                create table if not exists users
                (
                    id          serial primary key,
                    first_name  varchar not null,
                    last_name   varchar not null,
                    age         smallint not null
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(queryToCreate);
        statement.close();
        System.out.println("The table was successfully created.");
    }

    public void dropUsersTable() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table users");
            System.out.println("Dropped!");
        } catch (PSQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String firstName, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into users(first_name, last_name, age) values (?, ?, ?)");
        User user = new User();
        user.setFname(firstName);
        user.setLname(lastName);
        user.setAge(age);
        preparedStatement.setString(1, user.getFname());
        preparedStatement.setString(2, user.getLname());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("The user with the name " + firstName + " has been saved.");
    }

    public void removeUserById(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = " + id + ";");
        preparedStatement.executeUpdate();
        System.out.println("User under index " + id + " was successfully removed.");
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from users");
        while (result.next()) {
            User user = new User();
            user.setId(result.getLong("id"));
            user.setFname((result.getString("first_name")));
            user.setLname((result.getString("last_name")));
            user.setAge((byte) result.getInt("age"));
            users.add(user);
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table users");
        System.out.println("Cleared!");
    }
}
