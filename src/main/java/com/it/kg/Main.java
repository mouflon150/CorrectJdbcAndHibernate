package com.it.kg;

import com.it.kg.dao.UserDaoHibernateImpl;
import com.it.kg.service.UserHibernateServiceImpl;
import com.it.kg.service.UserJdbcServiceImpl;
import com.it.kg.service.UserService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserService service = new UserHibernateServiceImpl();

//        service.dropUsersTable();
        service.saveUser("Marlen", "Temirbaev", (byte) 17);
        service.saveUser("Dastan", "Abdullaev", (byte) 15);
        service.saveUser("Daniel", "Ahadzhanov", (byte) 15);
        service.saveUser("Bakyt", "Apsamatov", (byte) 17);
    }
}
