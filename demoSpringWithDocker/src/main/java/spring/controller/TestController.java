package spring.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="students")
public class TestController {
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String getStudents(ModelMap modelMap){
        return "hello";
    }

}
