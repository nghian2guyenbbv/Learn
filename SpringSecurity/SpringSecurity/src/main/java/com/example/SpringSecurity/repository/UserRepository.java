package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUserName(String userName);
    public List<User> findUsersByUserNameAndEnableFlagOrderByUserNameAsc(String userName, int enableFlag);
}
