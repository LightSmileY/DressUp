package com.ynu.makeup_you.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.makeup_you.annotation.UserLoginToken;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.service.TokenService;
import com.ynu.makeup_you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 * 对用户进行操作的Controller，包括用户注册，用户登录，用户信息更改，注销用户，查询用户
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    TokenService tokenService;

    JSONObject jsonObject;

    // 用户注册
    @PostMapping("/register")
    @Transactional
    public Object registerUser(User user){
        jsonObject = new JSONObject();
        User userBase = userService.getUserByID(user.getUid());
        if (userBase != null){
            jsonObject.put("message","注册失败,用户已经存在!");
        }else {
            userService.addUser(user);
            jsonObject.put("message","注册成功!");
        }
        return jsonObject;
    }

    // 删除用户
    @DeleteMapping("/delete")
    @Transactional
    public Object deleteUser(@RequestParam("userID") String id){
        jsonObject = new JSONObject();
        if (userService.getUserByID(id) == null){
            jsonObject.put("message","用户不存在,删除失败!");
        }else{
            userService.deleteUser(id);
            jsonObject.put("message","删除成功!");
        }
        return jsonObject;
    }

    // 更新用户
    @PutMapping("/update")
    @Transactional
    public Object updateUser(User user){
        jsonObject = new JSONObject();
        userService.updateUser(user);
        jsonObject.put("message","更新成功!");
        return jsonObject;
    }

    // 根据用户名查用户
    @GetMapping("/findUserByName")
    public User findUserByName(@RequestParam("name") String name){
        return userService.getUserByName(name);
    }

    // 根据用户id查询用户
    @GetMapping("/findUserByID")
    public User findUserByID(@RequestParam("userID") String id){
        return userService.getUserByID(id);
    }

    // 查询系统内存储的所有用户
    @GetMapping("/findAllUsers")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    // 用户登录
    @PostMapping("/login")
    public Object login(User user){
        jsonObject = new JSONObject();
        User userBase = userService.getUserByID(user.getUid());
        if (userBase == null){
            jsonObject.put("message","登录失败,用户不存在!");
            return jsonObject;
        }else{
            if (!userBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误!");
                return jsonObject;
            }else{
                String token = tokenService.getToken(userBase);
                jsonObject.put("token",token);
                jsonObject.put("user",userBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已经通过验证";
    }

}