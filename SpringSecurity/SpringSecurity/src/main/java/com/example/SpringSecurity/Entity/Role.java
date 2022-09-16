package com.example.SpringSecurity.Entity;

import javax.persistence.*;
@Entity
@Table(name="APP_ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID")
    private int roleID;
    @Column(name="ROLE_NAME")
    private String roleName;

}
