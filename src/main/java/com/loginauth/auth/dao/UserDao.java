package com.loginauth.auth.dao;

import com.loginauth.auth.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void delete(Long id);
}
