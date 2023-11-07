package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public String userRegister(@RequestBody Map<String,String> input){
        String name = input.get("username");
        String pass = input.get("password");
        String repass = input.get("repassword");
        String hobby = input.get("hobby");
        if(!pass.equals(repass)){
            return "Incorrect password";
        }
        for (User u : userServiceImpl.listAll()){
            if(u.getUsername().equals(name)){
                return "Account existed!";
            }
        }
        userServiceImpl.addUser(new User(name, pass, hobby));
        return "Registered successfully";
    }
}
