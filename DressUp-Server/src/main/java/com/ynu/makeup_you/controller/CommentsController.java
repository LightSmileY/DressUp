package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.Comments;
import com.ynu.makeup_you.repository.PostMessageRepository;
import com.ynu.makeup_you.repository.UserRepository;
import com.ynu.makeup_you.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 得到某用户的所有评论
     * @param id
     * @return
     */
    @GetMapping("/getCommentsForUID/{userid}")
    public List<Comments> getCommentsForUser(@PathVariable("userid") Integer id){
        return commentsService.getAllcommentsOfUser(id);
    }

    /**
     * 得到此帖子下的所有评论
     * @param id
     * @return
     */
    @GetMapping("/getCommentsForPID/{postid}")
    public List<Comments> getCommentsForPostmsg(@PathVariable("postid") Integer id){
        return commentsService.getAllCommentsOfPostmsg(id);
    }

    /**
     * 增加一条评论记录
     * @param userID
     * @param postID
     * @param time
     * @param msg
     */
    @PostMapping("/addRecord")
    public void addRecord(@RequestParam("userID") Integer userID,
                          @RequestParam("postID") Integer postID,
                          @RequestParam("time") String time,
                          @RequestParam("messages") String msg) {
        Comments comments = new Comments();
        comments.setUserID(userID);
        comments.setPostID(postID);
        comments.setTime(time);
        comments.setMessages(msg);
    }

    /**
     * 删除一条记录
     * @param uid
     * @param pid
     */
    @DeleteMapping("/deleteRecord/{uid,pid}")
    public void deleteRecord(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid){
        commentsService.deleteRecord(uid,pid);
    }

}
