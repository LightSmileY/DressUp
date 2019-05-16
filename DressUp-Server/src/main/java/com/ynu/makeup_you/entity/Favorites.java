package com.ynu.makeup_you.entity;

import javax.persistence.*;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="favorites")
@IdClass(FavoritesKey.class)
public class Favorites {

    private Integer userID;
    private Integer postID;
    private String time;

    @Id
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Id
    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    @Id
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
