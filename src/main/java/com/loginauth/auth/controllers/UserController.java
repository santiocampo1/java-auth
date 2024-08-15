package com.loginauth.auth.controllers;

import com.loginauth.auth.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Santiago");
        user.setLastName("Ocampo");
        user.setEmail("sanntiocampo@gmail.com");
        user.setPhone("3498408557");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("Santiago");
        user1.setLastName("Ocampo");
        user1.setEmail("sanntiocampo@gmail.com");
        user1.setPhone("3498408557");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Maria");
        user2.setLastName("Gonzales");
        user2.setEmail("mari@gmail.com");
        user2.setPhone("323408557");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Gonzalo");
        user3.setLastName("Ocampo");
        user3.setEmail("gonza@gmail.com");
        user3.setPhone("308557");

        User user4 = new User();
        user4.setId(4L);
        user4.setName("Leo");
        user4.setLastName("Messi");
        user4.setEmail("leitomessi@gmail.com");
        user4.setPhone("3498408557");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
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
