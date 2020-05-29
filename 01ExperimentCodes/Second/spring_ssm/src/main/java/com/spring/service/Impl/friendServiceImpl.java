package com.spring.service.Impl;

import com.spring.dao.friendDao;
import com.spring.domain.Friend;
import com.spring.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("friendService")
@Scope
public class friendServiceImpl implements friendService {
    @Autowired
    friendDao friend_dao;

    @Override
    public String[] findAllName(String name, int user_id) {
        name = "%"+name+"%";
        List<Friend> f = friend_dao.findByLikeName(name, user_id);
        if(f.size()>=1){
            String[] names = new String[f.size()];
            for(int i=0;i<f.size();i++){
                names[i] = f.get(i).getName();
            }
            return names;
        }
        else{
            return new String[0];
        }

    }

    @Override
    public List<Friend> findByLikeName(String name, int user_id) {
        name = "%"+name+"%";
        List<Friend> f = friend_dao.findByLikeName(name, user_id);
        return f;
    }

    @Override
    public Friend findByName(String name, int id) {
        Friend friend = friend_dao.findByName(name,id);
        return friend;
    }

    @Override
    public boolean delById(int id) {
        if(friend_dao.delFriend(id)) {
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean alterFriend(Friend friend) {
        if(friend_dao.alterFriend(friend)){
//            System.out.println("已完成修改");
            return true;
        }
        else {
//            System.out.println("未完成修改");
            return false;
        }
    }

    @Override
    public List<Friend> findAll(int user_id) {
        return friend_dao.findAll(user_id);

    }

    @Override
    public boolean saveFriend(Friend friend) {
        if(friend_dao.saveFriend(friend)){
            return true;
        }
        else {
            return false;
        }
    }

}
