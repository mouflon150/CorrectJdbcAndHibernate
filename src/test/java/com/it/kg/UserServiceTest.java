package com.it.kg;


import com.it.kg.model.User;
import com.it.kg.service.UserService;
import com.it.kg.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    private final String testFirstName = "Kanat";
    private final String testLastName = "Subanov";
    private final byte testAge = 23;

    @Test
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testFirstName, testLastName, testAge);

            User user = userService.getAllUsers().get(0);

            if (!testFirstName.equals(user.getFname())
                    || !testLastName.equals(user.getLname())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testFirstName, testLastName, testAge);
            userService.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testFirstName, testLastName, testAge);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testFirstName, testLastName, testAge);
            userService.cleanUsersTable();

            if (userService.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }
}