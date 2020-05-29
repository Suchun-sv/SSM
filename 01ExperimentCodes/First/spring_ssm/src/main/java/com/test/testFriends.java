package com.test;

import com.spring.dao.friendDao;
import com.spring.domain.Friend;
import com.spring.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class testFriends {
    @Test
    public void testFind() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
        friendDao friend_dao = session.getMapper(friendDao.class);
        System.out.println(friend_dao.findByName("夏侯音", 1));
        System.out.println(friend_dao.findByLikeName("%夏%", 1));
//        System.out.println(friend_dao.findAll(1));
//        User user = new User();
//        Friend friend = new Friend("张三","13705592519", "18155910909", "2594405419", "黄山市");
//        friend_dao.saveFriend(friend);
//        System.out.println(friend_dao.findByName("张三"));
//        System.out.println(friend_dao.findByLikeName("%夏%"));
//        System.out.println(friend_dao.delFriend(372));
//        Friend friend = friend_dao.findByName("乜建义",1);
//        System.out.println(friend);
//        friend.setGender("男");
//        friend_dao.alterFriend(friend);
//        System.out.println(friend_dao.findByName("乜建义",1));
//        String _name,String _birth,String _gender, String _phoneNum, String _wechat, String _QQ, String _address
        Friend friend = new Friend("张三","2020-05-06","女","17745188169", "12312312333","12312312311", "哈尔滨工程大学", 1);
        friend_dao.saveFriend(friend);
        System.out.println(friend_dao.findByName("张三", 1));

//        user.setUsername("小猪佩奇");
//        user.setPassword("000");
////        user_dao.saveUser(user);
//        System.out.println(user_dao.findByName("abc"));
    }
}
