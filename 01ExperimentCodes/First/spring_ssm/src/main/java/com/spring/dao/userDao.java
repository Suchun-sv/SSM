package com.spring.dao;

import com.spring.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface userDao {
    /**
     * 查询用户by 用户名
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User findByName(String username);

    @Insert("insert into user (username, password) values (#{username}, #{password})")
    boolean saveUser(User user);
}
