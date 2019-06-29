package com.ynu.makeup_you.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.makeup_you.annotation.UserLoginToken;
import com.ynu.makeup_you.entity.*;
import com.ynu.makeup_you.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/6/10 0010
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/appService")
public class AppController {
    @Autowired
    UserService userService;
    @Autowired
    PostMessageService postMessageService;
    @Autowired
    FavoritesService favoritesService;
    @Autowired
    LikesService likesService;
    @Autowired
    CommentsService commentsService;
    @Autowired
    ImageService imageService;
    @Autowired
    RelationService relationService;

    private JSONObject jsonObject;

    // 主页
    @GetMapping("/getMainPage")
    public List<Object> getMainPage(@RequestParam("userID") String uid){
        jsonObject = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        // 查询所有的帖子信息
        List<PostMessage> postList = postMessageService.findAllPosts();
        for (PostMessage pm: postList){
            jsonObject.put("pid",pm.getPid());
            jsonObject.put("uid",pm.getUid());
            jsonObject.put("userHeadURL",userService.getUserByID(pm.getUid()).getAvatarID());
            jsonObject.put("userName",userService.getUserByID(pm.getUid()).getName());
            jsonObject.put("publishTime",pm.getPostTime());
            jsonObject.put("title",pm.getTitle());
            jsonObject.put("content",pm.getMessagebody());
            jsonObject.put("images",imageService.getAllImg(pm.getPid()));
            // 点赞
            jsonObject.put("likes",likesService.getAlluser(pm.getPid()).size());
            // 收藏
            jsonObject.put("favorites",favoritesService.getAlluser(pm.getPid()).size());
            // 当前用户是否点赞
            jsonObject.put("isLike",likesService.isLikedByMe(uid,pm.getPid()));
            // 当前用户是否收藏
            jsonObject.put("isCollection",favoritesService.isFavoritesByMe(uid,pm.getPid()));
            // 我是否关注了这个用户
            jsonObject.put("isAttent",relationService.isFollowed(uid,pm.getUid()));
            // 评论
            List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(pm.getPid());
            List<CommentsShow> commentsShowList = new ArrayList<>();
            for (Comments c:commentsList){
                CommentsShow commentsShow = new CommentsShow(c);
                commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                commentsShowList.add(commentsShow);
            }
            jsonObject.put("comments",commentsShowList);
            jsons.add(jsonObject);
            jsonObject = new JSONObject();
        }
        return jsons;
    }

    // 用户首页
    @GetMapping("/getUserPage")
    public Object getUserPage(@RequestParam("userID") String uid){
        jsonObject = new JSONObject();
        jsonObject.put("userHeadURL",userService.getUserByID(uid).getAvatarID());
        jsonObject.put("userName",userService.getUserByID(uid).getName());
        jsonObject.put("description",userService.getUserByID(uid).getDescription());
        jsonObject.put("likes",likesService.getAllLikes(uid).size());
        jsonObject.put("favorites",favoritesService.getAllfavorites(uid).size());
        jsonObject.put("comments",favoritesService.getAllfavorites(uid));
        jsonObject.put("follows",relationService.findFollows(uid).size());
        jsonObject.put("fans",relationService.findFans(uid).size());
        return jsonObject;
    }

    // 我的帖子
    @GetMapping("/getMyPosts")
    public List<Object> getMyPosts(@RequestParam("userID") String uid){
        jsonObject = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        // 查询所有的帖子信息
        List<PostMessage> postList = postMessageService.findPostsByUid(uid);
        for (PostMessage pm: postList){
            jsonObject.put("pid",pm.getPid());
            jsonObject.put("uid",pm.getUid());
            jsonObject.put("userHeadURL",userService.getUserByID(pm.getUid()).getAvatarID());
            jsonObject.put("userName",userService.getUserByID(pm.getUid()).getName());
            jsonObject.put("publishTime",pm.getPostTime());
            jsonObject.put("title",pm.getTitle());
            jsonObject.put("content",pm.getMessagebody());
            jsonObject.put("images",imageService.getAllImg(pm.getPid()));
            // 点赞
            jsonObject.put("likes",likesService.getAlluser(pm.getPid()).size());
            // 收藏
            jsonObject.put("favorites",favoritesService.getAlluser(pm.getPid()).size());
            // 当前用户是否点赞
            jsonObject.put("isLike",likesService.isLikedByMe(uid,pm.getPid()));
            // 当前用户是否收藏
            jsonObject.put("isCollection",favoritesService.isFavoritesByMe(uid,pm.getPid()));
            // 我是否关注了这个用户
            jsonObject.put("isAttent",relationService.isFollowed(uid,pm.getUid()));
            // 评论
            List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(pm.getPid());
            List<CommentsShow> commentsShowList = new ArrayList<>();
            for (Comments c:commentsList){
                CommentsShow commentsShow = new CommentsShow(c);
                commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                commentsShowList.add(commentsShow);
            }
            jsonObject.put("comments",commentsShowList);
            jsons.add(jsonObject);
            jsonObject = new JSONObject();
        }
        return jsons;
    }

