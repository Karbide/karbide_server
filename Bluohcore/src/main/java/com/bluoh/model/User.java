package com.bluoh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ashutosh on 11-10-2016.
 */

@Document
public final class User {

    @Id
    private String id;
    private String username;
    private String password;
    private int Role;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(int role) {
        Role = role;
    }

    public String getUsername() {
        return username;
    }

    public int getRole() {
        return Role;
    }
}
