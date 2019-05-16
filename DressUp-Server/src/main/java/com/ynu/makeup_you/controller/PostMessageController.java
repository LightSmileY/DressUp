package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.service.PostMessageService;
import com.ynu.makeup_you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */

@RestController
@RequestMapping("/post")
public class PostMessageController {
    /**
     * 对用户的增删改查控制
     */

    @Autowired
    private PostMessageService postMessageService;

    /**
     * 发帖
     * @param postTime
     * @param type
     * @param title
     * @param messageBody
     */

    @PostMapping("/addPost")
    public void addPost(@RequestParam("postTime") String postTime,
                        @RequestParam("type") Integer type,
                        @RequestParam("title") String title,
                        @RequestParam("messageBody") String messageBody){
        PostMessage postMessage = new PostMessage();
        postMessage.setPost_time(postTime);
        postMessage.setType(type);
        postMessage.setTitle(title);
        postMessage.setMessagebody(messageBody);
        postMessageService.addPost(postMessage);
    }

    /**
     * 删除帖子
     * @param postid
     */
    @DeleteMapping("/deletePost/{postid}")
    public void deletePost(@PathVariable("postid") Integer postid){
        postMessageService.deletePost(postid);
    }

    /**
     * 更新帖子
     * @param postTime
     * @param type
     * @param title
     * @param messageBody
     */

    @PutMapping("/updatePost")
    public void updatePost(@RequestParam("postTime") String postTime,
                        @RequestParam("type") Integer type,
                        @RequestParam("title") String title,
                        @RequestParam("messageBody") String messageBody){
        PostMessage postMessage = new PostMessage();
        postMessage.setPost_time(postTime);
        postMessage.setType(type);
        postMessage.setTitle(title);
        postMessage.setMessagebody(messageBody);
        postMessageService.updatePost(postMessage);
    }

    /**
     * 根据帖子的id查询
     * @param id
     * @return
     */
    @GetMapping("/findPostByID/{postid}")
    public PostMessage findPostByID(@PathVariable("postid") Integer id){
        return postMessageService.findPost(id);
    }

    /**
     * 根据类型查询帖子
     * @param type
     * @return
     */

    @GetMapping("/findAllTypesPost/{type}")
    public List<PostMessage> findAllTypesPost(@PathVariable("type") Integer type){
        return postMessageService.findTypesPost(type);
    }

}
