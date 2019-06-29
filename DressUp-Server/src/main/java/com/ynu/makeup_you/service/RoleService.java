package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Role;

/**
 * Created on 2019/6/13 0013
 * BY hujianlong
 */
public interface RoleService {
    void addRole(Role r);
    void deleteRole(String roleCode);
    void updateRole(Role r);
    Role findRoleByRoleCode(String roleCode);
}
