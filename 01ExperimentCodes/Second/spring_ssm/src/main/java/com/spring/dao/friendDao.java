package com.spring.dao;

import com.spring.domain.Friend;
import com.spring.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface friendDao {
    @Select("select * from my_huckleberry_friends where name = #{name} and user_id = #{id}")
    Friend findByName(@Param(value = "name")String name, @Param(value = "id") int id);

    @Select("select * from my_huckleberry_friends where name like #{name} and user_id=#{id}")
    List<Friend> findByLikeName(@Param(value = "name") String name, @Param(value = "id")int id);

    @Select("select * from my_huckleberry_friends where user_id=#{id}")
    List<Friend> findAll(int id);

    @Insert("insert into my_huckleberry_friends(name, phoneNum, weChat, QQ, address, user_id, birth, gender) values(#{name}, #{phoneNum}, #{weChat}, #{QQ},  #{address}, #{user_id}, #{birth}, #{gender})")
    boolean saveFriend(Friend friend);

    @Delete("delete from my_huckleberry_friends where id = #{id}")
    boolean delFriend(int id);

    @Update("update my_huckleberry_friends set name=#{name}, phoneNum=#{phoneNum}, weChat=#{weChat}, QQ=#{QQ}, address=#{address}, birth=#{birth}, gender=#{gender} where id=#{id}")
    boolean alterFriend(Friend friend);



}
