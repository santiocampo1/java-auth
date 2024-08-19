package com.loginauth.auth.controllers;

import com.loginauth.auth.dao.UserDao;
import com.loginauth.auth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) {
        if (userDao.verifyCredentials(user)) {
            return "OK";
        }
        return "FAIL";
    }

}
