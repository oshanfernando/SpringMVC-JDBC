package com.spring.DAO;

import com.spring.model.User;

public interface UserDAO {

    public String verifyUser(String email, String password);
    public int createAccount(User user);
}
