package com.spring.domain;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class User implements Serializable {

    @Value("default_user")
    private String username;

    @Value("default_password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
