package com.example.SpringSecurity.autowride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetBeanFactory {

    @Autowired
    public  AbcStruct abcStruct;

    public SetBeanFactory(){
        abcStruct = new AbcStruct("nghia",18);
    }
    public String getAbcStructName(){
        return abcStruct.getName();
    }

}
