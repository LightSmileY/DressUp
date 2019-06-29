package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Favorites;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface FavoritesService {

    /**
     * 增加一个收藏记录,删除一个收藏记录,根据用户id查询postid,根据postid查询用户id,我是否收藏过此帖子
     */
    void addRecord(Favorites favorites);
    void deleteRecord(String userID, String postID);
    void deleteByUID(String userID);
    void deleteByPID(String postID);
    List<Favorites> getAllfavorites(String userID);
    List<Favorites> getAlluser(String postID);

    boolean isFavoritesByMe(String userID, String postID);
}
