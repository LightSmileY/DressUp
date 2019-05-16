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
    public void addRecord(Comments comments);
    public void deleteRecord(Integer userID, Integer postID);

    public List<Comments> getAllcommentsOfUser(Integer userID);
    public List<Comments> getAllCommentsOfPostmsg(Integer postID);
}
