package com.spring.service;


import com.spring.DAO.UserDAO;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public String verifyUser(String email, String password) {
        return userDAO.verifyUser(email,password);
    }

    @Override
    public int createAccount(User user) {
        return userDAO.createAccount(user);
    }
}
