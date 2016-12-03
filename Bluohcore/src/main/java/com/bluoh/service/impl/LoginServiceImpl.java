package com.bluoh.service.impl;

import com.bluoh.model.FbLogin;
import com.bluoh.model.User;
import com.bluoh.repository.UserRepository;
import com.bluoh.service.LoginService;
import com.bluoh.service.UserService;
import com.bluoh.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 14-11-2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository repository;

    @Autowired
    private UserService userService;

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
        user.setGcm_key(login.getGcm_key());
        user.setUtm_campaign(login.getUtm_campaign());
        user.setUtm_content(login.getUtm_content());
        user.setUtm_medium(login.getUtm_medium());
        user.setUtm_source(login.getUtm_source());
        user.setUtm_term(login.getUtm_term());
        User original = userService.getUserbyName(login.getEmail());
        if(original != null){
            Util.copyNonNullProperties(user,original);
            return repository.save(original);
        }
        System.out.println("User Login : " + user.toString());
        User response = repository.save(user);
        return response;
    }
}
