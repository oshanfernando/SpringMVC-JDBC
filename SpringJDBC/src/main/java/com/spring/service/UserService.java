package com.spring.service;

import com.spring.model.User;

public interface UserService {

    public String verifyUser(String email, String password);
    public int createAccount(User user);
}
