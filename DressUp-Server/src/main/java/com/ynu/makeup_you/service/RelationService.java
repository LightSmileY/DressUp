package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Relation;
import com.ynu.makeup_you.entity.User;

import java.util.List;

/**
 * Created on 2019/5/27 0027
 * BY hujianlong
 */
public interface RelationService {
    /**
     * 增加一条关注记录，删除一条关注记录，查询对应用户的所有粉丝，查询对应用户的所有关注,是否关注了对应用户
     */
    void addFollow(Relation relation);
    void deleteFollow(String fansID, String followID);
    void deleteByFans(String fansID);
    void deleteByFollows(String followsID);
    List<User> findFans(String uid);
    List<User> findFollows(String uid);
    boolean isFollowed(String fans, String follows);
}
