package com.ynu.makeup_you.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.makeup_you.entity.AdminUser;
import com.ynu.makeup_you.service.AdminUserService;
import com.ynu.makeup_you.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/6/13 0013
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    TokenService tokenService;

    JSONObject jsonObject;

    // 用户登录
    @PostMapping("/login")
    public Object login(AdminUser au){
        jsonObject = new JSONObject();
        AdminUser auBase = adminUserService.findAdminByName(au.getName());
        if (auBase == null){
            jsonObject.put("message","登录失败,管理员不存在!");
            return jsonObject;
        }else{
            if (!auBase.getPassword().equals(au.getPassword())){
                jsonObject.put("message","登录失败,密码错误!");
                return jsonObject;
            }else{
                String token = tokenService.getToken(au);
                jsonObject.put("token",token);
                jsonObject.put("AdminUser",auBase);
                return jsonObject;
            }
        }
    }

    // 查看所有管理员
    @GetMapping("/findAllAdmin")
    public List<AdminUser> findAllAdmin(){
        jsonObject = new JSONObject();
        List<AdminUser> auList = adminUserService.findAllAdmin();
        return auList;
    }

    // 增加管理员
    @PostMapping("/addAdminUser")
    @Transactional
    public Object addAdminUser(AdminUser au){
        jsonObject = new JSONObject();
        if (adminUserService.findAdminByName(au.getName()) == null){
            adminUserService.addAdmin(au);
            jsonObject.put("adminUser",au);
        }else{
            jsonObject.put("message","创建管理员失败,管理员已经存在!");
        }
        return jsonObject;
    }

    // 删除管理员
    @DeleteMapping("/deleteAdminUser")
    @Transactional
    public Object deleteAdminUser(@RequestParam("name") String name){
        jsonObject = new JSONObject();
        if (adminUserService.findAdminByName(name) == null){
            jsonObject.put("message","删除失败,管理员不存在!");
        }else{
            adminUserService.deleteAdmin(name);
            jsonObject.put("message","删除成功!");
        }
        return jsonObject;
    }

    // 更新管理员
    @PutMapping("/updateAdminUser")
    @Transactional
    public Object updateAdminUser(AdminUser au){
        jsonObject = new JSONObject();
        if (adminUserService.findAdminByName(au.getName()) == null){
            jsonObject.put("message","更新失败,管理员不存在!");
        }else{
            adminUserService.updateAdmin(au);
            jsonObject.put("admin",au);
        }
        return jsonObject;
    }
}