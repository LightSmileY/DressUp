package com.ynu.makeup_you.entity;

import javax.persistence.*;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="postmessage")
public class PostMessage {
    @Id
    @GeneratedValue
    private Integer pid;
    @Column(name="post_time")
    private String post_time;
    @Column(name="type")
    private Integer type;
    @Column(name="title")
    private String title;
    @Column(name="messagebody")
    private String messagebody;

    /**
     * Getter and Setter
     */
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }
}
