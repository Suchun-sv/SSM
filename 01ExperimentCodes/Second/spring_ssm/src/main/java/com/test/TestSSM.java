package com.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.spring.dao.userDao;
import com.spring.domain.User;
import java.io.InputStream;

public class TestSSM {
    @Test
    public void testMybatis()throws  Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
        userDao user_dao = session.getMapper(userDao.class);
        System.out.println(user_dao.findByName("abc"));
        User user = new User();
        user.setUsername("小猪佩奇");
        user.setPassword("000");
        System.out.println(user_dao.saveUser(user));
        System.out.println(user.getId());
//        System.out.println(user_dao.findByName("小猪佩奇"));
    }

}
