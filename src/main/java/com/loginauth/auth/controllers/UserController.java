package com.loginauth.auth.controllers;

import com.loginauth.auth.dao.UserDao;
import com.loginauth.auth.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
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

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userDao.delete(id);
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
