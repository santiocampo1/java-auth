package com.loginauth.auth.controllers;

import com.loginauth.auth.utils.JWTUtil;

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

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) {
        User loguedUser = userDao.getUserByCredentials(user);

        if (loguedUser != null) {

            String tokenJwt = jwtUtil.create(String.valueOf(loguedUser.getId()), loguedUser.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }

}
