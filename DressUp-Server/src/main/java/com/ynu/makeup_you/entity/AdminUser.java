package com.ynu.makeup_you.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 2019/6/13 0013
 * BY hujianlong
 */
@Entity
@Table(name = "admin_user")
public class AdminUser {
    @Id
    private String name;

    private String password;

    private String email;

    private String last_login_time;

    @ManyToMany
    @JoinTable(name = "adminRole",
            joinColumns = @JoinColumn(name = "adminName", referencedColumnName = "name", updatable = false, insertable = false),
            inverseJoinColumns = @JoinColumn(name = "roleCode", referencedColumnName = "roleCode", updatable = false, insertable = false))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", last_login_time='" + last_login_time + '\'' +
                '}';
    }
}
