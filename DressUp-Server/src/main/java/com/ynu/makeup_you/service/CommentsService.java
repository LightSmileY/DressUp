package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Comments;

import java.util.List;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */
public interface CommentsService {

    /**
     * 增加一个评论记录,删除一个评论记录,根据用户id查询postid,根据postid查询用户id
     */
    void addRecord(Comments comments);
    void deleteByUID(String userID);
    void deleteByPID(String postID);
    void deleteRecord(String userID, String postID);

    List<Comments> getAllcommentsOfUser(String userID);
    List<Comments> getAllCommentsOfPostmsg(String postID);
}
