package com.bluoh.service.impl;

import com.bluoh.model.FbLogin;
import com.bluoh.model.User;
import com.bluoh.repository.UserRepository;
import com.bluoh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 14-11-2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository repository;

    @Autowired
    public LoginServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(FbLogin login) {
        User user = new User();
        user.setGender(login.getGender());
        user.setName(login.getName());
        user.setUsername(login.getEmail());
        user.setPassword(login.getId());
        user.setPicture(login.getPicture());
        user.setRole(2);
        User response = repository.save(user);
        return response;
    }
}
