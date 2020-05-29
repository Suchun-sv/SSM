package com.spring.service.Impl;

import com.spring.dao.userDao;
import com.spring.domain.User;
import com.spring.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("userService")
public class userServiceImpl implements userService{

    @Autowired
    private userDao user_dao;

    @Override
    public boolean verify(User user) {
        System.out.println("业务层被启动了.userService:"+user.getUsername()+";");
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
            return true;
        }
        else
        {
//            user_dao.findByName()
            throw new RuntimeException("incorrect username or password!");
        }
    }

    @Override
    public int findUserID(User user) {
        try {
            User _user = user_dao.findByName(user.getUsername());
            return _user.getId();
        }catch (Exception e){
            return -1;
        }


    }

    @Override
    public boolean verify_by_MD5(User user) throws NoSuchAlgorithmException {
        String expire_time = "7";
        String web_key = "2745";
        System.out.println("正在业务层利用MD5进行计算....");
        User getUser = user_dao.findByName(user.getUsername());
        if(getUser == null)
        {
            throw new RuntimeException("user doesn't exits!");
        }
        else{
            System.out.println(getUser);
        }
        String password = getUser.getPassword();
        String Real_MD5 = this.password_to_MD5(user.getUsername(), password, expire_time, web_key);

        if(Real_MD5.equals(user.getPassword()))
        {
            System.out.println("登录成功");
            return true;
        }
        else
        {
//            user_dao.findByName()
            throw new RuntimeException("incorrect username or password!");
        }
    }

    @Override
    public String password_to_MD5(String username, String password, String expire_time, String web_key) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
        String original_string = username+expire_time+web_key+password;
        MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
        md.update(original_string.getBytes());//此处传入要加密的byte类型值
        byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值
        String result="";
        for (int i=0; i<digest.length;i++){
            result+=Integer.toHexString((0x000000ff & digest[i]) | 0xffffff00).substring(6);
        }
        return result;
    }

    @Override
    public Integer saveUser(User user) {
        return user_dao.saveUser(user);

    }
}
