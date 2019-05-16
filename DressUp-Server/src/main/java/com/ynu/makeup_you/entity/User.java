package com.ynu.makeup_you.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="user")
public class User {
    /**
     * Id 自增
     */
    @Id
    @GeneratedValue
    private Integer uid;

    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="mailbox")
    private String mailbox;
    @Column(name="sex")
    private Integer sex;
    @Column(name="age")
    private Integer age;
    @Column(name="birthday")
    private String birthday;
    @Column(name="register_date")
    private String register_date;
    @Column(name="avatarID")
    private String avatarID;
    @Column(name="description")
    private String description;
    @Column(name="last_login_time")
    private String last_login_time;

    /**
     * Getter and Setter
     */

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if(birthday == "")
            birthday=null;
        this.birthday = birthday;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(String avatarID) {
        this.avatarID = avatarID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        if(last_login_time == "")
            last_login_time=null;
        this.last_login_time = last_login_time;
    }

}
