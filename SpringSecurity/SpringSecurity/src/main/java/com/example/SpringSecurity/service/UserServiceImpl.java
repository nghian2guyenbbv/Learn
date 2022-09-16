package com.example.SpringSecurity.service;

import com.example.SpringSecurity.Entity.Role;
import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        if (userName != null && !userName.isEmpty()) {
            //userRepository.findBy
            userRepository.findUserByUserName(userName);
        }
        return null;

    }

    @Override
    public List<User> getListEnabledUser(String userName, int enabledFlag) {
        if ((userName != null && !userName.isEmpty()) && (enabledFlag >= 0)) {
            return userRepository.findUsersByUserNameAndEnableFlagOrderByUserNameAsc(userName, enabledFlag);
        }
        return null;
    }

}
