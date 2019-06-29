package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.CommDoubleKey2;
import com.ynu.makeup_you.entity.Relation;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.repository.RelationRepository;
import com.ynu.makeup_you.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/5/27 0027
 * BY hujianlong
 */

@Service
public class RelationImpl implements RelationService {
    @Autowired
    RelationRepository relationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addFollow(Relation relation) {
        relationRepository.save(relation);
    }

    @Override
    public void deleteFollow(String fansID, String followID) {
        CommDoubleKey2 commDoubleKey2 = new CommDoubleKey2();
        commDoubleKey2.setFans(fansID);
        commDoubleKey2.setFollows(followID);
        relationRepository.deleteById(commDoubleKey2);
    }

    @Override
    public void deleteByFans(String fansID) {
        relationRepository.deleteByFans(fansID);
    }

    @Override
    public void deleteByFollows(String followsID) {
        relationRepository.deleteByFollows(followsID);
    }

    @Override
    public List<User> findFans(String uid) {
        List<Relation> relations_list = relationRepository.findByFollows(uid);
        List<User> user_list = new ArrayList<>();
        for (Relation r:relations_list){
            user_list.add(userRepository.findById(r.getFans()).orElse(null));
        }
        return user_list;
    }

    @Override
    public List<User> findFollows(String uid) {
        List<Relation> relations_list = relationRepository.findByFans(uid);
        List<User> user_list = new ArrayList<>();
        for (Relation r:relations_list){
            user_list.add(userRepository.findById(r.getFollows()).orElse(null));
        }
        return user_list;
    }

    @Override
    public boolean isFollowed(String fans, String follows) {
        CommDoubleKey2 cdk = new CommDoubleKey2();
        cdk.setFans(fans);
        cdk.setFollows(follows);
        if (relationRepository.findById(cdk).orElse(null) == null){
            return false;
        }else{
            return true;
        }
    }
}
