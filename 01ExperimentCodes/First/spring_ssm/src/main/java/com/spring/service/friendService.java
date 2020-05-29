package com.spring.service;

import com.spring.domain.Friend;

import java.util.List;

public interface friendService {
    /**
     * 实现输入框实时跳动
     * @param name
     * @return 和输入框当前输入内容相似的名字
     */
    String[] findAllName(String name, int user_id);

    /**
     * 调用friendDao实现查询
     * @param name
     * @return Friend类型
     */
    Friend findByName(String name, int user_id);

    /**
     * 返回朋友列表
     * @param name
     * @param user_id
     * @return
     */
    List<Friend> findByLikeName(String name, int user_id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean delById(int id);

    /**
     * 根据新信息修改数据库表
     * @param friend
     * @return
     */
    boolean alterFriend(Friend friend);

    /**
     * 添加朋友
     * @param friend
     * @return
     */
    boolean saveFriend(Friend friend);

    List<Friend> findAll(int user_id);

}
