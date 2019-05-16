package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.Likes;
import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.repository.PostMessageRepository;
import com.ynu.makeup_you.repository.UserRepository;
import com.ynu.makeup_you.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     * 得到某用户的所有点赞
     * @param id
     * @return
     */
    @GetMapping("/getLikesForUID/{userid}")
    public List<PostMessage> getFavorites(@PathVariable("userid") Integer id){
        List<Likes> likes_list = likesService.getAllLikes(id);
        List<PostMessage> post_list = new ArrayList<>();
        for (Likes l:likes_list){
            post_list.add(postMessageRepository.findById(l.getPostID()).orElse(null));
        }
        return post_list;
    }

    /**
     * 得到所有点赞此帖子的用户
     * @param id
     * @return
     */
    @GetMapping("/getUsersForPID/{postid}")
    public List<User> getUsers(@PathVariable("postid") Integer id){
        List<Likes> likes_list = likesService.getAlluser(id);
        List<User> user_list = new ArrayList<>();
        for (Likes l:likes_list){
            user_list.add(userRepository.findById(l.getUserID()).orElse(null));
        }
        return user_list;
    }

    /**
     * 增加一条点赞记录
     * @param userID
     * @param postID
     * @param time
     */
    @PostMapping("/addRecord")
    public void addRecord(@RequestParam("userID") Integer userID,
                          @RequestParam("postID") Integer postID,
                          @RequestParam("time") String time){
        Likes likes = new Likes();
        likes.setUserID(userID);
        likes.setPostID(postID);
        likes.setTime(time);
        likesService.addRecord(likes);
    }

    /**
     * 删除一条点赞记录
     * @param uid
     * @param pid
     */

    @DeleteMapping("/deleteRecord/{uid,pid}")
    public void deleteUser(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid){
        likesService.deleteRecord(uid,pid);
    }
}
