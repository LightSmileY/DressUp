package com.ynu.makeup_you.entity;

/**
 * Created on 2019/6/18 0018
 * BY hujianlong
 */
public class CommentsShow {
    private String userID;
    private String userName;
    private String postID;
    private String time;
    private String message;

    public CommentsShow(){

    }

    public CommentsShow(Comments c) {
        this.userID = c.getUserID();
        this.postID = c.getPostID();
        this.time = c.getTime();
        this.message = c.getMessage();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
