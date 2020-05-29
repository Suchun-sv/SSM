package com.spring.service;

import com.spring.domain.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


public interface userService {
    /**
     * 查询用户在不在数据库里
     * @param user
     */
     boolean verify(User user);

    /**
     * 保存用户
     * @param user
     * @return
     */
     Integer saveUser(User user);

     int findUserID(User user);
    /**
     * 根据MD5值来查询用户在不在数据库里
     * @param user
     * @return
     */
    boolean verify_by_MD5(User user) throws NoSuchAlgorithmException;

    /**
     * 工具方法
     * @param username
     * @param password
     * @param expire_time
     * @param web_key
     * @return
     */
    String password_to_MD5(String username, String password, String expire_time, String web_key) throws NoSuchAlgorithmException;
}
