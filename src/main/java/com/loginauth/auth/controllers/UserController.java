package com.loginauth.auth.controllers;

import com.loginauth.auth.dao.UserDao;
import com.loginauth.auth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }

    @RequestMapping(value = "api/users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value = "user3")
    public User updateUser() {
        User user = new User();
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }

    @RequestMapping(value = "user2")
    public User deleteUser() {
        User user = new User();
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }

    @RequestMapping(value = "user1")
    public User searchUser() {
        User user = new User();
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }
}
