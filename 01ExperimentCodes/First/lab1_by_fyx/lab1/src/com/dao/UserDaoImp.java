package com.dao;

import com.domain.User;
import org.springframework.stereotype.Repository;

@Repository("udi")
public class UserDaoImp  implements UserDao {

    public User loginUser(User user) {
        String pwd=user.getPassword();
        String nm=user.getUsername();
        if (!nm.equals("张三")|| !pwd.equals("123") ) {
             user=null;
        }
            if(user!=null){
                return user;
        }
            else {
//                throw new RuntimeException("超时，找不到改用户");
                System.out.println("超时，找不到改用户");
                return null;
            }

    }
}
