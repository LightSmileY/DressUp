package com.ynu.makeup_you.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@Entity
@Table(name="comments")
@IdClass(CommDoubleKey.class)
public class Comments {
    private String userID;
    private String postID;
    private String time;
    private String message;

    @Id
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Id
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

    /**
     * 重写toString方法
     */

    @Override
    public String toString() {
        return "comments{" +
                "userID=" + userID +
                ", postID=" + postID +
                ", time='" + time + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
