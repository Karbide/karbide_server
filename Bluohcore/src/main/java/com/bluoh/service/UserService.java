package com.bluoh.service;

import com.bluoh.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Ashutosh on 11-10-2016.
 */
public interface UserService extends UserDetailsService{

    User getRole(String user);

    User getUserbyName(String name);
}
