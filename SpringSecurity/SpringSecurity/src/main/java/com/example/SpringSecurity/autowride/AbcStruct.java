package com.example.SpringSecurity.autowride;

import org.springframework.stereotype.Component;

@Component

public class AbcStruct {
    public AbcStruct(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name;
    public int age;

    public AbcStruct() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
