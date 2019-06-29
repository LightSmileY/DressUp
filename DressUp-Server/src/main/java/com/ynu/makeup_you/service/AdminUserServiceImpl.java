package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.AdminUser;
import com.ynu.makeup_you.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/6/13 0013
 * BY hujianlong
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserRepository adminUserRepository;
    @Override
    public void addAdmin(AdminUser au) {
        adminUserRepository.save(au);
    }

    @Override
    public void deleteAdmin(String name) {
        adminUserRepository.deleteById(name);
    }

    @Override
    public void updateAdmin(AdminUser au) {
        adminUserRepository.save(au);
    }

    @Override
    public AdminUser findAdminByName(String name) {
        return adminUserRepository.findById(name).orElse(null);
    }

    @Override
    public List<AdminUser> findAllAdmin() {
        return adminUserRepository.findAll();
    }
}
