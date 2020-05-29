package com.service;

import com.dao.UserDaoImp;
import com.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("usip")
public class UserServiceImp implements UserService {

    @Override
    public User loginUser(User user) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp userDaoImp=app.getBean("udi",UserDaoImp.class);

        User Ust=userDaoImp.loginUser(user);
       return Ust;
    }
}

