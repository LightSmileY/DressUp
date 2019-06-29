package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Role;
import com.ynu.makeup_you.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/6/13 0013
 * BY hujianlong
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void addRole(Role r) {
        roleRepository.save(r);
    }

    @Override
    public void deleteRole(String roleCode) {
        roleRepository.deleteById(roleCode);
    }

    @Override
    public void updateRole(Role r) {
        roleRepository.save(r);
    }

    @Override
    public Role findRoleByRoleCode(String roleCode) {
        return roleRepository.findById(roleCode).orElse(null);
    }
}
