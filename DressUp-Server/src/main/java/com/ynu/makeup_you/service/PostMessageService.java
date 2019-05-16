package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.PostMessage;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
public interface PostMessageService {
    /**
     * 发帖、删除帖子、编辑帖子、根据id查询帖子，根据类型查询帖子，查询全部的帖子
     */
    public void addPost(PostMessage postMessage);
    public void deletePost(Integer postid);
    public void updatePost(PostMessage postMessage);
    public PostMessage findPost(Integer postid);
    public List<PostMessage> findTypesPost(Integer type);
    public List<PostMessage> findAllPost();
}
