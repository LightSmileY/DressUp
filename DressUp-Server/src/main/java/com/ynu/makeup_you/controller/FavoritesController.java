package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.repository.PostMessageRepository;
import com.ynu.makeup_you.repository.UserRepository;
import com.ynu.makeup_you.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/5/15 0015
 * BY hujianlong
 */

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 得到某用户的所有收藏
     * @param id
     * @return
     */

    @GetMapping("/getFavoritesForUID/{userid}")
    public List<PostMessage> getFavoritesForUser(@PathVariable("userid") Integer id){
        List<Favorites> favorites_list = favoritesService.getAllfavorites(id);
        List<PostMessage> post_list = new ArrayList<>();
        for (Favorites f:favorites_list){
            post_list.add(postMessageRepository.findById(f.getPostID()).orElse(null));
        }
        return post_list;
    }

    /**
     * 得到所有收藏此帖子的用户
     * @param id
     * @return
     */

    @GetMapping("/getUsersForPID/{postid}")
    public List<User> getUsersForPostmsg(@PathVariable("postid") Integer id){
        List<Favorites> favorites_list = favoritesService.getAlluser(id);
        List<User> user_list = new ArrayList<>();
        for (Favorites f:favorites_list){
            user_list.add(userRepository.findById(f.getUserID()).orElse(null));
        }
        return user_list;
    }


    /**
     * 增加一条收藏记录
     * @param userID
     * @param postID
     */

    @PostMapping("/addRecord")
    public void addRecord(@RequestParam("userID") Integer userID,
                          @RequestParam("postID") Integer postID,
                          @RequestParam("time") String time){
        Favorites favorites = new Favorites();
        favorites.setUserID(userID);
        favorites.setPostID(postID);
        favorites.setTime(time);
        favoritesService.addRecord(favorites);
    }

    /**
     * 删除一条收藏记录
     * @param uid
     * @param pid
     */

    @DeleteMapping("/deleteRecord/{uid,pid}")
    public void deleteRecord(@PathVariable("uid") Integer uid, @PathVariable("pid") Integer pid){
        favoritesService.deleteRecord(uid,pid);
    }



}
