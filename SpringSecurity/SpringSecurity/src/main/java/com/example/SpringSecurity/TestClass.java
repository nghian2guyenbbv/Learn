package com.example.SpringSecurity;

import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.autowride.AbcStruct;
import com.example.SpringSecurity.autowride.SetBeanFactory;
import com.example.SpringSecurity.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class TestClass {


    public static void main(String[] args) {
        //System.out.println("abcTestImpl.getName"+ abcTestImpl.getInfo());
        ApplicationContext context = SpringApplication.run(TestClass.class, args);
        //setBean(context);
        getListEnabledUser(context);


    }

    private static void getListEnabledUser(ApplicationContext context) {
        UserService userService = context.getBean(UserService.class);
        List<User> listUser = userService.getListEnabledUser("nghia", 1);
        for (User user : listUser) {
            System.out.println("user :" + user.getUserName());
        }


    }

    private static void setBean(ApplicationContext context) {
        AbcStruct abcStruct = context.getBean(AbcStruct.class);
        abcStruct.setAge(18);
        abcStruct.setName("nghia");
        SetBeanFactory setBeanFactory = context.getBean(SetBeanFactory.class);
        //AbcStruct abcStruct = context.getBean(AbcStruct.class);
        System.out.println("abcStruct: " + setBeanFactory.getAbcStructName());

    }


}
