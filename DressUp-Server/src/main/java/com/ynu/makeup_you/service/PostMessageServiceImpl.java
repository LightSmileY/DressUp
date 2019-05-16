package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.repository.PostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@Service
public class PostMessageServiceImpl implements PostMessageService{

    @Autowired
    private PostMessageRepository postMessageRepository;

    /**
     * 发帖
     */
    @Override
    public void addPost(PostMessage postMessage) {
        postMessageRepository.save(postMessage);
    }

    /**
     * 删除帖
     */
    @Override
    public void deletePost(Integer postid) {
        postMessageRepository.deleteById(postid);
    }

    /**
     * 更新帖子
     */
    @Override
    public void updatePost(PostMessage postMessage) {
        postMessageRepository.save(postMessage);
    }

    /**
     * 查询某一帖子
     */
    @Override
    public PostMessage findPost(Integer postid) {
        return postMessageRepository.findById(postid).orElse(null);
    }

    /**
     * 根据类型查询帖子
     */

    @Override
    public List<PostMessage> findTypesPost(Integer type) {
        return postMessageRepository.findByType(type);
    }

    /**
     *  查询全部的帖子
     */
    @Override
    public List<PostMessage> findAllPost() {
        return postMessageRepository.findAll();
    }

}
