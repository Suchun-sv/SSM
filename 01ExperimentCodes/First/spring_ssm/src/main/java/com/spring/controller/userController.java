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
    public String login(String username, String password, String is_remembered){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("输入为:"+user.getUsername()+" "+user.getPassword());
        if(is_remembered.equals("0"))
        {
            System.out.println("没有默认保存密码！");
            try {
                user_service.verify(user);
            }
            catch (Exception e)
            {
                System.out.println(e);
                return "login";
            }
        }
        else
        {
            System.out.println("保存了密码!");
            try {
                user_service.verify_by_MD5(user);
            }
            catch (Exception e)
            {
                System.out.println(e);
                return "login";
            }
        }

        return "login";
    }

}
