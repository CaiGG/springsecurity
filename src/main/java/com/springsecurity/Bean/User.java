package com.springsecurity.bean;


import com.springsecurity.bean.SysRole;

import java.io.Serializable;
import java.util.List;

public class User  implements Serializable{

    private static final long serialVersionUID = 4172367857314592144L;
    private String username;
    private String password;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    List<SysRole> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
