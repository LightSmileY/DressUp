package com.ynu.makeup_you.entity;

import javax.persistence.*;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="favorites")
@IdClass(CommDoubleKey.class)
public class Favorites {

    private String userID;
    private String postID;
    private String time;

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

    /**
     * 重写toString方法
     */

    @Override
    public String toString() {
        return "favorites{" +
                "userID=" + userID +
                ", postID=" + postID +
                ", time='" + time + '\'' +
                '}';
    }

}
