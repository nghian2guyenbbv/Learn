package com.example.SpringSecurity.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="APP_USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private int id;
    @Column(name="user_name")
    private String userName;
    @Column(name="ENCRYPTED_PASSWORD")
    private String encryptedPass;
    @Column(name="ENABLED")
    private int enableFlag;
}
