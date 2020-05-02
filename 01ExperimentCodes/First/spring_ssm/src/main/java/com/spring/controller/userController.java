package com.spring.controller;

import com.spring.domain.User;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.service.userService;
@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService user_service;

    @RequestMapping("/login")
    public String login(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            user_service.verify(user);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "login";
        }
        return "login";
    }

}
