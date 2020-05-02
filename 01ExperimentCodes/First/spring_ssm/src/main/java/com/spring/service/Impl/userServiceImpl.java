package com.spring.service.Impl;

import com.spring.dao.userDao;
import com.spring.domain.User;
import com.spring.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class userServiceImpl implements userService{

    @Autowired
    private userDao user_dao;

    @Override
    public boolean verify(User user) {
        System.out.println("业务层被启动了.userService");
        User getUser = user_dao.findByName(user.getUsername());
        if(getUser == null)
        {
            throw new RuntimeException("user doesn't exits!");
        }
        else{
            System.out.println(getUser);
        }

        if(getUser.getPassword().equals(user.getPassword()))
        {
            System.out.println("登录成功");
        }
        else
        {
//            user_dao.findByName()
            throw new RuntimeException("incorrect username or password!");
        }
        return false;
    }
}
