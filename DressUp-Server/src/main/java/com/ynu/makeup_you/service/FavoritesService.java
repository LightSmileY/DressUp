package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Favorites;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface FavoritesService {

    /**
     * 增加一个收藏记录,删除一个收藏记录,根据用户id查询postid,根据postid查询用户id
     */
    public void addRecord(Favorites favorites);
    public void deleteRecord(Integer userID, Integer postID);

    public List<Favorites> getAllfavorites(Integer userID);
    public List<Favorites> getAlluser(Integer postID);

}
