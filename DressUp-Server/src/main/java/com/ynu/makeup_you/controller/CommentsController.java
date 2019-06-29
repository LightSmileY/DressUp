package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.Comments;
import com.ynu.makeup_you.repository.PostMessageRepository;
import com.ynu.makeup_you.repository.UserRepository;
import com.ynu.makeup_you.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private UserRepository userRepository;

    // 得到某用户的所有评论
    @GetMapping("/getCommentsByUID")
    public List<Comments> getCommentsForUser(@RequestParam("userID") String id){
        return commentsService.getAllcommentsOfUser(id);
    }

    // 得到此帖子下的所有评论
    @GetMapping("/getCommentsByPID")
    public List<Comments> getCommentsForPostmsg(@RequestParam("postID") String id){
        return commentsService.getAllCommentsOfPostmsg(id);
    }

    // 增加一条评论记录
    @PostMapping("/addRecord")
    @Transactional
    public void addRecord(Comments comments) {
        commentsService.addRecord(comments);
    }

    // 删除一条记录
    @DeleteMapping("/deleteRecord")
    @Transactional
    public void deleteRecord(@RequestParam("userID") String uid, @RequestParam("postID") String pid){
        commentsService.deleteRecord(uid,pid);
    }

}
