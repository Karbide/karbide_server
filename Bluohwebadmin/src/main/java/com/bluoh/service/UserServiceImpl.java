package com.bluoh.service;

import com.bluoh.model.SecUserDetails;
import com.bluoh.model.User;
import com.bluoh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 11-10-2016.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final MongoOperations mongoOperations;

    @Autowired
    public UserServiceImpl(UserRepository repository, MongoOperations mongoOperations) {
        this.repository = repository;
        this.mongoOperations = mongoOperations;
    }

    //    @Override
    public User getRole(String userId) {
        return repository.findOne(userId);
    }

    @Override
    public User getUserByName(String name) {
        return mongoOperations.findOne(Query.query(Criteria.where("username").is(name)), User.class);
    }

//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails details;
        try {
            User user = getUserByName(username);
            if (user == null) {
                throw new UsernameNotFoundException(username);
            } else {
                details = new SecUserDetails(user);
            }
        }catch (Exception e){
            throw new InternalAuthenticationServiceException(e.getMessage());
        }
        return details;
    }

  /*  @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        UserDetails details;
        try {
            User user = getUserbyName(username);
            if(user == null){
                throw new UsernameNotFoundException("Username "+username+" is not found");
            }
            details = new SecUserDetails(user);
        }catch (Exception e){
            throw new InternalAuthenticationServiceException(e.getMessage());
        }
        if (details == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return details;
    }*/
}