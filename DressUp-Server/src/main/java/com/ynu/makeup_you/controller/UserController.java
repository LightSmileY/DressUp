package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 对用户的增删改查控制
     */

    @Autowired
    private UserService userService;

    /**
     * 增加一个用户
     * @param username
     * @param password
     * @param birthday
     * @param sex
     * @param age
     * @param register_date
     * @param avatarID
     * @param description
     * @param mailbox
     * @param last_login_time
     */

    @PostMapping("/addUser")
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("birthday") String birthday,
                        @RequestParam("sex") Integer sex,
                        @RequestParam("age") Integer age,
                        @RequestParam("register_date") String register_date,
                        @RequestParam("avatarID") String avatarID,
                        @RequestParam("description") String description,
                        @RequestParam("mailbox") String mailbox,
                        @RequestParam("last_login_time") String last_login_time){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setAge(age);
        user.setRegister_date(register_date);
        user.setAvatarID(avatarID);
        user.setDescription(description);
        user.setMailbox(mailbox);
        user.setLast_login_time(last_login_time);
        userService.addUser(user);
    }

    /**
     * 删除一个用户
     * @param id
     */

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    /**
     * 修改用户
     * @param username
     * @param password
     * @param birthday
     * @param sex
     * @param age
     * @param register_date
     * @param avatarID
     * @param description
     * @param mailbox
     * @param last_login_time
     */

    @PutMapping("/updateUser")
    public void updateUser(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("birthday") String birthday,
                           @RequestParam("sex") Integer sex,
                           @RequestParam("age") Integer age,
                           @RequestParam("register_date") String register_date,
                           @RequestParam("avatarID") String avatarID,
                           @RequestParam("description") String description,
                           @RequestParam("mailbox") String mailbox,
                           @RequestParam("last_login_time") String last_login_time){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setAge(age);
        user.setRegister_date(register_date);
        user.setAvatarID(avatarID);
        user.setDescription(description);
        user.setMailbox(mailbox);
        user.setLast_login_time(last_login_time);
        userService.addUser(user);
    }

    /**
     * 查找全部的用户
     * @return
     */

    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    /**
     * 查找特定id的用户
     * @param id
     * @return
     */

    @GetMapping("/findOne/{id}")
    public User findOne(@PathVariable("id") Integer id){
        return userService.findUser(id);
    }

}
