package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Likes;

import java.util.List;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */

public interface LikesService {
    /**
     * 增加一个点赞记录,删除一个点赞记录,根据用户id查询postid,根据postid查询用户id,判断用户是否点赞了某帖子
     */
    void addRecord(Likes likes);
    void deleteByUID(String userID);
    void deleteByPID(String postID);
    void deleteRecord(String userID, String postID);

    List<Likes> getAllLikes(String userID);
    List<Likes> getAlluser(String postID);

    boolean isLikedByMe(String userID, String postID);
}