    // 用户首页-我的点赞
    @GetMapping("/getMyLikes")
    public List<Object> getMyLikes(@RequestParam("userID") String userID){
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        List<Likes> likesList = likesService.getAllLikes(userID);
        for (Likes l:likesList){
            jsonObject.put("uid",l.getUserID());
            jsonObject.put("userHeadURL",userService.getUserByID(l.getUserID()).getAvatarID());
            jsonObject.put("userName",userService.getUserByID(l.getUserID()).getName());
            jsonObject.put("time",l.getTime());
            post.put("pid",postMessageService.findPostsByID(l.getPostID()).getPid());
            post.put("userHeadURL",userService.getUserByID(postMessageService.findPostsByID(l.getPostID()).getUid()).getAvatarID());
            post.put("userName",userService.getUserByID(postMessageService.findPostsByID(l.getPostID()).getUid()).getName());
            post.put("publishTime",postMessageService.findPostsByID(l.getPostID()).getPostTime());
            post.put("title",postMessageService.findPostsByID(l.getPostID()).getTitle());
            post.put("content",postMessageService.findPostsByID(l.getPostID()).getMessagebody());
            post.put("images",imageService.getAllImg(postMessageService.findPostsByID(l.getPostID()).getPid()));
            post.put("likes",likesService.getAlluser(postMessageService.findPostsByID(l.getPostID()).getPid()).size());
            post.put("favorites",favoritesService.getAlluser(postMessageService.findPostsByID(l.getPostID()).getPid()).size());
            // 评论
            List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(l.getPostID()).getPid());
            List<CommentsShow> commentsShowList = new ArrayList<>();
            for (Comments c:commentsList){
                CommentsShow commentsShow = new CommentsShow(c);
                commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                commentsShowList.add(commentsShow);
            }
            post.put("comments",commentsShowList);
            jsonObject.put("post",post);
            post = new JSONObject();
            jsons.add(jsonObject);
            jsonObject = new JSONObject();
        }
        return jsons;
    }

    // 用户首页-我的收藏
    @GetMapping("/getMyFavorites")
    public List<Object> getMyFavorites(@RequestParam("userID") String userID){
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        List<Favorites> favoritesList = favoritesService.getAllfavorites(userID);
        for (Favorites f:favoritesList){
            jsonObject.put("uid",f.getUserID());
            jsonObject.put("userHeadURL",userService.getUserByID(f.getUserID()).getAvatarID());
            jsonObject.put("userName",userService.getUserByID(f.getUserID()).getName());
            jsonObject.put("time",f.getTime());
            post.put("pid",postMessageService.findPostsByID(f.getPostID()).getPid());
            post.put("userHeadURL",userService.getUserByID(postMessageService.findPostsByID(f.getPostID()).getUid()).getAvatarID());
            post.put("userName",userService.getUserByID(postMessageService.findPostsByID(f.getPostID()).getUid()).getName());
            post.put("publishTime",postMessageService.findPostsByID(f.getPostID()).getPostTime());
            post.put("title",postMessageService.findPostsByID(f.getPostID()).getTitle());
            post.put("content",postMessageService.findPostsByID(f.getPostID()).getMessagebody());
            post.put("images",imageService.getAllImg(postMessageService.findPostsByID(f.getPostID()).getPid()));
            post.put("likes",likesService.getAlluser(postMessageService.findPostsByID(f.getPostID()).getPid()).size());
            post.put("favorites",favoritesService.getAlluser(postMessageService.findPostsByID(f.getPostID()).getPid()).size());
            // 评论
            List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(f.getPostID()).getPid());
            List<CommentsShow> commentsShowList = new ArrayList<>();
            for (Comments c:commentsList){
                CommentsShow commentsShow = new CommentsShow(c);
                commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                commentsShowList.add(commentsShow);
            }
            post.put("comments",commentsShowList);
            jsonObject.put("post",post);
            post = new JSONObject();
            jsons.add(jsonObject);
            jsonObject = new JSONObject();
        }
        return jsons;
    }

    // 用户首页-我的评论
    @GetMapping("/getMyComments")
    public List<Object> getMyComments(@RequestParam("userID") String userID){
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        List<Comments> CommentsList = commentsService.getAllcommentsOfUser(userID);
        for (Comments c:CommentsList){
            jsonObject.put("uid",c.getUserID());
            jsonObject.put("userHeadURL",userService.getUserByID(c.getUserID()).getAvatarID());
            jsonObject.put("userName",userService.getUserByID(c.getUserID()).getName());
            jsonObject.put("comment",c.getMessage());
            jsonObject.put("time",c.getTime());
            post.put("pid",postMessageService.findPostsByID(c.getPostID()).getPid());
            post.put("userHeadURL",userService.getUserByID(postMessageService.findPostsByID(c.getPostID()).getUid()).getAvatarID());
            post.put("userName",userService.getUserByID(postMessageService.findPostsByID(c.getPostID()).getUid()).getName());
            post.put("publishTime",postMessageService.findPostsByID(c.getPostID()).getPostTime());
            post.put("title",postMessageService.findPostsByID(c.getPostID()).getTitle());
            post.put("content",postMessageService.findPostsByID(c.getPostID()).getMessagebody());
            post.put("images",imageService.getAllImg(postMessageService.findPostsByID(c.getPostID()).getPid()));
            post.put("likes",likesService.getAlluser(postMessageService.findPostsByID(c.getPostID()).getPid()).size());
            post.put("favorites",favoritesService.getAlluser(postMessageService.findPostsByID(c.getPostID()).getPid()).size());
            // 评论
            List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(c.getPostID()).getPid());
            List<CommentsShow> commentsShowList = new ArrayList<>();
            for (Comments comments:commentsList){
                CommentsShow commentsShow = new CommentsShow(comments);
                commentsShow.setUserName(userService.getUserByID(comments.getUserID()).getName());
                commentsShowList.add(commentsShow);
            }
            post.put("comments",commentsShowList);
            jsonObject.put("post",post);
            post = new JSONObject();
            jsons.add(jsonObject);
            jsonObject = new JSONObject();
        }
        return jsons;
    }

    // 点赞我的
    @GetMapping("/getLikesMe")
    public List<Object> getLikesMe(@RequestParam("userID") String userID) {
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        // 查询出该用户的所有帖子
        List<PostMessage> postList = postMessageService.findPostsByUid(userID);
        for (PostMessage pm : postList) {
            // 得到点赞了该帖子的所有点赞信息
            List<Likes> likesList = likesService.getAlluser(pm.getPid());
            for (Likes l : likesList) {
                jsonObject.put("uid", l.getUserID());
                jsonObject.put("userHeadURL", userService.getUserByID(l.getUserID()).getAvatarID());
                jsonObject.put("userName", userService.getUserByID(l.getUserID()).getName());
                jsonObject.put("time", l.getTime());
                post.put("pid", postMessageService.findPostsByID(l.getPostID()).getPid());
                post.put("userHeadURL", userService.getUserByID(postMessageService.findPostsByID(l.getPostID()).getUid()).getAvatarID());
                post.put("userName", userService.getUserByID(postMessageService.findPostsByID(l.getPostID()).getUid()).getName());
                post.put("publishTime", postMessageService.findPostsByID(l.getPostID()).getPostTime());
                post.put("title", postMessageService.findPostsByID(l.getPostID()).getTitle());
                post.put("content", postMessageService.findPostsByID(l.getPostID()).getMessagebody());
                post.put("images",imageService.getAllImg(postMessageService.findPostsByID(l.getPostID()).getPid()));
                post.put("likes", likesService.getAlluser(postMessageService.findPostsByID(l.getPostID()).getPid()).size());
                post.put("favorites", favoritesService.getAlluser(postMessageService.findPostsByID(l.getPostID()).getPid()).size());
                // 评论
                List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(l.getPostID()).getPid());
                List<CommentsShow> commentsShowList = new ArrayList<>();
                for (Comments c : commentsList) {
                    CommentsShow commentsShow = new CommentsShow(c);
                    commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                    commentsShowList.add(commentsShow);
                }
                post.put("comments", commentsShowList);
                jsonObject.put("post", post);
                post = new JSONObject();
                jsons.add(jsonObject);
                jsonObject = new JSONObject();
            }
        }
        return jsons;
    }

    // 收藏我的
    @GetMapping("/getFavoritesMe")
    public List<Object> getFavoritesMe(@RequestParam("userID") String userID) {
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        // 查询出该用户的所有帖子
        List<PostMessage> postList = postMessageService.findPostsByUid(userID);
        for (PostMessage pm : postList) {
            // 得到收藏了该帖子的所有收藏信息
            List<Favorites> favoritesList = favoritesService.getAlluser(pm.getPid());
            for (Favorites f:favoritesList){
                jsonObject.put("uid",f.getUserID());
                jsonObject.put("userHeadURL",userService.getUserByID(f.getUserID()).getAvatarID());
                jsonObject.put("userName",userService.getUserByID(f.getUserID()).getName());
                jsonObject.put("time",f.getTime());
                post.put("pid",postMessageService.findPostsByID(f.getPostID()).getPid());
                post.put("userHeadURL",userService.getUserByID(postMessageService.findPostsByID(f.getPostID()).getUid()).getAvatarID());
                post.put("userName",userService.getUserByID(postMessageService.findPostsByID(f.getPostID()).getUid()).getName());
                post.put("publishTime",postMessageService.findPostsByID(f.getPostID()).getPostTime());
                post.put("title",postMessageService.findPostsByID(f.getPostID()).getTitle());
                post.put("content",postMessageService.findPostsByID(f.getPostID()).getMessagebody());
                post.put("images",imageService.getAllImg(postMessageService.findPostsByID(f.getPostID()).getPid()));
                post.put("likes",likesService.getAlluser(postMessageService.findPostsByID(f.getPostID()).getPid()).size());
                post.put("favorites",favoritesService.getAlluser(postMessageService.findPostsByID(f.getPostID()).getPid()).size());
                // 评论
                List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(f.getPostID()).getPid());
                List<CommentsShow> commentsShowList = new ArrayList<>();
                for (Comments c:commentsList){
                    CommentsShow commentsShow = new CommentsShow(c);
                    commentsShow.setUserName(userService.getUserByID(c.getUserID()).getName());
                    commentsShowList.add(commentsShow);
                }
                post.put("comments",commentsShowList);
                jsonObject.put("post",post);
                post = new JSONObject();
                jsons.add(jsonObject);
                jsonObject = new JSONObject();
            }
        }
        return jsons;
    }

    // 评论我的
    @GetMapping("/getCommentsMe")
    public List<Object> getCommentsMe(@RequestParam("userID") String userID) {
        jsonObject = new JSONObject();
        JSONObject post = new JSONObject();
        List<Object> jsons = new ArrayList<>();
        // 查询出该用户的所有帖子
        List<PostMessage> postList = postMessageService.findPostsByUid(userID);
        for (PostMessage pm : postList) {
            // 得到评论了该帖子的所有评论信息
            List<Comments> CommentsList = commentsService.getAllCommentsOfPostmsg(pm.getPid());
            for (Comments c:CommentsList){
                jsonObject.put("uid",c.getUserID());
                jsonObject.put("userHeadURL",userService.getUserByID(c.getUserID()).getAvatarID());
                jsonObject.put("userName",userService.getUserByID(c.getUserID()).getName());
                jsonObject.put("comment",c.getMessage());
                jsonObject.put("time",c.getTime());
                post.put("pid",postMessageService.findPostsByID(c.getPostID()).getPid());
                post.put("userHeadURL",userService.getUserByID(postMessageService.findPostsByID(c.getPostID()).getUid()).getAvatarID());
                post.put("userName",userService.getUserByID(postMessageService.findPostsByID(c.getPostID()).getUid()).getName());
                post.put("publishTime",postMessageService.findPostsByID(c.getPostID()).getPostTime());
                post.put("title",postMessageService.findPostsByID(c.getPostID()).getTitle());
                post.put("content",postMessageService.findPostsByID(c.getPostID()).getMessagebody());
                post.put("images",imageService.getAllImg(postMessageService.findPostsByID(c.getPostID()).getPid()));
                post.put("likes",likesService.getAlluser(postMessageService.findPostsByID(c.getPostID()).getPid()).size());
                post.put("favorites",favoritesService.getAlluser(postMessageService.findPostsByID(c.getPostID()).getPid()).size());
                // 评论
                List<Comments> commentsList = commentsService.getAllCommentsOfPostmsg(postMessageService.findPostsByID(c.getPostID()).getPid());
                List<CommentsShow> commentsShowList = new ArrayList<>();
                for (Comments comments:commentsList){
                    CommentsShow commentsShow = new CommentsShow(comments);
                    commentsShow.setUserName(userService.getUserByID(comments.getUserID()).getName());
                    commentsShowList.add(commentsShow);
                }
                post.put("comments",commentsShowList);
                jsonObject.put("post",post);
                post = new JSONObject();
                jsons.add(jsonObject);
                jsonObject = new JSONObject();
            }
        }
        return jsons;
    }


}