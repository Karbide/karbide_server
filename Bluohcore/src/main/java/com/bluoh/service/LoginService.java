package com.bluoh.service;

import com.bluoh.model.FbLogin;
import com.bluoh.model.User;

public interface LoginService {

    User create(FbLogin feedback);

//    List<Feedback> findAll();
}
