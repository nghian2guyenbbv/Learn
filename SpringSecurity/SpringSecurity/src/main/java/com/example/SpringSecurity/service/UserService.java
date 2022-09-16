package com.example.SpringSecurity.service;

import com.example.SpringSecurity.Entity.Role;
import com.example.SpringSecurity.Entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public List<Role> getAllRole();
    public User getUserByUserName(String userName);
    public List<User> getListEnabledUser(String userName, int enabledFlag);

}
