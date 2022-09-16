package com.example.SpringSecurity.autowrride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbcTestImpl implements AbcTestInf {
    @Autowired
    public AbcStruct abcStruct;

    private String name;

    public AbcTestImpl(AbcStruct abcStruct) {
        this.name = abcStruct.getName();
    }

    @Override
    public String getInfo() {
        //return this.name;
        return abcStruct.getName();
    }
}
