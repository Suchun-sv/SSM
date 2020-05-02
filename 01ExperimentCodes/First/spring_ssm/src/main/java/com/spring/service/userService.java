package com.spring.service;

import com.spring.domain.User;
import org.springframework.stereotype.Service;


public interface userService {
    /**
     * 查询用户在不在数据库里
     * @param user
     */
    boolean verify(User user);
}
